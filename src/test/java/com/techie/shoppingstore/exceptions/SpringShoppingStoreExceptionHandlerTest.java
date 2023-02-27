package com.techie.shoppingstore.exceptions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.ServletWebRequest;

public class SpringShoppingStoreExceptionHandlerTest {
    /**
     * Method under test: default or parameterless constructor of {@link SpringShoppingStoreExceptionHandler}
     */
    @Test
    public void testConstructor() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     ResponseEntityExceptionHandler.logger

        new SpringShoppingStoreExceptionHandler();
    }

    /**
     * Method under test: {@link SpringShoppingStoreExceptionHandler#handleHttpMessageNotReadable(HttpMessageNotReadableException, HttpHeaders, HttpStatus, org.springframework.web.context.request.WebRequest)}
     */
    @Test
    public void testHandleHttpMessageNotReadable() {
        SpringShoppingStoreExceptionHandler springShoppingStoreExceptionHandler = new SpringShoppingStoreExceptionHandler();
        HttpMessageNotReadableException exception = new HttpMessageNotReadableException("https://example.org/example");
        HttpHeaders headers = new HttpHeaders();
        ResponseEntity<Object> actualHandleHttpMessageNotReadableResult = springShoppingStoreExceptionHandler
                .handleHttpMessageNotReadable(exception, headers, HttpStatus.CONTINUE,
                        new ServletWebRequest(new MockHttpServletRequest()));
        assertTrue(actualHandleHttpMessageNotReadableResult.hasBody());
        assertTrue(actualHandleHttpMessageNotReadableResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.BAD_REQUEST, actualHandleHttpMessageNotReadableResult.getStatusCode());
        assertEquals("https://example.org/example",
                ((ApiResponse) actualHandleHttpMessageNotReadableResult.getBody()).getMessage());
        assertEquals(400, ((ApiResponse) actualHandleHttpMessageNotReadableResult.getBody()).getStatus().intValue());
    }

    /**
     * Method under test: {@link SpringShoppingStoreExceptionHandler#handleHttpMessageNotReadable(HttpMessageNotReadableException, HttpHeaders, HttpStatus, org.springframework.web.context.request.WebRequest)}
     */
    @Test
    public void testHandleHttpMessageNotReadable2() {
        SpringShoppingStoreExceptionHandler springShoppingStoreExceptionHandler = new SpringShoppingStoreExceptionHandler();
        HttpMessageNotReadableException exception = new HttpMessageNotReadableException(null);
        HttpHeaders headers = new HttpHeaders();
        ResponseEntity<Object> actualHandleHttpMessageNotReadableResult = springShoppingStoreExceptionHandler
                .handleHttpMessageNotReadable(exception, headers, HttpStatus.CONTINUE,
                        new ServletWebRequest(new MockHttpServletRequest()));
        assertTrue(actualHandleHttpMessageNotReadableResult.hasBody());
        assertTrue(actualHandleHttpMessageNotReadableResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.BAD_REQUEST, actualHandleHttpMessageNotReadableResult.getStatusCode());
        assertEquals("HttpMessageNotReadableException",
                ((ApiResponse) actualHandleHttpMessageNotReadableResult.getBody()).getMessage());
        assertEquals(400, ((ApiResponse) actualHandleHttpMessageNotReadableResult.getBody()).getStatus().intValue());
    }

    /**
     * Method under test: {@link SpringShoppingStoreExceptionHandler#handleHttpMessageNotReadable(HttpMessageNotReadableException, HttpHeaders, HttpStatus, org.springframework.web.context.request.WebRequest)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testHandleHttpMessageNotReadable3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.techie.shoppingstore.exceptions.SpringShoppingStoreExceptionHandler.message(SpringShoppingStoreExceptionHandler.java:26)
        //       at com.techie.shoppingstore.exceptions.SpringShoppingStoreExceptionHandler.handleHttpMessageNotReadable(SpringShoppingStoreExceptionHandler.java:22)
        //   In order to prevent handleHttpMessageNotReadable(HttpMessageNotReadableException, HttpHeaders, HttpStatus, WebRequest)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   handleHttpMessageNotReadable(HttpMessageNotReadableException, HttpHeaders, HttpStatus, WebRequest).
        //   See https://diff.blue/R013 to resolve this issue.

        SpringShoppingStoreExceptionHandler springShoppingStoreExceptionHandler = new SpringShoppingStoreExceptionHandler();
        HttpHeaders headers = new HttpHeaders();
        springShoppingStoreExceptionHandler.handleHttpMessageNotReadable(null, headers, HttpStatus.CONTINUE,
                new ServletWebRequest(new MockHttpServletRequest()));
    }

    /**
     * Method under test: {@link SpringShoppingStoreExceptionHandler#handleHttpMessageNotReadable(HttpMessageNotReadableException, HttpHeaders, HttpStatus, org.springframework.web.context.request.WebRequest)}
     */
    @Test
    public void testHandleHttpMessageNotReadable4() {
        SpringShoppingStoreExceptionHandler springShoppingStoreExceptionHandler = new SpringShoppingStoreExceptionHandler();
        HttpMessageNotReadableException exception = new HttpMessageNotReadableException("https://example.org/example");

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("https://example.org/example", "https://example.org/example");
        ResponseEntity<Object> actualHandleHttpMessageNotReadableResult = springShoppingStoreExceptionHandler
                .handleHttpMessageNotReadable(exception, httpHeaders, HttpStatus.CONTINUE,
                        new ServletWebRequest(new MockHttpServletRequest()));
        assertTrue(actualHandleHttpMessageNotReadableResult.hasBody());
        assertEquals(1, actualHandleHttpMessageNotReadableResult.getHeaders().size());
        assertEquals(HttpStatus.BAD_REQUEST, actualHandleHttpMessageNotReadableResult.getStatusCode());
        assertEquals("https://example.org/example",
                ((ApiResponse) actualHandleHttpMessageNotReadableResult.getBody()).getMessage());
        assertEquals(400, ((ApiResponse) actualHandleHttpMessageNotReadableResult.getBody()).getStatus().intValue());
    }

    /**
     * Method under test: {@link SpringShoppingStoreExceptionHandler#handleHttpMessageNotReadable(HttpMessageNotReadableException, HttpHeaders, HttpStatus, org.springframework.web.context.request.WebRequest)}
     */
    @Test
    public void testHandleHttpMessageNotReadable5() {
        SpringShoppingStoreExceptionHandler springShoppingStoreExceptionHandler = new SpringShoppingStoreExceptionHandler();
        HttpMessageNotReadableException exception = new HttpMessageNotReadableException("https://example.org/example");
        HttpHeaders headers = new HttpHeaders();
        ResponseEntity<Object> actualHandleHttpMessageNotReadableResult = springShoppingStoreExceptionHandler
                .handleHttpMessageNotReadable(exception, headers, HttpStatus.SWITCHING_PROTOCOLS,
                        new ServletWebRequest(new MockHttpServletRequest()));
        assertTrue(actualHandleHttpMessageNotReadableResult.hasBody());
        assertTrue(actualHandleHttpMessageNotReadableResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.BAD_REQUEST, actualHandleHttpMessageNotReadableResult.getStatusCode());
        assertEquals("https://example.org/example",
                ((ApiResponse) actualHandleHttpMessageNotReadableResult.getBody()).getMessage());
        assertEquals(400, ((ApiResponse) actualHandleHttpMessageNotReadableResult.getBody()).getStatus().intValue());
    }

    /**
     * Method under test: {@link SpringShoppingStoreExceptionHandler#handleHttpMessageNotReadable(HttpMessageNotReadableException, HttpHeaders, HttpStatus, org.springframework.web.context.request.WebRequest)}
     */
    @Test
    public void testHandleHttpMessageNotReadable6() {
        SpringShoppingStoreExceptionHandler springShoppingStoreExceptionHandler = new SpringShoppingStoreExceptionHandler();
        HttpMessageNotReadableException exception = new HttpMessageNotReadableException("https://example.org/example");
        HttpHeaders headers = new HttpHeaders();
        ResponseEntity<Object> actualHandleHttpMessageNotReadableResult = springShoppingStoreExceptionHandler
                .handleHttpMessageNotReadable(exception, headers, HttpStatus.PROCESSING,
                        new ServletWebRequest(new MockHttpServletRequest()));
        assertTrue(actualHandleHttpMessageNotReadableResult.hasBody());
        assertTrue(actualHandleHttpMessageNotReadableResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.BAD_REQUEST, actualHandleHttpMessageNotReadableResult.getStatusCode());
        assertEquals("https://example.org/example",
                ((ApiResponse) actualHandleHttpMessageNotReadableResult.getBody()).getMessage());
        assertEquals(400, ((ApiResponse) actualHandleHttpMessageNotReadableResult.getBody()).getStatus().intValue());
    }

    /**
     * Method under test: {@link SpringShoppingStoreExceptionHandler#handleHttpMessageNotReadable(HttpMessageNotReadableException, HttpHeaders, HttpStatus, org.springframework.web.context.request.WebRequest)}
     */
    @Test
    public void testHandleHttpMessageNotReadable7() {
        SpringShoppingStoreExceptionHandler springShoppingStoreExceptionHandler = new SpringShoppingStoreExceptionHandler();
        HttpMessageNotReadableException exception = new HttpMessageNotReadableException("https://example.org/example");
        HttpHeaders headers = new HttpHeaders();
        ResponseEntity<Object> actualHandleHttpMessageNotReadableResult = springShoppingStoreExceptionHandler
                .handleHttpMessageNotReadable(exception, headers, HttpStatus.CHECKPOINT,
                        new ServletWebRequest(new MockHttpServletRequest()));
        assertTrue(actualHandleHttpMessageNotReadableResult.hasBody());
        assertTrue(actualHandleHttpMessageNotReadableResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.BAD_REQUEST, actualHandleHttpMessageNotReadableResult.getStatusCode());
        assertEquals("https://example.org/example",
                ((ApiResponse) actualHandleHttpMessageNotReadableResult.getBody()).getMessage());
        assertEquals(400, ((ApiResponse) actualHandleHttpMessageNotReadableResult.getBody()).getStatus().intValue());
    }
}

