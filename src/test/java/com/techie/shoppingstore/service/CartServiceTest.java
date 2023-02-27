package com.techie.shoppingstore.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.techie.shoppingstore.dto.CartItems;
import com.techie.shoppingstore.model.ShoppingCart;
import com.techie.shoppingstore.model.ShoppingCartItem;
import com.techie.shoppingstore.repository.CartRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;

import org.junit.Ignore;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.User;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {CartService.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class CartServiceTest {
    @MockBean
    private AuthService authService;

    @MockBean
    private CartRepository cartRepository;

    @Autowired
    private CartService cartService;

    /**
     * Method under test: {@link CartService#cartItems(ShoppingCartItem)}
     */
    @Test
    public void testCartItems() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setId("42");
        shoppingCart.setShoppingCartItems(new HashSet<>());
        shoppingCart.setUsername("janedoe");

        ShoppingCart shoppingCart1 = new ShoppingCart();
        shoppingCart1.setId("42");
        shoppingCart1.setShoppingCartItems(new HashSet<>());
        shoppingCart1.setUsername("janedoe");
        when(this.cartRepository.findByUsername((String) any())).thenReturn(shoppingCart);
        when(this.cartRepository.save((ShoppingCart) any())).thenReturn(shoppingCart1);
        when(this.authService.getCurrentUser()).thenReturn(Optional.of(new User("janedoe", "iloveyou", new ArrayList<>())));
        assertEquals("success", this.cartService.cartItems(new ShoppingCartItem()));
        verify(this.cartRepository).findByUsername((String) any());
        verify(this.cartRepository).save((ShoppingCart) any());
        verify(this.authService).getCurrentUser();
    }

    /**
     * Method under test: {@link CartService#cartItems(ShoppingCartItem)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testCartItems2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.techie.shoppingstore.service.CartService.cartItems(CartService.java:37)
        //   In order to prevent cartItems(ShoppingCartItem)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   cartItems(ShoppingCartItem).
        //   See https://diff.blue/R013 to resolve this issue.

        HashSet<ShoppingCartItem> shoppingCartItemSet = new HashSet<>();
        shoppingCartItemSet.add(new ShoppingCartItem());

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setId("42");
        shoppingCart.setShoppingCartItems(shoppingCartItemSet);
        shoppingCart.setUsername("janedoe");

        ShoppingCart shoppingCart1 = new ShoppingCart();
        shoppingCart1.setId("42");
        shoppingCart1.setShoppingCartItems(new HashSet<>());
        shoppingCart1.setUsername("janedoe");
        when(this.cartRepository.findByUsername((String) any())).thenReturn(shoppingCart);
        when(this.cartRepository.save((ShoppingCart) any())).thenReturn(shoppingCart1);
        when(this.authService.getCurrentUser()).thenReturn(Optional.of(new User("janedoe", "iloveyou", new ArrayList<>())));
        this.cartService.cartItems(new ShoppingCartItem());
    }

    /**
     * Method under test: {@link CartService#cartItems(ShoppingCartItem)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testCartItems3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.techie.shoppingstore.service.CartService.cartItems(CartService.java:29)
        //   In order to prevent cartItems(ShoppingCartItem)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   cartItems(ShoppingCartItem).
        //   See https://diff.blue/R013 to resolve this issue.

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setId("42");
        shoppingCart.setShoppingCartItems(new HashSet<>());
        shoppingCart.setUsername("janedoe");

        ShoppingCart shoppingCart1 = new ShoppingCart();
        shoppingCart1.setId("42");
        shoppingCart1.setShoppingCartItems(new HashSet<>());
        shoppingCart1.setUsername("janedoe");
        when(this.cartRepository.findByUsername((String) any())).thenReturn(shoppingCart);
        when(this.cartRepository.save((ShoppingCart) any())).thenReturn(shoppingCart1);
        when(this.authService.getCurrentUser()).thenReturn(null);
        this.cartService.cartItems(new ShoppingCartItem());
    }

    /**
     * Method under test: {@link CartService#cartItems(ShoppingCartItem)}
     */
    @Test
    public void testCartItems4() {
        ShoppingCartItem shoppingCartItem = new ShoppingCartItem();
        shoppingCartItem.setProductName("Product Name");

        HashSet<ShoppingCartItem> shoppingCartItemSet = new HashSet<>();
        shoppingCartItemSet.add(shoppingCartItem);

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setId("42");
        shoppingCart.setShoppingCartItems(shoppingCartItemSet);
        shoppingCart.setUsername("janedoe");

        ShoppingCart shoppingCart1 = new ShoppingCart();
        shoppingCart1.setId("42");
        shoppingCart1.setShoppingCartItems(new HashSet<>());
        shoppingCart1.setUsername("janedoe");
        when(this.cartRepository.findByUsername((String) any())).thenReturn(shoppingCart);
        when(this.cartRepository.save((ShoppingCart) any())).thenReturn(shoppingCart1);
        when(this.authService.getCurrentUser()).thenReturn(Optional.of(new User("janedoe", "iloveyou", new ArrayList<>())));
        assertEquals("success", this.cartService.cartItems(new ShoppingCartItem()));
        verify(this.cartRepository).findByUsername((String) any());
        verify(this.cartRepository).save((ShoppingCart) any());
        verify(this.authService).getCurrentUser();
    }

    /**
     * Method under test: {@link CartService#cartItems(ShoppingCartItem)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testCartItems5() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.techie.shoppingstore.service.CartService.cartItems(CartService.java:37)
        //   In order to prevent cartItems(ShoppingCartItem)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   cartItems(ShoppingCartItem).
        //   See https://diff.blue/R013 to resolve this issue.

        HashSet<ShoppingCartItem> shoppingCartItemSet = new HashSet<>();
        shoppingCartItemSet.add(null);

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setId("42");
        shoppingCart.setShoppingCartItems(shoppingCartItemSet);
        shoppingCart.setUsername("janedoe");

        ShoppingCart shoppingCart1 = new ShoppingCart();
        shoppingCart1.setId("42");
        shoppingCart1.setShoppingCartItems(new HashSet<>());
        shoppingCart1.setUsername("janedoe");
        when(this.cartRepository.findByUsername((String) any())).thenReturn(shoppingCart);
        when(this.cartRepository.save((ShoppingCart) any())).thenReturn(shoppingCart1);
        when(this.authService.getCurrentUser()).thenReturn(Optional.of(new User("janedoe", "iloveyou", new ArrayList<>())));
        this.cartService.cartItems(new ShoppingCartItem());
    }

    /**
     * Method under test: {@link CartService#cartItems(ShoppingCartItem)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testCartItems6() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.techie.shoppingstore.service.CartService.cartItems(CartService.java:37)
        //   In order to prevent cartItems(ShoppingCartItem)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   cartItems(ShoppingCartItem).
        //   See https://diff.blue/R013 to resolve this issue.

        HashSet<ShoppingCartItem> shoppingCartItemSet = new HashSet<>();
        shoppingCartItemSet.add(new ShoppingCartItem());

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setId("42");
        shoppingCart.setShoppingCartItems(shoppingCartItemSet);
        shoppingCart.setUsername("janedoe");

        ShoppingCart shoppingCart1 = new ShoppingCart();
        shoppingCart1.setId("42");
        shoppingCart1.setShoppingCartItems(new HashSet<>());
        shoppingCart1.setUsername("janedoe");
        when(this.cartRepository.findByUsername((String) any())).thenReturn(shoppingCart);
        when(this.cartRepository.save((ShoppingCart) any())).thenReturn(shoppingCart1);
        when(this.authService.getCurrentUser()).thenReturn(Optional.of(new User("janedoe", "iloveyou", new ArrayList<>())));
        this.cartService.cartItems(null);
    }

    /**
     * Method under test: {@link CartService#getCartItems()}
     */
    @Test
    public void testGetCartItems() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setId("42");
        shoppingCart.setShoppingCartItems(new HashSet<>());
        shoppingCart.setUsername("janedoe");
        when(this.cartRepository.findByUsername((String) any())).thenReturn(shoppingCart);
        when(this.authService.getCurrentUser()).thenReturn(Optional.of(new User("janedoe", "iloveyou", new ArrayList<>())));
        CartItems actualCartItems = this.cartService.getCartItems();
        assertSame(shoppingCart, actualCartItems.getShoppingCart());
        assertEquals(0, actualCartItems.getTotal().intValue());
        verify(this.cartRepository).findByUsername((String) any());
        verify(this.authService).getCurrentUser();
    }

    /**
     * Method under test: {@link CartService#getCartItems()}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testGetCartItems2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.techie.shoppingstore.service.CartService.getCartItems(CartService.java:98)
        //   In order to prevent getCartItems()
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getCartItems().
        //   See https://diff.blue/R013 to resolve this issue.

        HashSet<ShoppingCartItem> shoppingCartItemSet = new HashSet<>();
        shoppingCartItemSet.add(new ShoppingCartItem());

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setId("42");
        shoppingCart.setShoppingCartItems(shoppingCartItemSet);
        shoppingCart.setUsername("janedoe");
        when(this.cartRepository.findByUsername((String) any())).thenReturn(shoppingCart);
        when(this.authService.getCurrentUser()).thenReturn(Optional.of(new User("janedoe", "iloveyou", new ArrayList<>())));
        this.cartService.getCartItems();
    }

    /**
     * Method under test: {@link CartService#getCartItems()}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testGetCartItems3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.util.NoSuchElementException: No value present
        //       at java.util.Optional.get(Optional.java:135)
        //       at com.techie.shoppingstore.service.CartService.getCartItems(CartService.java:85)
        //   In order to prevent getCartItems()
        //   from throwing NoSuchElementException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getCartItems().
        //   See https://diff.blue/R013 to resolve this issue.

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setId("42");
        shoppingCart.setShoppingCartItems(new HashSet<>());
        shoppingCart.setUsername("janedoe");
        when(this.cartRepository.findByUsername((String) any())).thenReturn(shoppingCart);
        when(this.authService.getCurrentUser()).thenReturn(Optional.empty());
        this.cartService.getCartItems();
    }

    /**
     * Method under test: {@link CartService#getCartItems()}
     */
    @Test
    public void testGetCartItems4() {
        ShoppingCartItem shoppingCartItem = new ShoppingCartItem();
        shoppingCartItem.setTotal(4);

        HashSet<ShoppingCartItem> shoppingCartItemSet = new HashSet<>();
        shoppingCartItemSet.add(shoppingCartItem);

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setId("42");
        shoppingCart.setShoppingCartItems(shoppingCartItemSet);
        shoppingCart.setUsername("janedoe");
        when(this.cartRepository.findByUsername((String) any())).thenReturn(shoppingCart);
        when(this.authService.getCurrentUser()).thenReturn(Optional.of(new User("janedoe", "iloveyou", new ArrayList<>())));
        CartItems actualCartItems = this.cartService.getCartItems();
        assertSame(shoppingCart, actualCartItems.getShoppingCart());
        assertEquals(4, actualCartItems.getTotal().intValue());
        verify(this.cartRepository).findByUsername((String) any());
        verify(this.authService).getCurrentUser();
    }

    /**
     * Method under test: {@link CartService#getCartItems()}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testGetCartItems5() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.techie.shoppingstore.service.CartService.getCartItems(CartService.java:98)
        //   In order to prevent getCartItems()
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getCartItems().
        //   See https://diff.blue/R013 to resolve this issue.

        HashSet<ShoppingCartItem> shoppingCartItemSet = new HashSet<>();
        shoppingCartItemSet.add(null);

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setId("42");
        shoppingCart.setShoppingCartItems(shoppingCartItemSet);
        shoppingCart.setUsername("janedoe");
        when(this.cartRepository.findByUsername((String) any())).thenReturn(shoppingCart);
        when(this.authService.getCurrentUser()).thenReturn(Optional.of(new User("janedoe", "iloveyou", new ArrayList<>())));
        this.cartService.getCartItems();
    }

    /**
     * Method under test: {@link CartService#removeCartItem(ShoppingCartItem)}
     */
    @Test
    public void testRemoveCartItem() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setId("42");
        shoppingCart.setShoppingCartItems(new HashSet<>());
        shoppingCart.setUsername("janedoe");

        ShoppingCart shoppingCart1 = new ShoppingCart();
        shoppingCart1.setId("42");
        shoppingCart1.setShoppingCartItems(new HashSet<>());
        shoppingCart1.setUsername("janedoe");
        when(this.cartRepository.save((ShoppingCart) any())).thenReturn(shoppingCart1);
        when(this.cartRepository.findByUsername((String) any())).thenReturn(shoppingCart);
        when(this.authService.getCurrentUser()).thenReturn(Optional.of(new User("janedoe", "iloveyou", new ArrayList<>())));
        assertEquals("cart item removed successfully", this.cartService.removeCartItem(new ShoppingCartItem()));
        verify(this.cartRepository).findByUsername((String) any());
        verify(this.cartRepository).save((ShoppingCart) any());
        verify(this.authService).getCurrentUser();
    }

    /**
     * Method under test: {@link CartService#removeCartItem(ShoppingCartItem)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testRemoveCartItem2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.techie.shoppingstore.service.CartService.removeCartItem(CartService.java:118)
        //   In order to prevent removeCartItem(ShoppingCartItem)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   removeCartItem(ShoppingCartItem).
        //   See https://diff.blue/R013 to resolve this issue.

        HashSet<ShoppingCartItem> shoppingCartItemSet = new HashSet<>();
        shoppingCartItemSet.add(new ShoppingCartItem());

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setId("42");
        shoppingCart.setShoppingCartItems(shoppingCartItemSet);
        shoppingCart.setUsername("janedoe");

        ShoppingCart shoppingCart1 = new ShoppingCart();
        shoppingCart1.setId("42");
        shoppingCart1.setShoppingCartItems(new HashSet<>());
        shoppingCart1.setUsername("janedoe");
        when(this.cartRepository.save((ShoppingCart) any())).thenReturn(shoppingCart1);
        when(this.cartRepository.findByUsername((String) any())).thenReturn(shoppingCart);
        when(this.authService.getCurrentUser()).thenReturn(Optional.of(new User("janedoe", "iloveyou", new ArrayList<>())));
        this.cartService.removeCartItem(new ShoppingCartItem());
    }

    /**
     * Method under test: {@link CartService#removeCartItem(ShoppingCartItem)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testRemoveCartItem3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.techie.shoppingstore.service.CartService.removeCartItem(CartService.java:111)
        //   In order to prevent removeCartItem(ShoppingCartItem)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   removeCartItem(ShoppingCartItem).
        //   See https://diff.blue/R013 to resolve this issue.

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setId("42");
        shoppingCart.setShoppingCartItems(new HashSet<>());
        shoppingCart.setUsername("janedoe");

        ShoppingCart shoppingCart1 = new ShoppingCart();
        shoppingCart1.setId("42");
        shoppingCart1.setShoppingCartItems(new HashSet<>());
        shoppingCart1.setUsername("janedoe");
        when(this.cartRepository.save((ShoppingCart) any())).thenReturn(shoppingCart1);
        when(this.cartRepository.findByUsername((String) any())).thenReturn(shoppingCart);
        when(this.authService.getCurrentUser()).thenReturn(null);
        this.cartService.removeCartItem(new ShoppingCartItem());
    }

    /**
     * Method under test: {@link CartService#removeCartItem(ShoppingCartItem)}
     */
    @Test
    public void testRemoveCartItem4() {
        ShoppingCartItem shoppingCartItem = new ShoppingCartItem();
        shoppingCartItem.setProductName("Product Name");

        HashSet<ShoppingCartItem> shoppingCartItemSet = new HashSet<>();
        shoppingCartItemSet.add(shoppingCartItem);

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setId("42");
        shoppingCart.setShoppingCartItems(shoppingCartItemSet);
        shoppingCart.setUsername("janedoe");

        ShoppingCart shoppingCart1 = new ShoppingCart();
        shoppingCart1.setId("42");
        shoppingCart1.setShoppingCartItems(new HashSet<>());
        shoppingCart1.setUsername("janedoe");
        when(this.cartRepository.save((ShoppingCart) any())).thenReturn(shoppingCart1);
        when(this.cartRepository.findByUsername((String) any())).thenReturn(shoppingCart);
        when(this.authService.getCurrentUser()).thenReturn(Optional.of(new User("janedoe", "iloveyou", new ArrayList<>())));
        assertEquals("cart item removed successfully", this.cartService.removeCartItem(new ShoppingCartItem()));
        verify(this.cartRepository).findByUsername((String) any());
        verify(this.cartRepository).save((ShoppingCart) any());
        verify(this.authService).getCurrentUser();
    }

    /**
     * Method under test: {@link CartService#removeCartItem(ShoppingCartItem)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testRemoveCartItem5() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.techie.shoppingstore.service.CartService.removeCartItem(CartService.java:118)
        //   In order to prevent removeCartItem(ShoppingCartItem)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   removeCartItem(ShoppingCartItem).
        //   See https://diff.blue/R013 to resolve this issue.

        HashSet<ShoppingCartItem> shoppingCartItemSet = new HashSet<>();
        shoppingCartItemSet.add(null);

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setId("42");
        shoppingCart.setShoppingCartItems(shoppingCartItemSet);
        shoppingCart.setUsername("janedoe");

        ShoppingCart shoppingCart1 = new ShoppingCart();
        shoppingCart1.setId("42");
        shoppingCart1.setShoppingCartItems(new HashSet<>());
        shoppingCart1.setUsername("janedoe");
        when(this.cartRepository.save((ShoppingCart) any())).thenReturn(shoppingCart1);
        when(this.cartRepository.findByUsername((String) any())).thenReturn(shoppingCart);
        when(this.authService.getCurrentUser()).thenReturn(Optional.of(new User("janedoe", "iloveyou", new ArrayList<>())));
        this.cartService.removeCartItem(new ShoppingCartItem());
    }

    /**
     * Method under test: {@link CartService#removeCartItem(ShoppingCartItem)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testRemoveCartItem6() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.techie.shoppingstore.service.CartService.removeCartItem(CartService.java:118)
        //   In order to prevent removeCartItem(ShoppingCartItem)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   removeCartItem(ShoppingCartItem).
        //   See https://diff.blue/R013 to resolve this issue.

        HashSet<ShoppingCartItem> shoppingCartItemSet = new HashSet<>();
        shoppingCartItemSet.add(new ShoppingCartItem());

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setId("42");
        shoppingCart.setShoppingCartItems(shoppingCartItemSet);
        shoppingCart.setUsername("janedoe");

        ShoppingCart shoppingCart1 = new ShoppingCart();
        shoppingCart1.setId("42");
        shoppingCart1.setShoppingCartItems(new HashSet<>());
        shoppingCart1.setUsername("janedoe");
        when(this.cartRepository.save((ShoppingCart) any())).thenReturn(shoppingCart1);
        when(this.cartRepository.findByUsername((String) any())).thenReturn(shoppingCart);
        when(this.authService.getCurrentUser()).thenReturn(Optional.of(new User("janedoe", "iloveyou", new ArrayList<>())));
        this.cartService.removeCartItem(null);
    }

    /**
     * Method under test: {@link CartService#removeAllCartItem()}
     */
    @Test
    public void testRemoveAllCartItem() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setId("42");
        shoppingCart.setShoppingCartItems(new HashSet<>());
        shoppingCart.setUsername("janedoe");

        ShoppingCart shoppingCart1 = new ShoppingCart();
        shoppingCart1.setId("42");
        shoppingCart1.setShoppingCartItems(new HashSet<>());
        shoppingCart1.setUsername("janedoe");
        when(this.cartRepository.findByUsername((String) any())).thenReturn(shoppingCart);
        when(this.cartRepository.save((ShoppingCart) any())).thenReturn(shoppingCart1);
        when(this.authService.getCurrentUser()).thenReturn(Optional.of(new User("janedoe", "iloveyou", new ArrayList<>())));
        assertEquals("cart item removed successfully", this.cartService.removeAllCartItem());
        verify(this.cartRepository).findByUsername((String) any());
        verify(this.authService).getCurrentUser();
    }

    /**
     * Method under test: {@link CartService#removeAllCartItem()}
     */
    @Test
    public void testRemoveAllCartItem2() {
        HashSet<ShoppingCartItem> shoppingCartItemSet = new HashSet<>();
        shoppingCartItemSet.add(new ShoppingCartItem());

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setId("42");
        shoppingCart.setShoppingCartItems(shoppingCartItemSet);
        shoppingCart.setUsername("janedoe");

        ShoppingCart shoppingCart1 = new ShoppingCart();
        shoppingCart1.setId("42");
        shoppingCart1.setShoppingCartItems(new HashSet<>());
        shoppingCart1.setUsername("janedoe");
        when(this.cartRepository.findByUsername((String) any())).thenReturn(shoppingCart);
        when(this.cartRepository.save((ShoppingCart) any())).thenReturn(shoppingCart1);
        when(this.authService.getCurrentUser()).thenReturn(Optional.of(new User("janedoe", "iloveyou", new ArrayList<>())));
        assertEquals("cart item removed successfully", this.cartService.removeAllCartItem());
        verify(this.cartRepository).findByUsername((String) any());
        verify(this.cartRepository).save((ShoppingCart) any());
        verify(this.authService).getCurrentUser();
        assertTrue(this.cartService.getCartItems().getShoppingCart().getShoppingCartItems().isEmpty());
    }

    /**
     * Method under test: {@link CartService#removeAllCartItem()}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testRemoveAllCartItem3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.techie.shoppingstore.service.CartService.removeAllCartItem(CartService.java:150)
        //   In order to prevent removeAllCartItem()
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   removeAllCartItem().
        //   See https://diff.blue/R013 to resolve this issue.

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setId("42");
        shoppingCart.setShoppingCartItems(new HashSet<>());
        shoppingCart.setUsername("janedoe");

        ShoppingCart shoppingCart1 = new ShoppingCart();
        shoppingCart1.setId("42");
        shoppingCart1.setShoppingCartItems(new HashSet<>());
        shoppingCart1.setUsername("janedoe");
        when(this.cartRepository.findByUsername((String) any())).thenReturn(shoppingCart);
        when(this.cartRepository.save((ShoppingCart) any())).thenReturn(shoppingCart1);
        when(this.authService.getCurrentUser()).thenReturn(null);
        this.cartService.removeAllCartItem();
    }

    /**
     * Method under test: {@link CartService#removeOneQuantityFromCart(ShoppingCartItem)}
     */
    @Test
    public void testRemoveOneQuantityFromCart() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setId("42");
        shoppingCart.setShoppingCartItems(new HashSet<>());
        shoppingCart.setUsername("janedoe");

        ShoppingCart shoppingCart1 = new ShoppingCart();
        shoppingCart1.setId("42");
        shoppingCart1.setShoppingCartItems(new HashSet<>());
        shoppingCart1.setUsername("janedoe");
        when(this.cartRepository.save((ShoppingCart) any())).thenReturn(shoppingCart1);
        when(this.cartRepository.findByUsername((String) any())).thenReturn(shoppingCart);
        when(this.authService.getCurrentUser()).thenReturn(Optional.of(new User("janedoe", "iloveyou", new ArrayList<>())));
        assertEquals("cart item removed successfully", this.cartService.removeOneQuantityFromCart(new ShoppingCartItem()));
        verify(this.cartRepository).findByUsername((String) any());
        verify(this.cartRepository).save((ShoppingCart) any());
        verify(this.authService).getCurrentUser();
    }

    /**
     * Method under test: {@link CartService#removeOneQuantityFromCart(ShoppingCartItem)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testRemoveOneQuantityFromCart2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.techie.shoppingstore.service.CartService.removeOneQuantityFromCart(CartService.java:173)
        //   In order to prevent removeOneQuantityFromCart(ShoppingCartItem)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   removeOneQuantityFromCart(ShoppingCartItem).
        //   See https://diff.blue/R013 to resolve this issue.

        HashSet<ShoppingCartItem> shoppingCartItemSet = new HashSet<>();
        shoppingCartItemSet.add(new ShoppingCartItem());

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setId("42");
        shoppingCart.setShoppingCartItems(shoppingCartItemSet);
        shoppingCart.setUsername("janedoe");

        ShoppingCart shoppingCart1 = new ShoppingCart();
        shoppingCart1.setId("42");
        shoppingCart1.setShoppingCartItems(new HashSet<>());
        shoppingCart1.setUsername("janedoe");
        when(this.cartRepository.save((ShoppingCart) any())).thenReturn(shoppingCart1);
        when(this.cartRepository.findByUsername((String) any())).thenReturn(shoppingCart);
        when(this.authService.getCurrentUser()).thenReturn(Optional.of(new User("janedoe", "iloveyou", new ArrayList<>())));
        this.cartService.removeOneQuantityFromCart(new ShoppingCartItem());
    }

    /**
     * Method under test: {@link CartService#removeOneQuantityFromCart(ShoppingCartItem)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testRemoveOneQuantityFromCart3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.techie.shoppingstore.service.CartService.removeOneQuantityFromCart(CartService.java:166)
        //   In order to prevent removeOneQuantityFromCart(ShoppingCartItem)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   removeOneQuantityFromCart(ShoppingCartItem).
        //   See https://diff.blue/R013 to resolve this issue.

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setId("42");
        shoppingCart.setShoppingCartItems(new HashSet<>());
        shoppingCart.setUsername("janedoe");

        ShoppingCart shoppingCart1 = new ShoppingCart();
        shoppingCart1.setId("42");
        shoppingCart1.setShoppingCartItems(new HashSet<>());
        shoppingCart1.setUsername("janedoe");
        when(this.cartRepository.save((ShoppingCart) any())).thenReturn(shoppingCart1);
        when(this.cartRepository.findByUsername((String) any())).thenReturn(shoppingCart);
        when(this.authService.getCurrentUser()).thenReturn(null);
        this.cartService.removeOneQuantityFromCart(new ShoppingCartItem());
    }

    /**
     * Method under test: {@link CartService#removeOneQuantityFromCart(ShoppingCartItem)}
     */
    @Test
    public void testRemoveOneQuantityFromCart4() {
        ShoppingCartItem shoppingCartItem = new ShoppingCartItem();
        shoppingCartItem.setProductName("Product Name");

        HashSet<ShoppingCartItem> shoppingCartItemSet = new HashSet<>();
        shoppingCartItemSet.add(shoppingCartItem);

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setId("42");
        shoppingCart.setShoppingCartItems(shoppingCartItemSet);
        shoppingCart.setUsername("janedoe");

        ShoppingCart shoppingCart1 = new ShoppingCart();
        shoppingCart1.setId("42");
        shoppingCart1.setShoppingCartItems(new HashSet<>());
        shoppingCart1.setUsername("janedoe");
        when(this.cartRepository.save((ShoppingCart) any())).thenReturn(shoppingCart1);
        when(this.cartRepository.findByUsername((String) any())).thenReturn(shoppingCart);
        when(this.authService.getCurrentUser()).thenReturn(Optional.of(new User("janedoe", "iloveyou", new ArrayList<>())));
        assertEquals("cart item removed successfully", this.cartService.removeOneQuantityFromCart(new ShoppingCartItem()));
        verify(this.cartRepository).findByUsername((String) any());
        verify(this.cartRepository).save((ShoppingCart) any());
        verify(this.authService).getCurrentUser();
    }

    /**
     * Method under test: {@link CartService#removeOneQuantityFromCart(ShoppingCartItem)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testRemoveOneQuantityFromCart5() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.techie.shoppingstore.service.CartService.removeOneQuantityFromCart(CartService.java:173)
        //   In order to prevent removeOneQuantityFromCart(ShoppingCartItem)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   removeOneQuantityFromCart(ShoppingCartItem).
        //   See https://diff.blue/R013 to resolve this issue.

        HashSet<ShoppingCartItem> shoppingCartItemSet = new HashSet<>();
        shoppingCartItemSet.add(null);

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setId("42");
        shoppingCart.setShoppingCartItems(shoppingCartItemSet);
        shoppingCart.setUsername("janedoe");

        ShoppingCart shoppingCart1 = new ShoppingCart();
        shoppingCart1.setId("42");
        shoppingCart1.setShoppingCartItems(new HashSet<>());
        shoppingCart1.setUsername("janedoe");
        when(this.cartRepository.save((ShoppingCart) any())).thenReturn(shoppingCart1);
        when(this.cartRepository.findByUsername((String) any())).thenReturn(shoppingCart);
        when(this.authService.getCurrentUser()).thenReturn(Optional.of(new User("janedoe", "iloveyou", new ArrayList<>())));
        this.cartService.removeOneQuantityFromCart(new ShoppingCartItem());
    }

    /**
     * Method under test: {@link CartService#removeOneQuantityFromCart(ShoppingCartItem)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testRemoveOneQuantityFromCart6() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.techie.shoppingstore.service.CartService.removeOneQuantityFromCart(CartService.java:173)
        //   In order to prevent removeOneQuantityFromCart(ShoppingCartItem)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   removeOneQuantityFromCart(ShoppingCartItem).
        //   See https://diff.blue/R013 to resolve this issue.

        HashSet<ShoppingCartItem> shoppingCartItemSet = new HashSet<>();
        shoppingCartItemSet.add(new ShoppingCartItem());

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setId("42");
        shoppingCart.setShoppingCartItems(shoppingCartItemSet);
        shoppingCart.setUsername("janedoe");

        ShoppingCart shoppingCart1 = new ShoppingCart();
        shoppingCart1.setId("42");
        shoppingCart1.setShoppingCartItems(new HashSet<>());
        shoppingCart1.setUsername("janedoe");
        when(this.cartRepository.save((ShoppingCart) any())).thenReturn(shoppingCart1);
        when(this.cartRepository.findByUsername((String) any())).thenReturn(shoppingCart);
        when(this.authService.getCurrentUser()).thenReturn(Optional.of(new User("janedoe", "iloveyou", new ArrayList<>())));
        this.cartService.removeOneQuantityFromCart(null);
    }
}

