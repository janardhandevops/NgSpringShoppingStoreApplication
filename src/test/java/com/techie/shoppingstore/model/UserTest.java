package com.techie.shoppingstore.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class UserTest {
    /**
     * Method under test: {@link User#User()}
     */
    @Test
    public void testConstructor() {
        User actualUser = new User();
        assertNull(actualUser.getEmail());
        assertFalse(actualUser.isEnabled());
        assertNull(actualUser.getUsername());
        assertNull(actualUser.getPasswordConfirmation());
        assertNull(actualUser.getPassword());
        assertNull(actualUser.getId());
    }

    /**
     * Method under test: {@link User#User(String, String, String)}
     */
    @Test
    public void testConstructor2() {
        User actualUser = new User("jane.doe@example.org", "janedoe", "iloveyou");

        assertEquals("jane.doe@example.org", actualUser.getEmail());
        assertFalse(actualUser.isEnabled());
        assertEquals("janedoe", actualUser.getUsername());
        assertNull(actualUser.getPasswordConfirmation());
        assertEquals("iloveyou", actualUser.getPassword());
        assertNull(actualUser.getId());
    }
}

