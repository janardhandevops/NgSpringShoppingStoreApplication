package com.techie.shoppingstore.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CartRequestTest {
    /**
     * Method under test: {@link CartRequest#canEqual(Object)}
     */
    @Test
    public void testCanEqual() {
        assertFalse((new CartRequest()).canEqual("Other"));
    }

    /**
     * Method under test: {@link CartRequest#canEqual(Object)}
     */
    @Test
    public void testCanEqual2() {
        CartRequest cartRequest = new CartRequest();

        CartRequest cartRequest1 = new CartRequest();
        cartRequest1.setCartTotalPrice(3);
        cartRequest1.setNumberOfItems(1000);
        assertTrue(cartRequest.canEqual(cartRequest1));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link CartRequest}
     *   <li>{@link CartRequest#setCartTotalPrice(Integer)}
     *   <li>{@link CartRequest#setNumberOfItems(int)}
     * </ul>
     */
    @Test
    public void testConstructor() {
        CartRequest actualCartRequest = new CartRequest();
        actualCartRequest.setCartTotalPrice(1);
        actualCartRequest.setNumberOfItems(1000);
        assertEquals(1, actualCartRequest.getCartTotalPrice().intValue());
        assertEquals(1000, actualCartRequest.getNumberOfItems());
    }

    /**
     * Method under test: {@link CartRequest#equals(Object)}
     */
    @Test
    public void testEquals() {
        CartRequest cartRequest = new CartRequest();
        cartRequest.setCartTotalPrice(1);
        cartRequest.setNumberOfItems(1000);
        assertNotEquals(cartRequest, null);
    }

    /**
     * Method under test: {@link CartRequest#equals(Object)}
     */
    @Test
    public void testEquals2() {
        CartRequest cartRequest = new CartRequest();
        cartRequest.setCartTotalPrice(1);
        cartRequest.setNumberOfItems(1000);
        assertNotEquals(cartRequest, "Different type to CartRequest");
    }

    /**
     * Method under test: {@link CartRequest#equals(Object)}
     */
    @Test
    public void testEquals3() {
        CartRequest cartRequest = new CartRequest();
        cartRequest.setCartTotalPrice(1);
        cartRequest.setNumberOfItems(1000);
        assertEquals(cartRequest, cartRequest);
        int expectedHashCodeResult = cartRequest.hashCode();
        assertEquals(expectedHashCodeResult, cartRequest.hashCode());
    }

    /**
     * Method under test: {@link CartRequest#equals(Object)}
     */
    @Test
    public void testEquals4() {
        CartRequest cartRequest = new CartRequest();
        cartRequest.setCartTotalPrice(1);
        cartRequest.setNumberOfItems(1000);

        CartRequest cartRequest1 = new CartRequest();
        cartRequest1.setCartTotalPrice(1);
        cartRequest1.setNumberOfItems(1000);
        assertEquals(cartRequest, cartRequest1);
        int expectedHashCodeResult = cartRequest.hashCode();
        assertEquals(expectedHashCodeResult, cartRequest1.hashCode());
    }

    /**
     * Method under test: {@link CartRequest#equals(Object)}
     */
    @Test
    public void testEquals5() {
        CartRequest cartRequest = new CartRequest();
        cartRequest.setCartTotalPrice(3);
        cartRequest.setNumberOfItems(1000);

        CartRequest cartRequest1 = new CartRequest();
        cartRequest1.setCartTotalPrice(1);
        cartRequest1.setNumberOfItems(1000);
        assertNotEquals(cartRequest, cartRequest1);
    }

    /**
     * Method under test: {@link CartRequest#equals(Object)}
     */
    @Test
    public void testEquals6() {
        CartRequest cartRequest = new CartRequest();
        cartRequest.setCartTotalPrice(null);
        cartRequest.setNumberOfItems(1000);

        CartRequest cartRequest1 = new CartRequest();
        cartRequest1.setCartTotalPrice(1);
        cartRequest1.setNumberOfItems(1000);
        assertNotEquals(cartRequest, cartRequest1);
    }

    /**
     * Method under test: {@link CartRequest#equals(Object)}
     */
    @Test
    public void testEquals7() {
        CartRequest cartRequest = new CartRequest();
        cartRequest.setCartTotalPrice(1);
        cartRequest.setNumberOfItems(10);

        CartRequest cartRequest1 = new CartRequest();
        cartRequest1.setCartTotalPrice(1);
        cartRequest1.setNumberOfItems(1000);
        assertNotEquals(cartRequest, cartRequest1);
    }

    /**
     * Method under test: {@link CartRequest#equals(Object)}
     */
    @Test
    public void testEquals8() {
        CartRequest cartRequest = new CartRequest();
        cartRequest.setCartTotalPrice(null);
        cartRequest.setNumberOfItems(1000);

        CartRequest cartRequest1 = new CartRequest();
        cartRequest1.setCartTotalPrice(null);
        cartRequest1.setNumberOfItems(1000);
        assertEquals(cartRequest, cartRequest1);
        int expectedHashCodeResult = cartRequest.hashCode();
        assertEquals(expectedHashCodeResult, cartRequest1.hashCode());
    }
}

