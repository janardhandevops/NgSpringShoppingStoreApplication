package com.techie.shoppingstore.exceptions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class ApiResponseTest {
    /**
     * Method under test: {@link ApiResponse#ApiResponse()}
     */
    @Test
    public void testConstructor() {
        ApiResponse actualApiResponse = new ApiResponse();
        assertNull(actualApiResponse.getMessage());
        assertNull(actualApiResponse.getStatus());
    }

    /**
     * Method under test: {@link ApiResponse#ApiResponse(Integer, String)}
     */
    @Test
    public void testConstructor2() {
        ApiResponse actualApiResponse = new ApiResponse(1, "Not all who wander are lost");

        assertEquals("Not all who wander are lost", actualApiResponse.getMessage());
        assertEquals(1, actualApiResponse.getStatus().intValue());
    }

    /**
     * Method under test: {@link ApiResponse#ApiResponse()}
     */
    @Test
    public void testConstructor3() {
        ApiResponse actualApiResponse = new ApiResponse();
        assertNull(actualApiResponse.getMessage());
        assertNull(actualApiResponse.getStatus());
    }

    /**
     * Method under test: {@link ApiResponse#ApiResponse(Integer, String)}
     */
    @Test
    public void testConstructor4() {
        ApiResponse actualApiResponse = new ApiResponse(1, "Not all who wander are lost");

        assertEquals("Not all who wander are lost", actualApiResponse.getMessage());
        assertEquals(1, actualApiResponse.getStatus().intValue());
    }
}

