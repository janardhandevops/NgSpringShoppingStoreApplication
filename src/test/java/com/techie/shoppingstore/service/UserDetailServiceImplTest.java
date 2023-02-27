package com.techie.shoppingstore.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.techie.shoppingstore.model.User;
import com.techie.shoppingstore.repository.UserRepository;

import java.util.Optional;

import org.junit.Ignore;
import org.junit.Rule;

import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {UserDetailServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class UserDetailServiceImplTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Autowired
    private UserDetailServiceImpl userDetailServiceImpl;

    @MockBean
    private UserRepository userRepository;

    /**
     * Method under test: {@link UserDetailServiceImpl#loadUserByUsername(String)}
     */
    @Test
    public void testLoadUserByUsername() {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setEnabled(true);
        user.setId("42");
        user.setPassword("iloveyou");
        user.setPasswordConfirmation("Password Confirmation");
        user.setUsername("janedoe");
        Optional<User> ofResult = Optional.of(user);
        when(this.userRepository.findByUsername((String) any())).thenReturn(ofResult);
        UserDetails actualLoadUserByUsernameResult = this.userDetailServiceImpl.loadUserByUsername("janedoe");
        assertEquals(1, actualLoadUserByUsernameResult.getAuthorities().size());
        assertTrue(actualLoadUserByUsernameResult.isEnabled());
        assertTrue(actualLoadUserByUsernameResult.isCredentialsNonExpired());
        assertTrue(actualLoadUserByUsernameResult.isAccountNonLocked());
        assertTrue(actualLoadUserByUsernameResult.isAccountNonExpired());
        assertEquals("janedoe", actualLoadUserByUsernameResult.getUsername());
        assertEquals("iloveyou", actualLoadUserByUsernameResult.getPassword());
        verify(this.userRepository).findByUsername((String) any());
    }

    /**
     * Method under test: {@link UserDetailServiceImpl#loadUserByUsername(String)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testLoadUserByUsername2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: Cannot pass null or empty values to constructor
        //       at org.springframework.security.core.userdetails.User.<init>(User.java:113)
        //       at com.techie.shoppingstore.service.UserDetailServiceImpl.loadUserByUsername(UserDetailServiceImpl.java:28)
        //   In order to prevent loadUserByUsername(String)
        //   from throwing IllegalArgumentException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   loadUserByUsername(String).
        //   See https://diff.blue/R013 to resolve this issue.

        User user = mock(User.class);
        when(user.isEnabled()).thenReturn(true);
        when(user.getPassword()).thenReturn("iloveyou");
        when(user.getUsername()).thenReturn("");
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
        Optional<User> ofResult = Optional.of(user);
        when(this.userRepository.findByUsername((String) any())).thenReturn(ofResult);
        this.userDetailServiceImpl.loadUserByUsername("janedoe");
    }

    /**
     * Method under test: {@link UserDetailServiceImpl#loadUserByUsername(String)}
     */
    @Test
    public void testLoadUserByUsername3() {
        when(this.userRepository.findByUsername((String) any())).thenReturn(Optional.empty());
        User user = mock(User.class);
        when(user.isEnabled()).thenReturn(true);
        when(user.getPassword()).thenReturn("iloveyou");
        when(user.getUsername()).thenReturn("janedoe");
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
        thrown.expect(UsernameNotFoundException.class);
        this.userDetailServiceImpl.loadUserByUsername("janedoe");
        verify(this.userRepository).findByUsername((String) any());
        verify(user).setEmail((String) any());
        verify(user).setEnabled(anyBoolean());
        verify(user).setId((String) any());
        verify(user).setPassword((String) any());
        verify(user).setPasswordConfirmation((String) any());
        verify(user).setUsername((String) any());
    }

    /**
     * Method under test: {@link UserDetailServiceImpl#loadUserByName(String)}
     */
    @Test
    public void testLoadUserByName() throws IllegalAccessException {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setEnabled(true);
        user.setId("42");
        user.setPassword("iloveyou");
        user.setPasswordConfirmation("Password Confirmation");
        user.setUsername("janedoe");
        Optional<User> ofResult = Optional.of(user);
        when(this.userRepository.findByUsername((String) any())).thenReturn(ofResult);
        UserDetails actualLoadUserByNameResult = this.userDetailServiceImpl.loadUserByName("janedoe");
        assertEquals(1, actualLoadUserByNameResult.getAuthorities().size());
        assertTrue(actualLoadUserByNameResult.isEnabled());
        assertTrue(actualLoadUserByNameResult.isCredentialsNonExpired());
        assertTrue(actualLoadUserByNameResult.isAccountNonLocked());
        assertTrue(actualLoadUserByNameResult.isAccountNonExpired());
        assertEquals("janedoe", actualLoadUserByNameResult.getUsername());
        assertEquals("iloveyou", actualLoadUserByNameResult.getPassword());
        verify(this.userRepository).findByUsername((String) any());
    }

    /**
     * Method under test: {@link UserDetailServiceImpl#loadUserByName(String)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testLoadUserByName2() throws IllegalAccessException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: Cannot pass null or empty values to constructor
        //       at org.springframework.security.core.userdetails.User.<init>(User.java:113)
        //       at com.techie.shoppingstore.service.UserDetailServiceImpl.loadUserByName(UserDetailServiceImpl.java:38)
        //   In order to prevent loadUserByName(String)
        //   from throwing IllegalArgumentException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   loadUserByName(String).
        //   See https://diff.blue/R013 to resolve this issue.

        User user = mock(User.class);
        when(user.isEnabled()).thenReturn(true);
        when(user.getPassword()).thenReturn("iloveyou");
        when(user.getUsername()).thenReturn("");
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
        Optional<User> ofResult = Optional.of(user);
        when(this.userRepository.findByUsername((String) any())).thenReturn(ofResult);
        this.userDetailServiceImpl.loadUserByName("janedoe");
    }

    /**
     * Method under test: {@link UserDetailServiceImpl#loadUserByName(String)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testLoadUserByName3() throws IllegalAccessException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalAccessException
        //       at java.util.Optional.orElseThrow(Optional.java:290)
        //       at com.techie.shoppingstore.service.UserDetailServiceImpl.loadUserByName(UserDetailServiceImpl.java:36)
        //   In order to prevent loadUserByName(String)
        //   from throwing IllegalAccessException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   loadUserByName(String).
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.userRepository.findByUsername((String) any())).thenReturn(Optional.empty());
        User user = mock(User.class);
        when(user.isEnabled()).thenReturn(true);
        when(user.getPassword()).thenReturn("iloveyou");
        when(user.getUsername()).thenReturn("janedoe");
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
        this.userDetailServiceImpl.loadUserByName("janedoe");
    }
}

