package com.techie.shoppingstore.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techie.shoppingstore.dto.AuthenticationResponse;
import com.techie.shoppingstore.dto.LoginRequestDto;
import com.techie.shoppingstore.dto.RegisterRequestDto;
import com.techie.shoppingstore.exceptions.ApiResponse;
import com.techie.shoppingstore.service.AuthService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {AuthController.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AuthControllerTest {
    @Autowired
    private AuthController authController;

    @MockBean
    private AuthService authService;

    /**
     * Method under test: {@link AuthController#verifyAccount(String)}
     */
    @Test
    public void testVerifyAccount() throws Exception {
        when(this.authService.verifyAccount((String) any())).thenReturn(new ApiResponse());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/auth/accountVerification/{token}",
                "ABC123");
        MockMvcBuilders.standaloneSetup(this.authController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content().string("{\"status\":null,\"message\":null}"));
    }

    /**
     * Method under test: {@link AuthController#login(LoginRequestDto)}
     */
    @Test
    public void testLogin() throws Exception {
        when(this.authService.authenticate((LoginRequestDto) any()))
                .thenReturn(new AuthenticationResponse("ABC123", "janedoe"));

        LoginRequestDto loginRequestDto = new LoginRequestDto();
        loginRequestDto.setPassword("iloveyou");
        loginRequestDto.setUsername("janedoe");
        String content = (new ObjectMapper()).writeValueAsString(loginRequestDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.authController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content().string("{\"accessToken\":\"ABC123\",\"username\":\"janedoe\"}"));
    }

    /**
     * Method under test: {@link AuthController#updateUser(RegisterRequestDto, String)}
     */
    @Test
    public void testUpdateUser() throws Exception {
        when(this.authService.updateUser((RegisterRequestDto) any(), (String) any())).thenReturn(new ApiResponse());

        RegisterRequestDto registerRequestDto = new RegisterRequestDto();
        registerRequestDto.setConfirmPassword("iloveyou");
        registerRequestDto.setEmail("jane.doe@example.org");
        registerRequestDto.setName("Name");
        registerRequestDto.setPassword("iloveyou");
        registerRequestDto.setUsername("janedoe");
        String content = (new ObjectMapper()).writeValueAsString(registerRequestDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/auth/users/{userId}", "42")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.authController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content().string("{\"status\":null,\"message\":null}"));
    }

    /**
     * Method under test: {@link AuthController#register(RegisterRequestDto)}
     */
    @Test
    public void testRegister() throws Exception {
        when(this.authService.existsByUserName((RegisterRequestDto) any())).thenReturn(true);
        doNothing().when(this.authService).createUser((RegisterRequestDto) any());

        RegisterRequestDto registerRequestDto = new RegisterRequestDto();
        registerRequestDto.setConfirmPassword("iloveyou");
        registerRequestDto.setEmail("jane.doe@example.org");
        registerRequestDto.setName("Name");
        registerRequestDto.setPassword("iloveyou");
        registerRequestDto.setUsername("janedoe");
        String content = (new ObjectMapper()).writeValueAsString(registerRequestDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/auth/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.authController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400))
                .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content().string("{\"status\":400,\"message\":\"Username already exists\"}"));
    }

    /**
     * Method under test: {@link AuthController#register(RegisterRequestDto)}
     */
    @Test
    public void testRegister2() throws Exception {
        when(this.authService.existsByUserName((RegisterRequestDto) any())).thenReturn(false);
        doNothing().when(this.authService).createUser((RegisterRequestDto) any());

        RegisterRequestDto registerRequestDto = new RegisterRequestDto();
        registerRequestDto.setConfirmPassword("iloveyou");
        registerRequestDto.setEmail("jane.doe@example.org");
        registerRequestDto.setName("Name");
        registerRequestDto.setPassword("iloveyou");
        registerRequestDto.setUsername("janedoe");
        String content = (new ObjectMapper()).writeValueAsString(registerRequestDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/auth/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.authController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"status\":200,\"message\":\"User Registration Completed Successfully!!\"}"));
    }
}

