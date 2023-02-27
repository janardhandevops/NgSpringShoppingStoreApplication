package com.techie.shoppingstore.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.techie.shoppingstore.dto.LoginRequestDto;
import com.techie.shoppingstore.dto.RegisterRequestDto;
import com.techie.shoppingstore.exceptions.ApiResponse;
import com.techie.shoppingstore.exceptions.SpringStoreException;
import com.techie.shoppingstore.model.VerificationToken;
import com.techie.shoppingstore.repository.UserRepository;
import com.techie.shoppingstore.repository.VerificationTokenRepository;

import java.time.Instant;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {AuthService.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AuthServiceTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Autowired
    private AuthService authService;

    @MockBean
    private AuthenticationManager authenticationManager;

    @MockBean
    private JwtTokenProvider jwtTokenProvider;

    @MockBean
    private MailContentBuilder mailContentBuilder;

    @MockBean
    private MailService mailService;

    @MockBean
    private PasswordEncoder passwordEncoder;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private VerificationTokenRepository verificationTokenRepository;

    /**
     * Method under test: {@link AuthService#existsByUserName(RegisterRequestDto)}
     */
    @Test
    public void testExistsByUserName() {
        when(this.userRepository.existsByUsername((String) any())).thenReturn(true);

        RegisterRequestDto registerRequestDto = new RegisterRequestDto();
        registerRequestDto.setConfirmPassword("iloveyou");
        registerRequestDto.setEmail("jane.doe@example.org");
        registerRequestDto.setName("Name");
        registerRequestDto.setPassword("iloveyou");
        registerRequestDto.setUsername("janedoe");
        assertTrue(this.authService.existsByUserName(registerRequestDto));
        verify(this.userRepository).existsByUsername((String) any());
    }

    /**
     * Method under test: {@link AuthService#existsByUserName(RegisterRequestDto)}
     */
    @Test
    public void testExistsByUserName2() {
        when(this.userRepository.existsByUsername((String) any())).thenReturn(false);

        RegisterRequestDto registerRequestDto = new RegisterRequestDto();
        registerRequestDto.setConfirmPassword("iloveyou");
        registerRequestDto.setEmail("jane.doe@example.org");
        registerRequestDto.setName("Name");
        registerRequestDto.setPassword("iloveyou");
        registerRequestDto.setUsername("janedoe");
        assertFalse(this.authService.existsByUserName(registerRequestDto));
        verify(this.userRepository).existsByUsername((String) any());
    }

    /**
     * Method under test: {@link AuthService#existsByUserName(RegisterRequestDto)}
     */
    @Test
    public void testExistsByUserName3() {
        when(this.userRepository.existsByUsername((String) any())).thenThrow(new SpringStoreException("An error occurred"));

        RegisterRequestDto registerRequestDto = new RegisterRequestDto();
        registerRequestDto.setConfirmPassword("iloveyou");
        registerRequestDto.setEmail("jane.doe@example.org");
        registerRequestDto.setName("Name");
        registerRequestDto.setPassword("iloveyou");
        registerRequestDto.setUsername("janedoe");
        thrown.expect(SpringStoreException.class);
        this.authService.existsByUserName(registerRequestDto);
        verify(this.userRepository).existsByUsername((String) any());
    }

    /**
     * Method under test: {@link AuthService#createUser(RegisterRequestDto)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testCreateUser() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.techie.shoppingstore.service.MailContentBuilder.build(MailContentBuilder.java:20)
        //       at com.techie.shoppingstore.service.AuthService.createUser(AuthService.java:70)
        //   In order to prevent createUser(RegisterRequestDto)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   createUser(RegisterRequestDto).
        //   See https://diff.blue/R013 to resolve this issue.

        com.techie.shoppingstore.model.User user = new com.techie.shoppingstore.model.User();
        user.setEmail("jane.doe@example.org");
        user.setEnabled(true);
        user.setId("42");
        user.setPassword("iloveyou");
        user.setPasswordConfirmation("Password Confirmation");
        user.setUsername("janedoe");

        VerificationToken verificationToken = new VerificationToken();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        verificationToken.setExpiryDate(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
        verificationToken.setId("42");
        verificationToken.setToken("ABC123");
        verificationToken.setUser(user);
        when(this.verificationTokenRepository.save((VerificationToken) any())).thenReturn(verificationToken);

        com.techie.shoppingstore.model.User user1 = new com.techie.shoppingstore.model.User();
        user1.setEmail("jane.doe@example.org");
        user1.setEnabled(true);
        user1.setId("42");
        user1.setPassword("iloveyou");
        user1.setPasswordConfirmation("Password Confirmation");
        user1.setUsername("janedoe");
        when(this.userRepository.save((com.techie.shoppingstore.model.User) any())).thenReturn(user1);
        when(this.passwordEncoder.encode((CharSequence) any())).thenReturn("secret");

        RegisterRequestDto registerRequestDto = new RegisterRequestDto();
        registerRequestDto.setConfirmPassword("iloveyou");
        registerRequestDto.setEmail("jane.doe@example.org");
        registerRequestDto.setName("Name");
        registerRequestDto.setPassword("iloveyou");
        registerRequestDto.setUsername("janedoe");
        this.authService.createUser(registerRequestDto);
    }

    /**
     * Method under test: {@link AuthService#createUser(RegisterRequestDto)}
     */
    @Test
    public void testCreateUser2() {
        com.techie.shoppingstore.model.User user = new com.techie.shoppingstore.model.User();
        user.setEmail("jane.doe@example.org");
        user.setEnabled(true);
        user.setId("42");
        user.setPassword("iloveyou");
        user.setPasswordConfirmation("Password Confirmation");
        user.setUsername("janedoe");

        VerificationToken verificationToken = new VerificationToken();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        verificationToken.setExpiryDate(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
        verificationToken.setId("42");
        verificationToken.setToken("ABC123");
        verificationToken.setUser(user);
        when(this.verificationTokenRepository.save((VerificationToken) any())).thenReturn(verificationToken);

        com.techie.shoppingstore.model.User user1 = new com.techie.shoppingstore.model.User();
        user1.setEmail("jane.doe@example.org");
        user1.setEnabled(true);
        user1.setId("42");
        user1.setPassword("iloveyou");
        user1.setPasswordConfirmation("Password Confirmation");
        user1.setUsername("janedoe");
        when(this.userRepository.save((com.techie.shoppingstore.model.User) any())).thenReturn(user1);
        when(this.passwordEncoder.encode((CharSequence) any())).thenThrow(new SpringStoreException("An error occurred"));

        RegisterRequestDto registerRequestDto = new RegisterRequestDto();
        registerRequestDto.setConfirmPassword("iloveyou");
        registerRequestDto.setEmail("jane.doe@example.org");
        registerRequestDto.setName("Name");
        registerRequestDto.setPassword("iloveyou");
        registerRequestDto.setUsername("janedoe");
        thrown.expect(SpringStoreException.class);
        this.authService.createUser(registerRequestDto);
        verify(this.passwordEncoder).encode((CharSequence) any());
    }

    /**
     * Method under test: {@link AuthService#authenticate(LoginRequestDto)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testAuthenticate() throws AuthenticationException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.techie.shoppingstore.service.JwtTokenProvider.getPrivateKey(JwtTokenProvider.java:59)
        //       at com.techie.shoppingstore.service.JwtTokenProvider.generateToken(JwtTokenProvider.java:53)
        //       at com.techie.shoppingstore.service.AuthService.authenticate(AuthService.java:101)
        //   In order to prevent authenticate(LoginRequestDto)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   authenticate(LoginRequestDto).
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.authenticationManager.authenticate((org.springframework.security.core.Authentication) any()))
                .thenReturn(new TestingAuthenticationToken(new User("janedoe", "iloveyou", new ArrayList<>()), "Credentials"));

        LoginRequestDto loginRequestDto = new LoginRequestDto();
        loginRequestDto.setPassword("iloveyou");
        loginRequestDto.setUsername("janedoe");
        this.authService.authenticate(loginRequestDto);
    }

    /**
     * Method under test: {@link AuthService#authenticate(LoginRequestDto)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testAuthenticate2() throws AuthenticationException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.techie.shoppingstore.service.JwtTokenProvider.generateToken(JwtTokenProvider.java:50)
        //       at com.techie.shoppingstore.service.AuthService.authenticate(AuthService.java:101)
        //   In order to prevent authenticate(LoginRequestDto)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   authenticate(LoginRequestDto).
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.authenticationManager.authenticate((org.springframework.security.core.Authentication) any()))
                .thenReturn(new TestingAuthenticationToken(null, "Credentials"));

        LoginRequestDto loginRequestDto = new LoginRequestDto();
        loginRequestDto.setPassword("iloveyou");
        loginRequestDto.setUsername("janedoe");
        this.authService.authenticate(loginRequestDto);
    }

    /**
     * Method under test: {@link AuthService#authenticate(LoginRequestDto)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testAuthenticate3() throws AuthenticationException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.techie.shoppingstore.service.JwtTokenProvider.generateToken(JwtTokenProvider.java:44)
        //       at com.techie.shoppingstore.service.AuthService.authenticate(AuthService.java:101)
        //   In order to prevent authenticate(LoginRequestDto)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   authenticate(LoginRequestDto).
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.authenticationManager.authenticate((Authentication) any())).thenReturn(null);

        LoginRequestDto loginRequestDto = new LoginRequestDto();
        loginRequestDto.setPassword("iloveyou");
        loginRequestDto.setUsername("janedoe");
        this.authService.authenticate(loginRequestDto);
    }

    /**
     * Method under test: {@link AuthService#getCurrentUser()}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testGetCurrentUser() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.techie.shoppingstore.service.AuthService.getCurrentUser(AuthService.java:106)
        //   In order to prevent getCurrentUser()
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getCurrentUser().
        //   See https://diff.blue/R013 to resolve this issue.

        this.authService.getCurrentUser();
    }

    /**
     * Method under test: {@link AuthService#verifyAccount(String)}
     */
    @Test
    public void testVerifyAccount() {
        com.techie.shoppingstore.model.User user = new com.techie.shoppingstore.model.User();
        user.setEmail("jane.doe@example.org");
        user.setEnabled(true);
        user.setId("42");
        user.setPassword("iloveyou");
        user.setPasswordConfirmation("Password Confirmation");
        user.setUsername("janedoe");

        VerificationToken verificationToken = new VerificationToken();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        verificationToken.setExpiryDate(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
        verificationToken.setId("42");
        verificationToken.setToken("ABC123");
        verificationToken.setUser(user);
        Optional<VerificationToken> ofResult = Optional.of(verificationToken);
        when(this.verificationTokenRepository.findByToken((String) any())).thenReturn(ofResult);

        com.techie.shoppingstore.model.User user1 = new com.techie.shoppingstore.model.User();
        user1.setEmail("jane.doe@example.org");
        user1.setEnabled(true);
        user1.setId("42");
        user1.setPassword("iloveyou");
        user1.setPasswordConfirmation("Password Confirmation");
        user1.setUsername("janedoe");
        Optional<com.techie.shoppingstore.model.User> ofResult1 = Optional.of(user1);

        com.techie.shoppingstore.model.User user2 = new com.techie.shoppingstore.model.User();
        user2.setEmail("jane.doe@example.org");
        user2.setEnabled(true);
        user2.setId("42");
        user2.setPassword("iloveyou");
        user2.setPasswordConfirmation("Password Confirmation");
        user2.setUsername("janedoe");
        when(this.userRepository.save((com.techie.shoppingstore.model.User) any())).thenReturn(user2);
        when(this.userRepository.findByUsername((String) any())).thenReturn(ofResult1);
        ApiResponse actualVerifyAccountResult = this.authService.verifyAccount("ABC123");
        assertEquals("User is Enabled", actualVerifyAccountResult.getMessage());
        assertEquals(200, actualVerifyAccountResult.getStatus().intValue());
        verify(this.verificationTokenRepository).findByToken((String) any());
        verify(this.userRepository).save((com.techie.shoppingstore.model.User) any());
        verify(this.userRepository).findByUsername((String) any());
    }

    /**
     * Method under test: {@link AuthService#verifyAccount(String)}
     */
    @Test
    public void testVerifyAccount2() {
        com.techie.shoppingstore.model.User user = new com.techie.shoppingstore.model.User();
        user.setEmail("jane.doe@example.org");
        user.setEnabled(true);
        user.setId("42");
        user.setPassword("iloveyou");
        user.setPasswordConfirmation("Password Confirmation");
        user.setUsername("janedoe");

        VerificationToken verificationToken = new VerificationToken();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        verificationToken.setExpiryDate(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
        verificationToken.setId("42");
        verificationToken.setToken("ABC123");
        verificationToken.setUser(user);
        Optional<VerificationToken> ofResult = Optional.of(verificationToken);
        when(this.verificationTokenRepository.findByToken((String) any())).thenReturn(ofResult);

        com.techie.shoppingstore.model.User user1 = new com.techie.shoppingstore.model.User();
        user1.setEmail("jane.doe@example.org");
        user1.setEnabled(true);
        user1.setId("42");
        user1.setPassword("iloveyou");
        user1.setPasswordConfirmation("Password Confirmation");
        user1.setUsername("janedoe");
        Optional<com.techie.shoppingstore.model.User> ofResult1 = Optional.of(user1);
        when(this.userRepository.save((com.techie.shoppingstore.model.User) any()))
                .thenThrow(new SpringStoreException("An error occurred"));
        when(this.userRepository.findByUsername((String) any())).thenReturn(ofResult1);
        thrown.expect(SpringStoreException.class);
        this.authService.verifyAccount("ABC123");
        verify(this.verificationTokenRepository).findByToken((String) any());
        verify(this.userRepository).save((com.techie.shoppingstore.model.User) any());
        verify(this.userRepository).findByUsername((String) any());
    }

    /**
     * Method under test: {@link AuthService#verifyAccount(String)}
     */
    @Test
    public void testVerifyAccount3() {
        when(this.verificationTokenRepository.findByToken((String) any())).thenReturn(Optional.empty());

        com.techie.shoppingstore.model.User user = new com.techie.shoppingstore.model.User();
        user.setEmail("jane.doe@example.org");
        user.setEnabled(true);
        user.setId("42");
        user.setPassword("iloveyou");
        user.setPasswordConfirmation("Password Confirmation");
        user.setUsername("janedoe");

        com.techie.shoppingstore.model.User user1 = new com.techie.shoppingstore.model.User();
        user1.setEmail("jane.doe@example.org");
        user1.setEnabled(true);
        user1.setId("42");
        user1.setPassword("iloveyou");
        user1.setPasswordConfirmation("Password Confirmation");
        user1.setUsername("janedoe");
        VerificationToken verificationToken = mock(VerificationToken.class);
        when(verificationToken.getUser()).thenReturn(user1);
        doNothing().when(verificationToken).setExpiryDate((Instant) any());
        doNothing().when(verificationToken).setId((String) any());
        doNothing().when(verificationToken).setToken((String) any());
        doNothing().when(verificationToken).setUser((com.techie.shoppingstore.model.User) any());
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        verificationToken.setExpiryDate(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
        verificationToken.setId("42");
        verificationToken.setToken("ABC123");
        verificationToken.setUser(user);

        com.techie.shoppingstore.model.User user2 = new com.techie.shoppingstore.model.User();
        user2.setEmail("jane.doe@example.org");
        user2.setEnabled(true);
        user2.setId("42");
        user2.setPassword("iloveyou");
        user2.setPasswordConfirmation("Password Confirmation");
        user2.setUsername("janedoe");
        Optional<com.techie.shoppingstore.model.User> ofResult = Optional.of(user2);

        com.techie.shoppingstore.model.User user3 = new com.techie.shoppingstore.model.User();
        user3.setEmail("jane.doe@example.org");
        user3.setEnabled(true);
        user3.setId("42");
        user3.setPassword("iloveyou");
        user3.setPasswordConfirmation("Password Confirmation");
        user3.setUsername("janedoe");
        when(this.userRepository.save((com.techie.shoppingstore.model.User) any())).thenReturn(user3);
        when(this.userRepository.findByUsername((String) any())).thenReturn(ofResult);
        ApiResponse actualVerifyAccountResult = this.authService.verifyAccount("ABC123");
        assertEquals("Invalid Token", actualVerifyAccountResult.getMessage());
        assertEquals(400, actualVerifyAccountResult.getStatus().intValue());
        verify(this.verificationTokenRepository).findByToken((String) any());
        verify(verificationToken).setExpiryDate((Instant) any());
        verify(verificationToken).setId((String) any());
        verify(verificationToken).setToken((String) any());
        verify(verificationToken).setUser((com.techie.shoppingstore.model.User) any());
    }

    /**
     * Method under test: {@link AuthService#verifyAccount(String)}
     */
    @Test
    public void testVerifyAccount4() {
        com.techie.shoppingstore.model.User user = new com.techie.shoppingstore.model.User();
        user.setEmail("jane.doe@example.org");
        user.setEnabled(true);
        user.setId("42");
        user.setPassword("iloveyou");
        user.setPasswordConfirmation("Password Confirmation");
        user.setUsername("janedoe");

        com.techie.shoppingstore.model.User user1 = new com.techie.shoppingstore.model.User();
        user1.setEmail("jane.doe@example.org");
        user1.setEnabled(true);
        user1.setId("42");
        user1.setPassword("iloveyou");
        user1.setPasswordConfirmation("Password Confirmation");
        user1.setUsername("janedoe");
        VerificationToken verificationToken = mock(VerificationToken.class);
        when(verificationToken.getUser()).thenReturn(user1);
        doNothing().when(verificationToken).setExpiryDate((Instant) any());
        doNothing().when(verificationToken).setId((String) any());
        doNothing().when(verificationToken).setToken((String) any());
        doNothing().when(verificationToken).setUser((com.techie.shoppingstore.model.User) any());
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        verificationToken.setExpiryDate(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
        verificationToken.setId("42");
        verificationToken.setToken("ABC123");
        verificationToken.setUser(user);
        Optional<VerificationToken> ofResult = Optional.of(verificationToken);
        when(this.verificationTokenRepository.findByToken((String) any())).thenReturn(ofResult);

        com.techie.shoppingstore.model.User user2 = new com.techie.shoppingstore.model.User();
        user2.setEmail("jane.doe@example.org");
        user2.setEnabled(true);
        user2.setId("42");
        user2.setPassword("iloveyou");
        user2.setPasswordConfirmation("Password Confirmation");
        user2.setUsername("janedoe");
        when(this.userRepository.save((com.techie.shoppingstore.model.User) any())).thenReturn(user2);
        when(this.userRepository.findByUsername((String) any())).thenReturn(Optional.empty());
        thrown.expect(SpringStoreException.class);
        this.authService.verifyAccount("ABC123");
        verify(this.verificationTokenRepository).findByToken((String) any());
        verify(verificationToken).getUser();
        verify(verificationToken).setExpiryDate((Instant) any());
        verify(verificationToken).setId((String) any());
        verify(verificationToken).setToken((String) any());
        verify(verificationToken).setUser((com.techie.shoppingstore.model.User) any());
        verify(this.userRepository).findByUsername((String) any());
    }

    /**
     * Method under test: {@link AuthService#updateUser(RegisterRequestDto, String)}
     */
    @Test
    public void testUpdateUser() {
        com.techie.shoppingstore.model.User user = new com.techie.shoppingstore.model.User();
        user.setEmail("jane.doe@example.org");
        user.setEnabled(true);
        user.setId("42");
        user.setPassword("iloveyou");
        user.setPasswordConfirmation("Password Confirmation");
        user.setUsername("janedoe");
        Optional<com.techie.shoppingstore.model.User> ofResult = Optional.of(user);

        com.techie.shoppingstore.model.User user1 = new com.techie.shoppingstore.model.User();
        user1.setEmail("jane.doe@example.org");
        user1.setEnabled(true);
        user1.setId("42");
        user1.setPassword("iloveyou");
        user1.setPasswordConfirmation("Password Confirmation");
        user1.setUsername("janedoe");
        when(this.userRepository.save((com.techie.shoppingstore.model.User) any())).thenReturn(user1);
        when(this.userRepository.findById((String) any())).thenReturn(ofResult);
        when(this.passwordEncoder.encode((CharSequence) any())).thenReturn("secret");

        RegisterRequestDto registerRequestDto = new RegisterRequestDto();
        registerRequestDto.setConfirmPassword("iloveyou");
        registerRequestDto.setEmail("jane.doe@example.org");
        registerRequestDto.setName("Name");
        registerRequestDto.setPassword("iloveyou");
        registerRequestDto.setUsername("janedoe");
        ApiResponse actualUpdateUserResult = this.authService.updateUser(registerRequestDto, "42");
        assertEquals("User is Enabled", actualUpdateUserResult.getMessage());
        assertEquals(200, actualUpdateUserResult.getStatus().intValue());
        verify(this.userRepository).save((com.techie.shoppingstore.model.User) any());
        verify(this.userRepository).findById((String) any());
        verify(this.passwordEncoder, atLeast(1)).encode((CharSequence) any());
    }

    /**
     * Method under test: {@link AuthService#updateUser(RegisterRequestDto, String)}
     */
    @Test
    public void testUpdateUser2() {
        com.techie.shoppingstore.model.User user = new com.techie.shoppingstore.model.User();
        user.setEmail("jane.doe@example.org");
        user.setEnabled(true);
        user.setId("42");
        user.setPassword("iloveyou");
        user.setPasswordConfirmation("Password Confirmation");
        user.setUsername("janedoe");
        Optional<com.techie.shoppingstore.model.User> ofResult = Optional.of(user);

        com.techie.shoppingstore.model.User user1 = new com.techie.shoppingstore.model.User();
        user1.setEmail("jane.doe@example.org");
        user1.setEnabled(true);
        user1.setId("42");
        user1.setPassword("iloveyou");
        user1.setPasswordConfirmation("Password Confirmation");
        user1.setUsername("janedoe");
        when(this.userRepository.save((com.techie.shoppingstore.model.User) any())).thenReturn(user1);
        when(this.userRepository.findById((String) any())).thenReturn(ofResult);
        when(this.passwordEncoder.encode((CharSequence) any())).thenThrow(new SpringStoreException("An error occurred"));

        RegisterRequestDto registerRequestDto = new RegisterRequestDto();
        registerRequestDto.setConfirmPassword("iloveyou");
        registerRequestDto.setEmail("jane.doe@example.org");
        registerRequestDto.setName("Name");
        registerRequestDto.setPassword("iloveyou");
        registerRequestDto.setUsername("janedoe");
        thrown.expect(SpringStoreException.class);
        this.authService.updateUser(registerRequestDto, "42");
        verify(this.userRepository).findById((String) any());
        verify(this.passwordEncoder).encode((CharSequence) any());
    }

    /**
     * Method under test: {@link AuthService#updateUser(RegisterRequestDto, String)}
     */
    @Test
    public void testUpdateUser3() {
        com.techie.shoppingstore.model.User user = new com.techie.shoppingstore.model.User();
        user.setEmail("jane.doe@example.org");
        user.setEnabled(true);
        user.setId("42");
        user.setPassword("iloveyou");
        user.setPasswordConfirmation("Password Confirmation");
        user.setUsername("janedoe");
        when(this.userRepository.save((com.techie.shoppingstore.model.User) any())).thenReturn(user);
        when(this.userRepository.findById((String) any())).thenReturn(null);
        when(this.passwordEncoder.encode((CharSequence) any())).thenReturn("secret");

        RegisterRequestDto registerRequestDto = new RegisterRequestDto();
        registerRequestDto.setConfirmPassword("iloveyou");
        registerRequestDto.setEmail("jane.doe@example.org");
        registerRequestDto.setName("Name");
        registerRequestDto.setPassword("iloveyou");
        registerRequestDto.setUsername("janedoe");
        ApiResponse actualUpdateUserResult = this.authService.updateUser(registerRequestDto, "42");
        assertEquals("Invalid Token", actualUpdateUserResult.getMessage());
        assertEquals(400, actualUpdateUserResult.getStatus().intValue());
        verify(this.userRepository).findById((String) any());
    }

    /**
     * Method under test: {@link AuthService#updateUser(RegisterRequestDto, String)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testUpdateUser4() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.util.NoSuchElementException: No value present
        //       at java.util.Optional.get(Optional.java:135)
        //       at com.techie.shoppingstore.service.AuthService.updateUser(AuthService.java:131)
        //   In order to prevent updateUser(RegisterRequestDto, String)
        //   from throwing NoSuchElementException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   updateUser(RegisterRequestDto, String).
        //   See https://diff.blue/R013 to resolve this issue.

        com.techie.shoppingstore.model.User user = new com.techie.shoppingstore.model.User();
        user.setEmail("jane.doe@example.org");
        user.setEnabled(true);
        user.setId("42");
        user.setPassword("iloveyou");
        user.setPasswordConfirmation("Password Confirmation");
        user.setUsername("janedoe");
        when(this.userRepository.save((com.techie.shoppingstore.model.User) any())).thenReturn(user);
        when(this.userRepository.findById((String) any())).thenReturn(Optional.empty());
        when(this.passwordEncoder.encode((CharSequence) any())).thenReturn("secret");

        RegisterRequestDto registerRequestDto = new RegisterRequestDto();
        registerRequestDto.setConfirmPassword("iloveyou");
        registerRequestDto.setEmail("jane.doe@example.org");
        registerRequestDto.setName("Name");
        registerRequestDto.setPassword("iloveyou");
        registerRequestDto.setUsername("janedoe");
        this.authService.updateUser(registerRequestDto, "42");
    }
}

