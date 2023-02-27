package com.techie.shoppingstore.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MailTest {
    /**
     * Method under test: {@link Mail#canEqual(Object)}
     */
    @Test
    public void testCanEqual() {
        assertFalse((new Mail()).canEqual("Other"));
    }

    /**
     * Method under test: {@link Mail#canEqual(Object)}
     */
    @Test
    public void testCanEqual2() {
        Mail mail = new Mail();

        Mail mail1 = new Mail();
        mail1.setContent("Not all who wander are lost");
        mail1.setFrom("jane.doe@example.org");
        mail1.setSubject("Hello from the Dreaming Spires");
        mail1.setTo("alice.liddell@example.org");
        assertTrue(mail.canEqual(mail1));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link Mail}
     *   <li>{@link Mail#setContent(String)}
     *   <li>{@link Mail#setFrom(String)}
     *   <li>{@link Mail#setSubject(String)}
     *   <li>{@link Mail#setTo(String)}
     * </ul>
     */
    @Test
    public void testConstructor() {
        Mail actualMail = new Mail();
        actualMail.setContent("Not all who wander are lost");
        actualMail.setFrom("jane.doe@example.org");
        actualMail.setSubject("Hello from the Dreaming Spires");
        actualMail.setTo("alice.liddell@example.org");
        assertEquals("Not all who wander are lost", actualMail.getContent());
        assertEquals("jane.doe@example.org", actualMail.getFrom());
        assertEquals("Hello from the Dreaming Spires", actualMail.getSubject());
        assertEquals("alice.liddell@example.org", actualMail.getTo());
    }

    /**
     * Method under test: {@link Mail#equals(Object)}
     */
    @Test
    public void testEquals() {
        Mail mail = new Mail();
        mail.setContent("Not all who wander are lost");
        mail.setFrom("jane.doe@example.org");
        mail.setSubject("Hello from the Dreaming Spires");
        mail.setTo("alice.liddell@example.org");
        assertNotEquals(mail, null);
    }

    /**
     * Method under test: {@link Mail#equals(Object)}
     */
    @Test
    public void testEquals2() {
        Mail mail = new Mail();
        mail.setContent("Not all who wander are lost");
        mail.setFrom("jane.doe@example.org");
        mail.setSubject("Hello from the Dreaming Spires");
        mail.setTo("alice.liddell@example.org");
        assertNotEquals(mail, "Different type to Mail");
    }

    /**
     * Method under test: {@link Mail#equals(Object)}
     */
    @Test
    public void testEquals3() {
        Mail mail = new Mail();
        mail.setContent("Not all who wander are lost");
        mail.setFrom("jane.doe@example.org");
        mail.setSubject("Hello from the Dreaming Spires");
        mail.setTo("alice.liddell@example.org");
        assertEquals(mail, mail);
        int expectedHashCodeResult = mail.hashCode();
        assertEquals(expectedHashCodeResult, mail.hashCode());
    }

    /**
     * Method under test: {@link Mail#equals(Object)}
     */
    @Test
    public void testEquals4() {
        Mail mail = new Mail();
        mail.setContent("Not all who wander are lost");
        mail.setFrom("jane.doe@example.org");
        mail.setSubject("Hello from the Dreaming Spires");
        mail.setTo("alice.liddell@example.org");

        Mail mail1 = new Mail();
        mail1.setContent("Not all who wander are lost");
        mail1.setFrom("jane.doe@example.org");
        mail1.setSubject("Hello from the Dreaming Spires");
        mail1.setTo("alice.liddell@example.org");
        assertEquals(mail, mail1);
        int expectedHashCodeResult = mail.hashCode();
        assertEquals(expectedHashCodeResult, mail1.hashCode());
    }

    /**
     * Method under test: {@link Mail#equals(Object)}
     */
    @Test
    public void testEquals5() {
        Mail mail = new Mail();
        mail.setContent("jane.doe@example.org");
        mail.setFrom("jane.doe@example.org");
        mail.setSubject("Hello from the Dreaming Spires");
        mail.setTo("alice.liddell@example.org");

        Mail mail1 = new Mail();
        mail1.setContent("Not all who wander are lost");
        mail1.setFrom("jane.doe@example.org");
        mail1.setSubject("Hello from the Dreaming Spires");
        mail1.setTo("alice.liddell@example.org");
        assertNotEquals(mail, mail1);
    }

    /**
     * Method under test: {@link Mail#equals(Object)}
     */
    @Test
    public void testEquals6() {
        Mail mail = new Mail();
        mail.setContent(null);
        mail.setFrom("jane.doe@example.org");
        mail.setSubject("Hello from the Dreaming Spires");
        mail.setTo("alice.liddell@example.org");

        Mail mail1 = new Mail();
        mail1.setContent("Not all who wander are lost");
        mail1.setFrom("jane.doe@example.org");
        mail1.setSubject("Hello from the Dreaming Spires");
        mail1.setTo("alice.liddell@example.org");
        assertNotEquals(mail, mail1);
    }

    /**
     * Method under test: {@link Mail#equals(Object)}
     */
    @Test
    public void testEquals7() {
        Mail mail = new Mail();
        mail.setContent("Not all who wander are lost");
        mail.setFrom("alice.liddell@example.org");
        mail.setSubject("Hello from the Dreaming Spires");
        mail.setTo("alice.liddell@example.org");

        Mail mail1 = new Mail();
        mail1.setContent("Not all who wander are lost");
        mail1.setFrom("jane.doe@example.org");
        mail1.setSubject("Hello from the Dreaming Spires");
        mail1.setTo("alice.liddell@example.org");
        assertNotEquals(mail, mail1);
    }

    /**
     * Method under test: {@link Mail#equals(Object)}
     */
    @Test
    public void testEquals8() {
        Mail mail = new Mail();
        mail.setContent("Not all who wander are lost");
        mail.setFrom(null);
        mail.setSubject("Hello from the Dreaming Spires");
        mail.setTo("alice.liddell@example.org");

        Mail mail1 = new Mail();
        mail1.setContent("Not all who wander are lost");
        mail1.setFrom("jane.doe@example.org");
        mail1.setSubject("Hello from the Dreaming Spires");
        mail1.setTo("alice.liddell@example.org");
        assertNotEquals(mail, mail1);
    }

    /**
     * Method under test: {@link Mail#equals(Object)}
     */
    @Test
    public void testEquals9() {
        Mail mail = new Mail();
        mail.setContent("Not all who wander are lost");
        mail.setFrom("jane.doe@example.org");
        mail.setSubject("jane.doe@example.org");
        mail.setTo("alice.liddell@example.org");

        Mail mail1 = new Mail();
        mail1.setContent("Not all who wander are lost");
        mail1.setFrom("jane.doe@example.org");
        mail1.setSubject("Hello from the Dreaming Spires");
        mail1.setTo("alice.liddell@example.org");
        assertNotEquals(mail, mail1);
    }

    /**
     * Method under test: {@link Mail#equals(Object)}
     */
    @Test
    public void testEquals10() {
        Mail mail = new Mail();
        mail.setContent("Not all who wander are lost");
        mail.setFrom("jane.doe@example.org");
        mail.setSubject(null);
        mail.setTo("alice.liddell@example.org");

        Mail mail1 = new Mail();
        mail1.setContent("Not all who wander are lost");
        mail1.setFrom("jane.doe@example.org");
        mail1.setSubject("Hello from the Dreaming Spires");
        mail1.setTo("alice.liddell@example.org");
        assertNotEquals(mail, mail1);
    }

    /**
     * Method under test: {@link Mail#equals(Object)}
     */
    @Test
    public void testEquals11() {
        Mail mail = new Mail();
        mail.setContent("Not all who wander are lost");
        mail.setFrom("jane.doe@example.org");
        mail.setSubject("Hello from the Dreaming Spires");
        mail.setTo("jane.doe@example.org");

        Mail mail1 = new Mail();
        mail1.setContent("Not all who wander are lost");
        mail1.setFrom("jane.doe@example.org");
        mail1.setSubject("Hello from the Dreaming Spires");
        mail1.setTo("alice.liddell@example.org");
        assertNotEquals(mail, mail1);
    }

    /**
     * Method under test: {@link Mail#equals(Object)}
     */
    @Test
    public void testEquals12() {
        Mail mail = new Mail();
        mail.setContent("Not all who wander are lost");
        mail.setFrom("jane.doe@example.org");
        mail.setSubject("Hello from the Dreaming Spires");
        mail.setTo(null);

        Mail mail1 = new Mail();
        mail1.setContent("Not all who wander are lost");
        mail1.setFrom("jane.doe@example.org");
        mail1.setSubject("Hello from the Dreaming Spires");
        mail1.setTo("alice.liddell@example.org");
        assertNotEquals(mail, mail1);
    }

    /**
     * Method under test: {@link Mail#equals(Object)}
     */
    @Test
    public void testEquals13() {
        Mail mail = new Mail();
        mail.setContent(null);
        mail.setFrom("jane.doe@example.org");
        mail.setSubject("Hello from the Dreaming Spires");
        mail.setTo("alice.liddell@example.org");

        Mail mail1 = new Mail();
        mail1.setContent(null);
        mail1.setFrom("jane.doe@example.org");
        mail1.setSubject("Hello from the Dreaming Spires");
        mail1.setTo("alice.liddell@example.org");
        assertEquals(mail, mail1);
        int expectedHashCodeResult = mail.hashCode();
        assertEquals(expectedHashCodeResult, mail1.hashCode());
    }

    /**
     * Method under test: {@link Mail#equals(Object)}
     */
    @Test
    public void testEquals14() {
        Mail mail = new Mail();
        mail.setContent("Not all who wander are lost");
        mail.setFrom(null);
        mail.setSubject("Hello from the Dreaming Spires");
        mail.setTo("alice.liddell@example.org");

        Mail mail1 = new Mail();
        mail1.setContent("Not all who wander are lost");
        mail1.setFrom(null);
        mail1.setSubject("Hello from the Dreaming Spires");
        mail1.setTo("alice.liddell@example.org");
        assertEquals(mail, mail1);
        int expectedHashCodeResult = mail.hashCode();
        assertEquals(expectedHashCodeResult, mail1.hashCode());
    }

    /**
     * Method under test: {@link Mail#equals(Object)}
     */
    @Test
    public void testEquals15() {
        Mail mail = new Mail();
        mail.setContent("Not all who wander are lost");
        mail.setFrom("jane.doe@example.org");
        mail.setSubject(null);
        mail.setTo("alice.liddell@example.org");

        Mail mail1 = new Mail();
        mail1.setContent("Not all who wander are lost");
        mail1.setFrom("jane.doe@example.org");
        mail1.setSubject(null);
        mail1.setTo("alice.liddell@example.org");
        assertEquals(mail, mail1);
        int expectedHashCodeResult = mail.hashCode();
        assertEquals(expectedHashCodeResult, mail1.hashCode());
    }

    /**
     * Method under test: {@link Mail#equals(Object)}
     */
    @Test
    public void testEquals16() {
        Mail mail = new Mail();
        mail.setContent("Not all who wander are lost");
        mail.setFrom("jane.doe@example.org");
        mail.setSubject("Hello from the Dreaming Spires");
        mail.setTo(null);

        Mail mail1 = new Mail();
        mail1.setContent("Not all who wander are lost");
        mail1.setFrom("jane.doe@example.org");
        mail1.setSubject("Hello from the Dreaming Spires");
        mail1.setTo(null);
        assertEquals(mail, mail1);
        int expectedHashCodeResult = mail.hashCode();
        assertEquals(expectedHashCodeResult, mail1.hashCode());
    }
}

