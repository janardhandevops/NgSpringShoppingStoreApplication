package com.techie.shoppingstore.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AuthenticationResponseTest {
    /**
     * Method under test: {@link AuthenticationResponse#canEqual(Object)}
     */
    @Test
    public void testCanEqual() {
        assertFalse((new AuthenticationResponse("ABC123", "janedoe")).canEqual("Other"));
    }

    /**
     * Method under test: {@link AuthenticationResponse#canEqual(Object)}
     */
    @Test
    public void testCanEqual2() {
        AuthenticationResponse authenticationResponse = new AuthenticationResponse("ABC123", "janedoe");
        assertTrue(authenticationResponse.canEqual(new AuthenticationResponse("ABC123", "janedoe")));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link AuthenticationResponse#AuthenticationResponse(String, String)}
     *   <li>{@link AuthenticationResponse#setAccessToken(String)}
     *   <li>{@link AuthenticationResponse#setUsername(String)}
     * </ul>
     */
    @Test
    public void testConstructor() {
        AuthenticationResponse actualAuthenticationResponse = new AuthenticationResponse("ABC123", "janedoe");
        actualAuthenticationResponse.setAccessToken("ABC123");
        actualAuthenticationResponse.setUsername("janedoe");
        assertEquals("ABC123", actualAuthenticationResponse.getAccessToken());
        assertEquals("janedoe", actualAuthenticationResponse.getUsername());
    }

    /**
     * Method under test: {@link AuthenticationResponse#equals(Object)}
     */
    @Test
    public void testEquals() {
        assertNotEquals(new AuthenticationResponse("ABC123", "janedoe"), null);
        assertNotEquals(new AuthenticationResponse("ABC123", "janedoe"), "Different type to AuthenticationResponse");
    }

    /**
     * Method under test: {@link AuthenticationResponse#equals(Object)}
     */
    @Test
    public void testEquals2() {
        AuthenticationResponse authenticationResponse = new AuthenticationResponse("ABC123", "janedoe");
        assertEquals(authenticationResponse, authenticationResponse);
        int expectedHashCodeResult = authenticationResponse.hashCode();
        assertEquals(expectedHashCodeResult, authenticationResponse.hashCode());
    }

    /**
     * Method under test: {@link AuthenticationResponse#equals(Object)}
     */
    @Test
    public void testEquals3() {
        AuthenticationResponse authenticationResponse = new AuthenticationResponse("ABC123", "janedoe");
        AuthenticationResponse authenticationResponse1 = new AuthenticationResponse("ABC123", "janedoe");

        assertEquals(authenticationResponse, authenticationResponse1);
        int expectedHashCodeResult = authenticationResponse.hashCode();
        assertEquals(expectedHashCodeResult, authenticationResponse1.hashCode());
    }

    /**
     * Method under test: {@link AuthenticationResponse#equals(Object)}
     */
    @Test
    public void testEquals4() {
        AuthenticationResponse authenticationResponse = new AuthenticationResponse("ExampleToken", "janedoe");
        assertNotEquals(authenticationResponse, new AuthenticationResponse("ABC123", "janedoe"));
    }

    /**
     * Method under test: {@link AuthenticationResponse#equals(Object)}
     */
    @Test
    public void testEquals5() {
        AuthenticationResponse authenticationResponse = new AuthenticationResponse(null, "janedoe");
        assertNotEquals(authenticationResponse, new AuthenticationResponse("ABC123", "janedoe"));
    }

    /**
     * Method under test: {@link AuthenticationResponse#equals(Object)}
     */
    @Test
    public void testEquals6() {
        AuthenticationResponse authenticationResponse = new AuthenticationResponse("ABC123", "ABC123");
        assertNotEquals(authenticationResponse, new AuthenticationResponse("ABC123", "janedoe"));
    }

    /**
     * Method under test: {@link AuthenticationResponse#equals(Object)}
     */
    @Test
    public void testEquals7() {
        AuthenticationResponse authenticationResponse = new AuthenticationResponse("ABC123", null);
        assertNotEquals(authenticationResponse, new AuthenticationResponse("ABC123", "janedoe"));
    }

    /**
     * Method under test: {@link AuthenticationResponse#equals(Object)}
     */
    @Test
    public void testEquals8() {
        AuthenticationResponse authenticationResponse = new AuthenticationResponse(null, "janedoe");
        AuthenticationResponse authenticationResponse1 = new AuthenticationResponse(null, "janedoe");

        assertEquals(authenticationResponse, authenticationResponse1);
        int expectedHashCodeResult = authenticationResponse.hashCode();
        assertEquals(expectedHashCodeResult, authenticationResponse1.hashCode());
    }

    /**
     * Method under test: {@link AuthenticationResponse#equals(Object)}
     */
    @Test
    public void testEquals9() {
        AuthenticationResponse authenticationResponse = new AuthenticationResponse("ABC123", null);
        AuthenticationResponse authenticationResponse1 = new AuthenticationResponse("ABC123", null);

        assertEquals(authenticationResponse, authenticationResponse1);
        int expectedHashCodeResult = authenticationResponse.hashCode();
        assertEquals(expectedHashCodeResult, authenticationResponse1.hashCode());
    }
}

