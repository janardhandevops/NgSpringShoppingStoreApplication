package com.techie.shoppingstore.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

import org.junit.Test;

public class VerificationTokenTest {
    /**
     * Method under test: {@link VerificationToken#canEqual(Object)}
     */
    @Test
    public void testCanEqual() {
        assertFalse((new VerificationToken()).canEqual("Other"));
    }

    /**
     * Method under test: {@link VerificationToken#canEqual(Object)}
     */
    @Test
    public void testCanEqual2() {
        VerificationToken verificationToken = new VerificationToken();

        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setEnabled(true);
        user.setId("42");
        user.setPassword("iloveyou");
        user.setPasswordConfirmation("Password Confirmation");
        user.setUsername("janedoe");

        VerificationToken verificationToken1 = new VerificationToken();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        verificationToken1.setExpiryDate(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
        verificationToken1.setId("42");
        verificationToken1.setToken("ABC123");
        verificationToken1.setUser(user);
        assertTrue(verificationToken.canEqual(verificationToken1));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link VerificationToken}
     *   <li>{@link VerificationToken#setExpiryDate(Instant)}
     *   <li>{@link VerificationToken#setId(String)}
     *   <li>{@link VerificationToken#setToken(String)}
     *   <li>{@link VerificationToken#setUser(User)}
     * </ul>
     */
    @Test
    public void testConstructor() {
        VerificationToken actualVerificationToken = new VerificationToken();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        actualVerificationToken.setExpiryDate(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
        actualVerificationToken.setId("42");
        actualVerificationToken.setToken("ABC123");
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setEnabled(true);
        user.setId("42");
        user.setPassword("iloveyou");
        user.setPasswordConfirmation("Password Confirmation");
        user.setUsername("janedoe");
        actualVerificationToken.setUser(user);
        assertEquals("42", actualVerificationToken.getId());
        assertEquals("ABC123", actualVerificationToken.getToken());
        assertSame(user, actualVerificationToken.getUser());
    }

    /**
     * Method under test: {@link VerificationToken#equals(Object)}
     */
    @Test
    public void testEquals() {
        User user = new User();
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
        assertNotEquals(verificationToken, null);
    }

    /**
     * Method under test: {@link VerificationToken#equals(Object)}
     */
    @Test
    public void testEquals2() {
        User user = new User();
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
        assertNotEquals(verificationToken, "Different type to VerificationToken");
    }

    /**
     * Method under test: {@link VerificationToken#equals(Object)}
     */
    @Test
    public void testEquals3() {
        User user = new User();
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
        assertEquals(verificationToken, verificationToken);
        int expectedHashCodeResult = verificationToken.hashCode();
        assertEquals(expectedHashCodeResult, verificationToken.hashCode());
    }

    /**
     * Method under test: {@link VerificationToken#equals(Object)}
     */
    @Test
    public void testEquals4() {
        User user = new User();
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

        User user1 = new User();
        user1.setEmail("jane.doe@example.org");
        user1.setEnabled(true);
        user1.setId("42");
        user1.setPassword("iloveyou");
        user1.setPasswordConfirmation("Password Confirmation");
        user1.setUsername("janedoe");

        VerificationToken verificationToken1 = new VerificationToken();
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        verificationToken1.setExpiryDate(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant());
        verificationToken1.setId("42");
        verificationToken1.setToken("ABC123");
        verificationToken1.setUser(user1);
        assertEquals(verificationToken, verificationToken1);
        int expectedHashCodeResult = verificationToken.hashCode();
        assertEquals(expectedHashCodeResult, verificationToken1.hashCode());
    }

    /**
     * Method under test: {@link VerificationToken#equals(Object)}
     */
    @Test
    public void testEquals5() {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setEnabled(true);
        user.setId("42");
        user.setPassword("iloveyou");
        user.setPasswordConfirmation("Password Confirmation");
        user.setUsername("janedoe");

        VerificationToken verificationToken = new VerificationToken();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        verificationToken.setExpiryDate(atStartOfDayResult.atZone(ZoneOffset.ofTotalSeconds(1)).toInstant());
        verificationToken.setId("42");
        verificationToken.setToken("ABC123");
        verificationToken.setUser(user);

        User user1 = new User();
        user1.setEmail("jane.doe@example.org");
        user1.setEnabled(true);
        user1.setId("42");
        user1.setPassword("iloveyou");
        user1.setPasswordConfirmation("Password Confirmation");
        user1.setUsername("janedoe");

        VerificationToken verificationToken1 = new VerificationToken();
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        verificationToken1.setExpiryDate(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant());
        verificationToken1.setId("42");
        verificationToken1.setToken("ABC123");
        verificationToken1.setUser(user1);
        assertNotEquals(verificationToken, verificationToken1);
    }

    /**
     * Method under test: {@link VerificationToken#equals(Object)}
     */
    @Test
    public void testEquals6() {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setEnabled(true);
        user.setId("42");
        user.setPassword("iloveyou");
        user.setPasswordConfirmation("Password Confirmation");
        user.setUsername("janedoe");

        VerificationToken verificationToken = new VerificationToken();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        verificationToken.setExpiryDate(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
        verificationToken.setId("ABC123");
        verificationToken.setToken("ABC123");
        verificationToken.setUser(user);

        User user1 = new User();
        user1.setEmail("jane.doe@example.org");
        user1.setEnabled(true);
        user1.setId("42");
        user1.setPassword("iloveyou");
        user1.setPasswordConfirmation("Password Confirmation");
        user1.setUsername("janedoe");

        VerificationToken verificationToken1 = new VerificationToken();
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        verificationToken1.setExpiryDate(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant());
        verificationToken1.setId("42");
        verificationToken1.setToken("ABC123");
        verificationToken1.setUser(user1);
        assertNotEquals(verificationToken, verificationToken1);
    }

    /**
     * Method under test: {@link VerificationToken#equals(Object)}
     */
    @Test
    public void testEquals7() {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setEnabled(true);
        user.setId("42");
        user.setPassword("iloveyou");
        user.setPasswordConfirmation("Password Confirmation");
        user.setUsername("janedoe");

        VerificationToken verificationToken = new VerificationToken();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        verificationToken.setExpiryDate(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
        verificationToken.setId(null);
        verificationToken.setToken("ABC123");
        verificationToken.setUser(user);

        User user1 = new User();
        user1.setEmail("jane.doe@example.org");
        user1.setEnabled(true);
        user1.setId("42");
        user1.setPassword("iloveyou");
        user1.setPasswordConfirmation("Password Confirmation");
        user1.setUsername("janedoe");

        VerificationToken verificationToken1 = new VerificationToken();
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        verificationToken1.setExpiryDate(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant());
        verificationToken1.setId("42");
        verificationToken1.setToken("ABC123");
        verificationToken1.setUser(user1);
        assertNotEquals(verificationToken, verificationToken1);
    }

    /**
     * Method under test: {@link VerificationToken#equals(Object)}
     */
    @Test
    public void testEquals8() {
        User user = new User();
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
        verificationToken.setToken("42");
        verificationToken.setUser(user);

        User user1 = new User();
        user1.setEmail("jane.doe@example.org");
        user1.setEnabled(true);
        user1.setId("42");
        user1.setPassword("iloveyou");
        user1.setPasswordConfirmation("Password Confirmation");
        user1.setUsername("janedoe");

        VerificationToken verificationToken1 = new VerificationToken();
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        verificationToken1.setExpiryDate(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant());
        verificationToken1.setId("42");
        verificationToken1.setToken("ABC123");
        verificationToken1.setUser(user1);
        assertNotEquals(verificationToken, verificationToken1);
    }

    /**
     * Method under test: {@link VerificationToken#equals(Object)}
     */
    @Test
    public void testEquals9() {
        User user = new User();
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
        verificationToken.setToken(null);
        verificationToken.setUser(user);

        User user1 = new User();
        user1.setEmail("jane.doe@example.org");
        user1.setEnabled(true);
        user1.setId("42");
        user1.setPassword("iloveyou");
        user1.setPasswordConfirmation("Password Confirmation");
        user1.setUsername("janedoe");

        VerificationToken verificationToken1 = new VerificationToken();
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        verificationToken1.setExpiryDate(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant());
        verificationToken1.setId("42");
        verificationToken1.setToken("ABC123");
        verificationToken1.setUser(user1);
        assertNotEquals(verificationToken, verificationToken1);
    }

    /**
     * Method under test: {@link VerificationToken#equals(Object)}
     */
    @Test
    public void testEquals10() {
        User user = mock(User.class);
        doNothing().when(user).setEmail((String) any());
        doNothing().when(user).setEnabled(anyBoolean());
        doNothing().when(user).setId((String) any());
        doNothing().when(user).setPassword((String) any());
        doNothing().when(user).setPasswordConfirmation((String) any());
        doNothing().when(user).setUsername((String) any());
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

        User user1 = new User();
        user1.setEmail("jane.doe@example.org");
        user1.setEnabled(true);
        user1.setId("42");
        user1.setPassword("iloveyou");
        user1.setPasswordConfirmation("Password Confirmation");
        user1.setUsername("janedoe");

        VerificationToken verificationToken1 = new VerificationToken();
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        verificationToken1.setExpiryDate(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant());
        verificationToken1.setId("42");
        verificationToken1.setToken("ABC123");
        verificationToken1.setUser(user1);
        assertNotEquals(verificationToken, verificationToken1);
    }
}

