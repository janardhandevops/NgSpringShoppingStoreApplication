package com.techie.shoppingstore.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LoginRequestDtoTest {
    /**
     * Method under test: {@link LoginRequestDto#canEqual(Object)}
     */
    @Test
    public void testCanEqual() {
        assertFalse((new LoginRequestDto()).canEqual("Other"));
    }

    /**
     * Method under test: {@link LoginRequestDto#canEqual(Object)}
     */
    @Test
    public void testCanEqual2() {
        LoginRequestDto loginRequestDto = new LoginRequestDto();

        LoginRequestDto loginRequestDto1 = new LoginRequestDto();
        loginRequestDto1.setPassword("iloveyou");
        loginRequestDto1.setUsername("janedoe");
        assertTrue(loginRequestDto.canEqual(loginRequestDto1));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link LoginRequestDto}
     *   <li>{@link LoginRequestDto#setPassword(String)}
     *   <li>{@link LoginRequestDto#setUsername(String)}
     * </ul>
     */
    @Test
    public void testConstructor() {
        LoginRequestDto actualLoginRequestDto = new LoginRequestDto();
        actualLoginRequestDto.setPassword("iloveyou");
        actualLoginRequestDto.setUsername("janedoe");
        assertEquals("iloveyou", actualLoginRequestDto.getPassword());
        assertEquals("janedoe", actualLoginRequestDto.getUsername());
    }

    /**
     * Method under test: {@link LoginRequestDto#equals(Object)}
     */
    @Test
    public void testEquals() {
        LoginRequestDto loginRequestDto = new LoginRequestDto();
        loginRequestDto.setPassword("iloveyou");
        loginRequestDto.setUsername("janedoe");
        assertNotEquals(loginRequestDto, null);
    }

    /**
     * Method under test: {@link LoginRequestDto#equals(Object)}
     */
    @Test
    public void testEquals2() {
        LoginRequestDto loginRequestDto = new LoginRequestDto();
        loginRequestDto.setPassword("iloveyou");
        loginRequestDto.setUsername("janedoe");
        assertNotEquals(loginRequestDto, "Different type to LoginRequestDto");
    }

    /**
     * Method under test: {@link LoginRequestDto#equals(Object)}
     */
    @Test
    public void testEquals3() {
        LoginRequestDto loginRequestDto = new LoginRequestDto();
        loginRequestDto.setPassword("iloveyou");
        loginRequestDto.setUsername("janedoe");
        assertEquals(loginRequestDto, loginRequestDto);
        int expectedHashCodeResult = loginRequestDto.hashCode();
        assertEquals(expectedHashCodeResult, loginRequestDto.hashCode());
    }

    /**
     * Method under test: {@link LoginRequestDto#equals(Object)}
     */
    @Test
    public void testEquals4() {
        LoginRequestDto loginRequestDto = new LoginRequestDto();
        loginRequestDto.setPassword("iloveyou");
        loginRequestDto.setUsername("janedoe");

        LoginRequestDto loginRequestDto1 = new LoginRequestDto();
        loginRequestDto1.setPassword("iloveyou");
        loginRequestDto1.setUsername("janedoe");
        assertEquals(loginRequestDto, loginRequestDto1);
        int expectedHashCodeResult = loginRequestDto.hashCode();
        assertEquals(expectedHashCodeResult, loginRequestDto1.hashCode());
    }

    /**
     * Method under test: {@link LoginRequestDto#equals(Object)}
     */
    @Test
    public void testEquals5() {
        LoginRequestDto loginRequestDto = new LoginRequestDto();
        loginRequestDto.setPassword("janedoe");
        loginRequestDto.setUsername("janedoe");

        LoginRequestDto loginRequestDto1 = new LoginRequestDto();
        loginRequestDto1.setPassword("iloveyou");
        loginRequestDto1.setUsername("janedoe");
        assertNotEquals(loginRequestDto, loginRequestDto1);
    }

    /**
     * Method under test: {@link LoginRequestDto#equals(Object)}
     */
    @Test
    public void testEquals6() {
        LoginRequestDto loginRequestDto = new LoginRequestDto();
        loginRequestDto.setPassword(null);
        loginRequestDto.setUsername("janedoe");

        LoginRequestDto loginRequestDto1 = new LoginRequestDto();
        loginRequestDto1.setPassword("iloveyou");
        loginRequestDto1.setUsername("janedoe");
        assertNotEquals(loginRequestDto, loginRequestDto1);
    }

    /**
     * Method under test: {@link LoginRequestDto#equals(Object)}
     */
    @Test
    public void testEquals7() {
        LoginRequestDto loginRequestDto = new LoginRequestDto();
        loginRequestDto.setPassword("iloveyou");
        loginRequestDto.setUsername("iloveyou");

        LoginRequestDto loginRequestDto1 = new LoginRequestDto();
        loginRequestDto1.setPassword("iloveyou");
        loginRequestDto1.setUsername("janedoe");
        assertNotEquals(loginRequestDto, loginRequestDto1);
    }

    /**
     * Method under test: {@link LoginRequestDto#equals(Object)}
     */
    @Test
    public void testEquals8() {
        LoginRequestDto loginRequestDto = new LoginRequestDto();
        loginRequestDto.setPassword("iloveyou");
        loginRequestDto.setUsername(null);

        LoginRequestDto loginRequestDto1 = new LoginRequestDto();
        loginRequestDto1.setPassword("iloveyou");
        loginRequestDto1.setUsername("janedoe");
        assertNotEquals(loginRequestDto, loginRequestDto1);
    }

    /**
     * Method under test: {@link LoginRequestDto#equals(Object)}
     */
    @Test
    public void testEquals9() {
        LoginRequestDto loginRequestDto = new LoginRequestDto();
        loginRequestDto.setPassword(null);
        loginRequestDto.setUsername("janedoe");

        LoginRequestDto loginRequestDto1 = new LoginRequestDto();
        loginRequestDto1.setPassword(null);
        loginRequestDto1.setUsername("janedoe");
        assertEquals(loginRequestDto, loginRequestDto1);
        int expectedHashCodeResult = loginRequestDto.hashCode();
        assertEquals(expectedHashCodeResult, loginRequestDto1.hashCode());
    }

    /**
     * Method under test: {@link LoginRequestDto#equals(Object)}
     */
    @Test
    public void testEquals10() {
        LoginRequestDto loginRequestDto = new LoginRequestDto();
        loginRequestDto.setPassword("iloveyou");
        loginRequestDto.setUsername(null);

        LoginRequestDto loginRequestDto1 = new LoginRequestDto();
        loginRequestDto1.setPassword("iloveyou");
        loginRequestDto1.setUsername(null);
        assertEquals(loginRequestDto, loginRequestDto1);
        int expectedHashCodeResult = loginRequestDto.hashCode();
        assertEquals(expectedHashCodeResult, loginRequestDto1.hashCode());
    }
}

