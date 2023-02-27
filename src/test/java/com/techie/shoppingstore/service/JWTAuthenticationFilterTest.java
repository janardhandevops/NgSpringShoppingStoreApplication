package com.techie.shoppingstore.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.CoyoteOutputStream;

import org.apache.catalina.connector.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.support.ContextExposingHttpServletRequest;

@ContextConfiguration(classes = {JWTAuthenticationFilter.class})
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class JWTAuthenticationFilterTest {
    @Autowired
    private JWTAuthenticationFilter jWTAuthenticationFilter;

    @MockBean
    private JwtTokenProvider jwtTokenProvider;

    @MockBean
    private UserDetailServiceImpl userDetailServiceImpl;

    /**
     * Method under test: {@link JWTAuthenticationFilter#doFilterInternal(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, FilterChain)}
     */
    @Test
    public void testDoFilterInternal() throws IOException, ServletException {
        MockHttpServletRequest mockHttpServletRequest = new MockHttpServletRequest();
        Response response = new Response();
        FilterChain filterChain = mock(FilterChain.class);
        doNothing().when(filterChain).doFilter((javax.servlet.ServletRequest) any(), (javax.servlet.ServletResponse) any());
        this.jWTAuthenticationFilter.doFilterInternal(mockHttpServletRequest, response, filterChain);
        verify(filterChain).doFilter((javax.servlet.ServletRequest) any(), (javax.servlet.ServletResponse) any());
        assertFalse(mockHttpServletRequest.isRequestedSessionIdFromURL());
        assertTrue(mockHttpServletRequest.isRequestedSessionIdFromCookie());
        assertFalse(mockHttpServletRequest.isAsyncSupported());
        assertFalse(mockHttpServletRequest.isAsyncStarted());
        assertTrue(mockHttpServletRequest.isActive());
        assertTrue(mockHttpServletRequest.getSession() instanceof org.springframework.mock.web.MockHttpSession);
        assertEquals("", mockHttpServletRequest.getServletPath());
        assertEquals(80, mockHttpServletRequest.getServerPort());
        assertEquals("localhost", mockHttpServletRequest.getServerName());
        assertEquals("http", mockHttpServletRequest.getScheme());
        assertEquals("", mockHttpServletRequest.getRequestURI());
        assertEquals(80, mockHttpServletRequest.getRemotePort());
        assertEquals("localhost", mockHttpServletRequest.getRemoteHost());
        assertEquals("127.0.0.1", mockHttpServletRequest.getRemoteAddr());
        assertEquals("HTTP/1.1", mockHttpServletRequest.getProtocol());
        assertEquals("", mockHttpServletRequest.getMethod());
        assertEquals(80, mockHttpServletRequest.getLocalPort());
        assertEquals("localhost", mockHttpServletRequest.getLocalName());
        assertEquals("127.0.0.1", mockHttpServletRequest.getLocalAddr());
        assertTrue(
                mockHttpServletRequest.getInputStream() instanceof org.springframework.mock.web.DelegatingServletInputStream);
        assertEquals(DispatcherType.REQUEST, mockHttpServletRequest.getDispatcherType());
        assertEquals("", mockHttpServletRequest.getContextPath());
        assertEquals(-1L, mockHttpServletRequest.getContentLengthLong());
    }

    /**
     * Method under test: {@link JWTAuthenticationFilter#doFilterInternal(javax.servlet.http.HttpServletRequest, HttpServletResponse, FilterChain)}
     */
    @Test
    public void testDoFilterInternal2() throws IOException, ServletException {
        Response response = new Response();
        FilterChain filterChain = mock(FilterChain.class);
        doNothing().when(filterChain).doFilter((javax.servlet.ServletRequest) any(), (javax.servlet.ServletResponse) any());
        this.jWTAuthenticationFilter.doFilterInternal(null, response, filterChain);
        verify(filterChain).doFilter((javax.servlet.ServletRequest) any(), (javax.servlet.ServletResponse) any());
        HttpServletResponse response1 = response.getResponse();
        assertTrue(response1 instanceof org.apache.catalina.connector.ResponseFacade);
        assertTrue(response.getReporter() instanceof org.apache.catalina.connector.CoyoteWriter);
        assertSame(response.getOutputStream(), response1.getOutputStream());
        assertTrue(this.jWTAuthenticationFilter
                .getEnvironment() instanceof org.springframework.web.context.support.StandardServletEnvironment);
    }

    /**
     * Method under test: {@link JWTAuthenticationFilter#doFilterInternal(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, FilterChain)}
     */
    @Test
    public void testDoFilterInternal3() throws IOException, ServletException {
        ContextExposingHttpServletRequest contextExposingHttpServletRequest = mock(ContextExposingHttpServletRequest.class);
        when(contextExposingHttpServletRequest.getHeader((String) any())).thenReturn("https://example.org/example");
        Response response = new Response();
        FilterChain filterChain = mock(FilterChain.class);
        doNothing().when(filterChain).doFilter((javax.servlet.ServletRequest) any(), (javax.servlet.ServletResponse) any());
        this.jWTAuthenticationFilter.doFilterInternal(contextExposingHttpServletRequest, response, filterChain);
        verify(contextExposingHttpServletRequest).getHeader((String) any());
        verify(filterChain).doFilter((javax.servlet.ServletRequest) any(), (javax.servlet.ServletResponse) any());
    }

    /**
     * Method under test: {@link JWTAuthenticationFilter#doFilterInternal(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, FilterChain)}
     */
    @Test
    public void testDoFilterInternal4() throws IOException, ServletException {
        ContextExposingHttpServletRequest contextExposingHttpServletRequest = mock(ContextExposingHttpServletRequest.class);
        when(contextExposingHttpServletRequest.getHeader((String) any())).thenReturn("Bearer ");
        Response response = new Response();
        FilterChain filterChain = mock(FilterChain.class);
        doNothing().when(filterChain).doFilter((javax.servlet.ServletRequest) any(), (javax.servlet.ServletResponse) any());
        this.jWTAuthenticationFilter.doFilterInternal(contextExposingHttpServletRequest, response, filterChain);
        verify(contextExposingHttpServletRequest).getHeader((String) any());
        verify(filterChain).doFilter((javax.servlet.ServletRequest) any(), (javax.servlet.ServletResponse) any());
    }
}

