package com.techie.shoppingstore.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ProductRatingDtoTest {
    /**
     * Method under test: {@link ProductRatingDto#canEqual(Object)}
     */
    @Test
    public void testCanEqual() {
        assertFalse((new ProductRatingDto()).canEqual("Other"));
    }

    /**
     * Method under test: {@link ProductRatingDto#canEqual(Object)}
     */
    @Test
    public void testCanEqual2() {
        ProductRatingDto productRatingDto = new ProductRatingDto();
        assertTrue(productRatingDto.canEqual(new ProductRatingDto()));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link ProductRatingDto#ProductRatingDto()}
     *   <li>{@link ProductRatingDto#setRatingId(String)}
     *   <li>{@link ProductRatingDto#setRatingStars(Integer)}
     *   <li>{@link ProductRatingDto#setReview(String)}
     *   <li>{@link ProductRatingDto#setSku(String)}
     *   <li>{@link ProductRatingDto#setUserName(String)}
     * </ul>
     */
    @Test
    public void testConstructor() {
        ProductRatingDto actualProductRatingDto = new ProductRatingDto();
        actualProductRatingDto.setRatingId("42");
        actualProductRatingDto.setRatingStars(1);
        actualProductRatingDto.setReview("Review");
        actualProductRatingDto.setSku("Sku");
        actualProductRatingDto.setUserName("janedoe");
        assertEquals("42", actualProductRatingDto.getRatingId());
        assertEquals(1, actualProductRatingDto.getRatingStars().intValue());
        assertEquals("Review", actualProductRatingDto.getReview());
        assertEquals("Sku", actualProductRatingDto.getSku());
        assertEquals("janedoe", actualProductRatingDto.getUserName());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link ProductRatingDto#ProductRatingDto(String, Integer, String, String, String)}
     *   <li>{@link ProductRatingDto#setRatingId(String)}
     *   <li>{@link ProductRatingDto#setRatingStars(Integer)}
     *   <li>{@link ProductRatingDto#setReview(String)}
     *   <li>{@link ProductRatingDto#setSku(String)}
     *   <li>{@link ProductRatingDto#setUserName(String)}
     * </ul>
     */
    @Test
    public void testConstructor2() {
        ProductRatingDto actualProductRatingDto = new ProductRatingDto("42", 1, "Review", "janedoe", "Sku");
        actualProductRatingDto.setRatingId("42");
        actualProductRatingDto.setRatingStars(1);
        actualProductRatingDto.setReview("Review");
        actualProductRatingDto.setSku("Sku");
        actualProductRatingDto.setUserName("janedoe");
        assertEquals("42", actualProductRatingDto.getRatingId());
        assertEquals(1, actualProductRatingDto.getRatingStars().intValue());
        assertEquals("Review", actualProductRatingDto.getReview());
        assertEquals("Sku", actualProductRatingDto.getSku());
        assertEquals("janedoe", actualProductRatingDto.getUserName());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link ProductRatingDto#ProductRatingDto()}
     *   <li>{@link ProductRatingDto#setRatingId(String)}
     *   <li>{@link ProductRatingDto#setRatingStars(Integer)}
     *   <li>{@link ProductRatingDto#setReview(String)}
     *   <li>{@link ProductRatingDto#setSku(String)}
     *   <li>{@link ProductRatingDto#setUserName(String)}
     * </ul>
     */
    @Test
    public void testConstructor3() {
        ProductRatingDto actualProductRatingDto = new ProductRatingDto();
        actualProductRatingDto.setRatingId("42");
        actualProductRatingDto.setRatingStars(1);
        actualProductRatingDto.setReview("Review");
        actualProductRatingDto.setSku("Sku");
        actualProductRatingDto.setUserName("janedoe");
        assertEquals("42", actualProductRatingDto.getRatingId());
        assertEquals(1, actualProductRatingDto.getRatingStars().intValue());
        assertEquals("Review", actualProductRatingDto.getReview());
        assertEquals("Sku", actualProductRatingDto.getSku());
        assertEquals("janedoe", actualProductRatingDto.getUserName());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link ProductRatingDto#ProductRatingDto(String, Integer, String, String, String)}
     *   <li>{@link ProductRatingDto#setRatingId(String)}
     *   <li>{@link ProductRatingDto#setRatingStars(Integer)}
     *   <li>{@link ProductRatingDto#setReview(String)}
     *   <li>{@link ProductRatingDto#setSku(String)}
     *   <li>{@link ProductRatingDto#setUserName(String)}
     * </ul>
     */
    @Test
    public void testConstructor4() {
        ProductRatingDto actualProductRatingDto = new ProductRatingDto("42", 1, "Review", "janedoe", "Sku");
        actualProductRatingDto.setRatingId("42");
        actualProductRatingDto.setRatingStars(1);
        actualProductRatingDto.setReview("Review");
        actualProductRatingDto.setSku("Sku");
        actualProductRatingDto.setUserName("janedoe");
        assertEquals("42", actualProductRatingDto.getRatingId());
        assertEquals(1, actualProductRatingDto.getRatingStars().intValue());
        assertEquals("Review", actualProductRatingDto.getReview());
        assertEquals("Sku", actualProductRatingDto.getSku());
        assertEquals("janedoe", actualProductRatingDto.getUserName());
    }

    /**
     * Method under test: {@link ProductRatingDto#equals(Object)}
     */
    @Test
    public void testEquals() {
        assertNotEquals(new ProductRatingDto(), null);
        assertNotEquals(new ProductRatingDto(), "Different type to ProductRatingDto");
        assertNotEquals(new ProductRatingDto(), null);
        assertNotEquals(new ProductRatingDto(), "Different type to ProductRatingDto");
    }

    /**
     * Method under test: {@link ProductRatingDto#equals(Object)}
     */
    @Test
    public void testEquals2() {
        ProductRatingDto productRatingDto = new ProductRatingDto();
        assertEquals(productRatingDto, productRatingDto);
        int expectedHashCodeResult = productRatingDto.hashCode();
        assertEquals(expectedHashCodeResult, productRatingDto.hashCode());
    }

    /**
     * Method under test: {@link ProductRatingDto#equals(Object)}
     */
    @Test
    public void testEquals3() {
        ProductRatingDto productRatingDto = new ProductRatingDto();
        ProductRatingDto productRatingDto1 = new ProductRatingDto();
        assertEquals(productRatingDto, productRatingDto1);
        int expectedHashCodeResult = productRatingDto.hashCode();
        assertEquals(expectedHashCodeResult, productRatingDto1.hashCode());
    }

    /**
     * Method under test: {@link ProductRatingDto#equals(Object)}
     */
    @Test
    public void testEquals4() {
        ProductRatingDto productRatingDto = new ProductRatingDto("42", 1, "Review", "janedoe", "Sku");
        assertNotEquals(productRatingDto, new ProductRatingDto());
    }

    /**
     * Method under test: {@link ProductRatingDto#equals(Object)}
     */
    @Test
    public void testEquals5() {
        ProductRatingDto productRatingDto = new ProductRatingDto();
        assertNotEquals(productRatingDto, new ProductRatingDto("42", 1, "Review", "janedoe", "Sku"));
    }

    /**
     * Method under test: {@link ProductRatingDto#equals(Object)}
     */
    @Test
    public void testEquals6() {
        ProductRatingDto productRatingDto = new ProductRatingDto();
        productRatingDto.setRatingStars(1);
        assertNotEquals(productRatingDto, new ProductRatingDto());
    }

    /**
     * Method under test: {@link ProductRatingDto#equals(Object)}
     */
    @Test
    public void testEquals7() {
        ProductRatingDto productRatingDto = new ProductRatingDto();
        productRatingDto.setReview("Review");
        assertNotEquals(productRatingDto, new ProductRatingDto());
    }

    /**
     * Method under test: {@link ProductRatingDto#equals(Object)}
     */
    @Test
    public void testEquals8() {
        ProductRatingDto productRatingDto = new ProductRatingDto();
        productRatingDto.setUserName("janedoe");
        assertNotEquals(productRatingDto, new ProductRatingDto());
    }

    /**
     * Method under test: {@link ProductRatingDto#equals(Object)}
     */
    @Test
    public void testEquals9() {
        ProductRatingDto productRatingDto = new ProductRatingDto();
        productRatingDto.setSku("Sku");
        assertNotEquals(productRatingDto, new ProductRatingDto());
    }

    /**
     * Method under test: {@link ProductRatingDto#equals(Object)}
     */
    @Test
    public void testEquals10() {
        ProductRatingDto productRatingDto = new ProductRatingDto("42", 1, "Review", "janedoe", "Sku");
        ProductRatingDto productRatingDto1 = new ProductRatingDto("42", 1, "Review", "janedoe", "Sku");

        assertEquals(productRatingDto, productRatingDto1);
        int expectedHashCodeResult = productRatingDto.hashCode();
        assertEquals(expectedHashCodeResult, productRatingDto1.hashCode());
    }

    /**
     * Method under test: {@link ProductRatingDto#equals(Object)}
     */
    @Test
    public void testEquals11() {
        ProductRatingDto productRatingDto = new ProductRatingDto();

        ProductRatingDto productRatingDto1 = new ProductRatingDto();
        productRatingDto1.setRatingStars(1);
        assertNotEquals(productRatingDto, productRatingDto1);
    }

    /**
     * Method under test: {@link ProductRatingDto#equals(Object)}
     */
    @Test
    public void testEquals12() {
        ProductRatingDto productRatingDto = new ProductRatingDto();

        ProductRatingDto productRatingDto1 = new ProductRatingDto();
        productRatingDto1.setReview("Review");
        assertNotEquals(productRatingDto, productRatingDto1);
    }

    /**
     * Method under test: {@link ProductRatingDto#equals(Object)}
     */
    @Test
    public void testEquals13() {
        ProductRatingDto productRatingDto = new ProductRatingDto();

        ProductRatingDto productRatingDto1 = new ProductRatingDto();
        productRatingDto1.setUserName("janedoe");
        assertNotEquals(productRatingDto, productRatingDto1);
    }

    /**
     * Method under test: {@link ProductRatingDto#equals(Object)}
     */
    @Test
    public void testEquals14() {
        ProductRatingDto productRatingDto = new ProductRatingDto();

        ProductRatingDto productRatingDto1 = new ProductRatingDto();
        productRatingDto1.setSku("Sku");
        assertNotEquals(productRatingDto, productRatingDto1);
    }

    /**
     * Method under test: {@link ProductRatingDto#equals(Object)}
     */
    @Test
    public void testEquals15() {
        ProductRatingDto productRatingDto = new ProductRatingDto();
        assertEquals(productRatingDto, productRatingDto);
        int expectedHashCodeResult = productRatingDto.hashCode();
        assertEquals(expectedHashCodeResult, productRatingDto.hashCode());
    }

    /**
     * Method under test: {@link ProductRatingDto#equals(Object)}
     */
    @Test
    public void testEquals16() {
        ProductRatingDto productRatingDto = new ProductRatingDto();
        ProductRatingDto productRatingDto1 = new ProductRatingDto();
        assertEquals(productRatingDto, productRatingDto1);
        int expectedHashCodeResult = productRatingDto.hashCode();
        assertEquals(expectedHashCodeResult, productRatingDto1.hashCode());
    }

    /**
     * Method under test: {@link ProductRatingDto#equals(Object)}
     */
    @Test
    public void testEquals17() {
        ProductRatingDto productRatingDto = new ProductRatingDto("42", 1, "Review", "janedoe", "Sku");
        assertNotEquals(productRatingDto, new ProductRatingDto());
    }

    /**
     * Method under test: {@link ProductRatingDto#equals(Object)}
     */
    @Test
    public void testEquals18() {
        ProductRatingDto productRatingDto = new ProductRatingDto();
        assertNotEquals(productRatingDto, new ProductRatingDto("42", 1, "Review", "janedoe", "Sku"));
    }

    /**
     * Method under test: {@link ProductRatingDto#equals(Object)}
     */
    @Test
    public void testEquals19() {
        ProductRatingDto productRatingDto = new ProductRatingDto();
        productRatingDto.setRatingStars(1);
        assertNotEquals(productRatingDto, new ProductRatingDto());
    }

    /**
     * Method under test: {@link ProductRatingDto#equals(Object)}
     */
    @Test
    public void testEquals20() {
        ProductRatingDto productRatingDto = new ProductRatingDto();
        productRatingDto.setReview("Review");
        assertNotEquals(productRatingDto, new ProductRatingDto());
    }

    /**
     * Method under test: {@link ProductRatingDto#equals(Object)}
     */
    @Test
    public void testEquals21() {
        ProductRatingDto productRatingDto = new ProductRatingDto();
        productRatingDto.setUserName("janedoe");
        assertNotEquals(productRatingDto, new ProductRatingDto());
    }

    /**
     * Method under test: {@link ProductRatingDto#equals(Object)}
     */
    @Test
    public void testEquals22() {
        ProductRatingDto productRatingDto = new ProductRatingDto();
        productRatingDto.setSku("Sku");
        assertNotEquals(productRatingDto, new ProductRatingDto());
    }

    /**
     * Method under test: {@link ProductRatingDto#equals(Object)}
     */
    @Test
    public void testEquals23() {
        ProductRatingDto productRatingDto = new ProductRatingDto("42", 1, "Review", "janedoe", "Sku");
        ProductRatingDto productRatingDto1 = new ProductRatingDto("42", 1, "Review", "janedoe", "Sku");

        assertEquals(productRatingDto, productRatingDto1);
        int expectedHashCodeResult = productRatingDto.hashCode();
        assertEquals(expectedHashCodeResult, productRatingDto1.hashCode());
    }

    /**
     * Method under test: {@link ProductRatingDto#equals(Object)}
     */
    @Test
    public void testEquals24() {
        ProductRatingDto productRatingDto = new ProductRatingDto();

        ProductRatingDto productRatingDto1 = new ProductRatingDto();
        productRatingDto1.setRatingStars(1);
        assertNotEquals(productRatingDto, productRatingDto1);
    }

    /**
     * Method under test: {@link ProductRatingDto#equals(Object)}
     */
    @Test
    public void testEquals25() {
        ProductRatingDto productRatingDto = new ProductRatingDto();

        ProductRatingDto productRatingDto1 = new ProductRatingDto();
        productRatingDto1.setReview("Review");
        assertNotEquals(productRatingDto, productRatingDto1);
    }

    /**
     * Method under test: {@link ProductRatingDto#equals(Object)}
     */
    @Test
    public void testEquals26() {
        ProductRatingDto productRatingDto = new ProductRatingDto();

        ProductRatingDto productRatingDto1 = new ProductRatingDto();
        productRatingDto1.setUserName("janedoe");
        assertNotEquals(productRatingDto, productRatingDto1);
    }

    /**
     * Method under test: {@link ProductRatingDto#equals(Object)}
     */
    @Test
    public void testEquals27() {
        ProductRatingDto productRatingDto = new ProductRatingDto();

        ProductRatingDto productRatingDto1 = new ProductRatingDto();
        productRatingDto1.setSku("Sku");
        assertNotEquals(productRatingDto, productRatingDto1);
    }
}

