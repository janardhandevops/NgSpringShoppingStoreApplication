package com.techie.shoppingstore.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class UserPrincipalTest {
    /**
     * Method under test: default or parameterless constructor of {@link UserPrincipal}
     */
    @Test
    public void testConstructor() {
        UserPrincipal actualUserPrincipal = new UserPrincipal();
        assertNull(actualUserPrincipal.getAuthorities());
        assertNull(actualUserPrincipal.getPassword());
        assertNull(actualUserPrincipal.getUsername());
        assertFalse(actualUserPrincipal.isAccountNonExpired());
        assertFalse(actualUserPrincipal.isAccountNonLocked());
        assertFalse(actualUserPrincipal.isCredentialsNonExpired());
        assertFalse(actualUserPrincipal.isEnabled());
    }
}

