package com.techie.shoppingstore.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

public class ShoppingCartDtoTest {
    /**
     * Method under test: {@link ShoppingCartDto#canEqual(Object)}
     */
    @Test
    public void testCanEqual() {
        assertFalse((new ShoppingCartDto()).canEqual("Other"));
    }

    /**
     * Method under test: {@link ShoppingCartDto#canEqual(Object)}
     */
    @Test
    public void testCanEqual2() {
        ShoppingCartDto shoppingCartDto = new ShoppingCartDto();
        assertTrue(shoppingCartDto.canEqual(new ShoppingCartDto()));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link ShoppingCartDto#ShoppingCartDto()}
     *   <li>{@link ShoppingCartDto#setCartItemList(ArrayList)}
     *   <li>{@link ShoppingCartDto#setGrandTotal(Integer)}
     * </ul>
     */
    @Test
    public void testConstructor() {
        ShoppingCartDto actualShoppingCartDto = new ShoppingCartDto();
        ArrayList<ShoppingCartProductDto> shoppingCartProductDtoList = new ArrayList<>();
        actualShoppingCartDto.setCartItemList(shoppingCartProductDtoList);
        actualShoppingCartDto.setGrandTotal(1);
        assertSame(shoppingCartProductDtoList, actualShoppingCartDto.getCartItemList());
        assertEquals(1, actualShoppingCartDto.getGrandTotal().intValue());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link ShoppingCartDto#ShoppingCartDto(ArrayList, Integer)}
     *   <li>{@link ShoppingCartDto#setCartItemList(ArrayList)}
     *   <li>{@link ShoppingCartDto#setGrandTotal(Integer)}
     * </ul>
     */
    @Test
    public void testConstructor2() {
        ShoppingCartDto actualShoppingCartDto = new ShoppingCartDto(new ArrayList<>(), 1);
        ArrayList<ShoppingCartProductDto> shoppingCartProductDtoList = new ArrayList<>();
        actualShoppingCartDto.setCartItemList(shoppingCartProductDtoList);
        actualShoppingCartDto.setGrandTotal(1);
        assertSame(shoppingCartProductDtoList, actualShoppingCartDto.getCartItemList());
        assertEquals(1, actualShoppingCartDto.getGrandTotal().intValue());
    }

    /**
     * Method under test: {@link ShoppingCartDto#equals(Object)}
     */
    @Test
    public void testEquals() {
        assertNotEquals(new ShoppingCartDto(), null);
        assertNotEquals(new ShoppingCartDto(), "Different type to ShoppingCartDto");
    }

    /**
     * Method under test: {@link ShoppingCartDto#equals(Object)}
     */
    @Test
    public void testEquals2() {
        ShoppingCartDto shoppingCartDto = new ShoppingCartDto();
        assertEquals(shoppingCartDto, shoppingCartDto);
        int expectedHashCodeResult = shoppingCartDto.hashCode();
        assertEquals(expectedHashCodeResult, shoppingCartDto.hashCode());
    }

    /**
     * Method under test: {@link ShoppingCartDto#equals(Object)}
     */
    @Test
    public void testEquals3() {
        ShoppingCartDto shoppingCartDto = new ShoppingCartDto();
        ShoppingCartDto shoppingCartDto1 = new ShoppingCartDto();
        assertEquals(shoppingCartDto, shoppingCartDto1);
        int expectedHashCodeResult = shoppingCartDto.hashCode();
        assertEquals(expectedHashCodeResult, shoppingCartDto1.hashCode());
    }

    /**
     * Method under test: {@link ShoppingCartDto#equals(Object)}
     */
    @Test
    public void testEquals4() {
        ShoppingCartDto shoppingCartDto = new ShoppingCartDto(new ArrayList<>(), 1);
        assertNotEquals(shoppingCartDto, new ShoppingCartDto());
    }

    /**
     * Method under test: {@link ShoppingCartDto#equals(Object)}
     */
    @Test
    public void testEquals5() {
        ShoppingCartDto shoppingCartDto = new ShoppingCartDto();
        assertNotEquals(shoppingCartDto, new ShoppingCartDto(new ArrayList<>(), 1));
    }

    /**
     * Method under test: {@link ShoppingCartDto#equals(Object)}
     */
    @Test
    public void testEquals6() {
        ShoppingCartDto shoppingCartDto = new ShoppingCartDto();
        shoppingCartDto.setGrandTotal(1);
        assertNotEquals(shoppingCartDto, new ShoppingCartDto());
    }

    /**
     * Method under test: {@link ShoppingCartDto#equals(Object)}
     */
    @Test
    public void testEquals7() {
        ShoppingCartDto shoppingCartDto = new ShoppingCartDto(new ArrayList<>(), 1);
        ShoppingCartDto shoppingCartDto1 = new ShoppingCartDto(new ArrayList<>(), 1);

        assertEquals(shoppingCartDto, shoppingCartDto1);
        int expectedHashCodeResult = shoppingCartDto.hashCode();
        assertEquals(expectedHashCodeResult, shoppingCartDto1.hashCode());
    }

    /**
     * Method under test: {@link ShoppingCartDto#equals(Object)}
     */
    @Test
    public void testEquals8() {
        ShoppingCartDto shoppingCartDto = new ShoppingCartDto();

        ShoppingCartDto shoppingCartDto1 = new ShoppingCartDto();
        shoppingCartDto1.setGrandTotal(1);
        assertNotEquals(shoppingCartDto, shoppingCartDto1);
    }
}

