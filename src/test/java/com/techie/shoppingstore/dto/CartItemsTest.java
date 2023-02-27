package com.techie.shoppingstore.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import com.techie.shoppingstore.model.ShoppingCart;

import java.util.HashSet;

import org.junit.Test;

public class CartItemsTest {
    /**
     * Method under test: {@link CartItems#canEqual(Object)}
     */
    @Test
    public void testCanEqual() {
        assertFalse((new CartItems()).canEqual("Other"));
    }

    /**
     * Method under test: {@link CartItems#canEqual(Object)}
     */
    @Test
    public void testCanEqual2() {
        CartItems cartItems = new CartItems();
        assertTrue(cartItems.canEqual(new CartItems()));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link CartItems#CartItems()}
     *   <li>{@link CartItems#setShoppingCart(ShoppingCart)}
     *   <li>{@link CartItems#setTotal(Integer)}
     * </ul>
     */
    @Test
    public void testConstructor() {
        CartItems actualCartItems = new CartItems();
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setId("42");
        shoppingCart.setShoppingCartItems(new HashSet<>());
        shoppingCart.setUsername("janedoe");
        actualCartItems.setShoppingCart(shoppingCart);
        actualCartItems.setTotal(1);
        assertSame(shoppingCart, actualCartItems.getShoppingCart());
        assertEquals(1, actualCartItems.getTotal().intValue());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link CartItems#CartItems(ShoppingCart, Integer)}
     *   <li>{@link CartItems#setShoppingCart(ShoppingCart)}
     *   <li>{@link CartItems#setTotal(Integer)}
     * </ul>
     */
    @Test
    public void testConstructor2() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setId("42");
        shoppingCart.setShoppingCartItems(new HashSet<>());
        shoppingCart.setUsername("janedoe");
        CartItems actualCartItems = new CartItems(shoppingCart, 1);
        ShoppingCart shoppingCart1 = new ShoppingCart();
        shoppingCart1.setId("42");
        shoppingCart1.setShoppingCartItems(new HashSet<>());
        shoppingCart1.setUsername("janedoe");
        actualCartItems.setShoppingCart(shoppingCart1);
        actualCartItems.setTotal(1);
        ShoppingCart shoppingCart2 = actualCartItems.getShoppingCart();
        assertSame(shoppingCart1, shoppingCart2);
        assertEquals(shoppingCart, shoppingCart2);
        assertEquals(1, actualCartItems.getTotal().intValue());
    }

    /**
     * Method under test: {@link CartItems#equals(Object)}
     */
    @Test
    public void testEquals() {
        assertNotEquals(new CartItems(), null);
        assertNotEquals(new CartItems(), "Different type to CartItems");
    }

    /**
     * Method under test: {@link CartItems#equals(Object)}
     */
    @Test
    public void testEquals2() {
        CartItems cartItems = new CartItems();
        assertEquals(cartItems, cartItems);
        int expectedHashCodeResult = cartItems.hashCode();
        assertEquals(expectedHashCodeResult, cartItems.hashCode());
    }

    /**
     * Method under test: {@link CartItems#equals(Object)}
     */
    @Test
    public void testEquals3() {
        CartItems cartItems = new CartItems();
        CartItems cartItems1 = new CartItems();
        assertEquals(cartItems, cartItems1);
        int expectedHashCodeResult = cartItems.hashCode();
        assertEquals(expectedHashCodeResult, cartItems1.hashCode());
    }

    /**
     * Method under test: {@link CartItems#equals(Object)}
     */
    @Test
    public void testEquals4() {
        CartItems cartItems = new CartItems(new ShoppingCart(), 1);
        assertNotEquals(cartItems, new CartItems());
    }

    /**
     * Method under test: {@link CartItems#equals(Object)}
     */
    @Test
    public void testEquals5() {
        CartItems cartItems = new CartItems();
        assertNotEquals(cartItems, new CartItems(new ShoppingCart(), 1));
    }

    /**
     * Method under test: {@link CartItems#equals(Object)}
     */
    @Test
    public void testEquals6() {
        CartItems cartItems = new CartItems();
        cartItems.setTotal(1);
        assertNotEquals(cartItems, new CartItems());
    }

    /**
     * Method under test: {@link CartItems#equals(Object)}
     */
    @Test
    public void testEquals7() {
        CartItems cartItems = new CartItems(mock(ShoppingCart.class), 1);
        assertNotEquals(cartItems, new CartItems());
    }

    /**
     * Method under test: {@link CartItems#equals(Object)}
     */
    @Test
    public void testEquals8() {
        CartItems cartItems = new CartItems(new ShoppingCart(), 1);
        CartItems cartItems1 = new CartItems(new ShoppingCart(), 1);

        assertEquals(cartItems, cartItems1);
        int expectedHashCodeResult = cartItems.hashCode();
        assertEquals(expectedHashCodeResult, cartItems1.hashCode());
    }

    /**
     * Method under test: {@link CartItems#equals(Object)}
     */
    @Test
    public void testEquals9() {
        CartItems cartItems = new CartItems();

        CartItems cartItems1 = new CartItems();
        cartItems1.setTotal(1);
        assertNotEquals(cartItems, cartItems1);
    }
}

