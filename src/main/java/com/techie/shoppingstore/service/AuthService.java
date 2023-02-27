package com.techie.shoppingstore.service;

import com.techie.shoppingstore.dto.AuthenticationResponse;
import com.techie.shoppingstore.dto.LoginRequestDto;
import com.techie.shoppingstore.dto.RegisterRequestDto;
import com.techie.shoppingstore.exceptions.ApiResponse;
import com.techie.shoppingstore.exceptions.SpringStoreException;
import com.techie.shoppingstore.model.User;
import com.techie.shoppingstore.model.VerificationToken;
import com.techie.shoppingstore.repository.UserRepository;
import com.techie.shoppingstore.repository.VerificationTokenRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class AuthService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    @Autowired
    private MailContentBuilder mailContentBuilder;
    @Autowired
    private MailService mailService;
    @Autowired
    private VerificationTokenRepository verificationTokenRepository;
    @Value("${account.verification.url}")
    private String accountVerificationUrl;

    public boolean existsByUserName(RegisterRequestDto registerRequestDto) {
        return userRepository.existsByUsername(registerRequestDto.getUsername());
    }

//    @Autowired
//    private JavaMailSender javaMailSender;

    public void createUser(RegisterRequestDto registerRequestDto) {
        String encodedPassword = passwordEncoder.encode(registerRequestDto.getPassword());

        User user = new User(registerRequestDto.getEmail(),
                registerRequestDto.getUsername(),
                encodedPassword);
        user.setEnabled(false);
        userRepository.save(user);
        log.info("Saved User to Database, sending activation email");

        String token = generateVerificationToken(user);
        String message = mailContentBuilder.build("Thank you for signing up to Spring Store, please click on the below url to activate your account : "
                + accountVerificationUrl + "/" + token);

        mailService.sendMail(user.getEmail(), message);

//        SimpleMailMessage msg = new SimpleMailMessage();
//         msg.setTo(user.getEmail());
//         msg.setSubject("demo");
//         msg.setText("Purchased new asset");
//         javaMailSender.send(msg);

        log.info("Activation email sent!!");
    }

    private String generateVerificationToken(User user) {
        String token = UUID.randomUUID().toString();
        VerificationToken verificationToken = new VerificationToken();
        verificationToken.setToken(token);
        verificationToken.setUser(user);
        verificationTokenRepository.save(verificationToken);
        return token;
    }

    public AuthenticationResponse authenticate(LoginRequestDto loginRequestDto) {
        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequestDto.getUsername(),
                        loginRequestDto.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authenticate);
        String accessToken = jwtTokenProvider.generateToken(authenticate);
        return new AuthenticationResponse(accessToken, loginRequestDto.getUsername());
    }

    public Optional<org.springframework.security.core.userdetails.User> getCurrentUser() {
        org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return Optional.of(principal);
    }

    public ApiResponse verifyAccount(String token) {
        Optional<VerificationToken> verificationTokenOptional = verificationTokenRepository.findByToken(token);
        if (verificationTokenOptional.isPresent()) {
            fetchUserAndEnable(verificationTokenOptional.get());
            return new ApiResponse(200, "User is Enabled");
        } else {
            return new ApiResponse(400, "Invalid Token");
        }
    }

    private void fetchUserAndEnable(VerificationToken verificationToken) {
        String username = verificationToken.getUser().getUsername();
        User user = userRepository.findByUsername(username).orElseThrow(() -> new SpringStoreException("User Not Found with id - " + username));
        user.setEnabled(true);
        userRepository.save(user);
    }

    public ApiResponse updateUser(RegisterRequestDto registerRequestDto, String userId){
       Optional<User> value = userRepository.findById(userId);
//        ApiResponse apiResponse=new ApiResponse();
        if(value!=null){
           User user=value.get();
            user.setEmail(registerRequestDto.getEmail());
            user.setPassword(passwordEncoder.encode(registerRequestDto.getPassword()));
            user.setPasswordConfirmation(passwordEncoder.encode(registerRequestDto.getConfirmPassword()));
            user.setUsername(registerRequestDto.getUsername());
            userRepository.save(user);
            return new ApiResponse(200, "User is Enabled");
        }
        else{
            return new ApiResponse(400, "Invalid Token");
        }
    }




}
