package com.techie.shoppingstore.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ProductRatingTest {
    /**
     * Method under test: {@link ProductRating#canEqual(Object)}
     */
    @Test
    public void testCanEqual() {
        assertFalse((new ProductRating()).canEqual("Other"));
    }

    /**
     * Method under test: {@link ProductRating#canEqual(Object)}
     */
    @Test
    public void testCanEqual2() {
        ProductRating productRating = new ProductRating();
        assertTrue(productRating.canEqual(new ProductRating()));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link ProductRating#ProductRating()}
     *   <li>{@link ProductRating#setElasticSearchProductId(String)}
     *   <li>{@link ProductRating#setId(String)}
     *   <li>{@link ProductRating#setProductId(String)}
     *   <li>{@link ProductRating#setRatingStars(Integer)}
     *   <li>{@link ProductRating#setReview(String)}
     *   <li>{@link ProductRating#setUserName(String)}
     * </ul>
     */
    @Test
    public void testConstructor() {
        ProductRating actualProductRating = new ProductRating();
        actualProductRating.setElasticSearchProductId("42");
        actualProductRating.setId("42");
        actualProductRating.setProductId("42");
        actualProductRating.setRatingStars(1);
        actualProductRating.setReview("Review");
        actualProductRating.setUserName("janedoe");
        assertEquals("42", actualProductRating.getElasticSearchProductId());
        assertEquals("42", actualProductRating.getId());
        assertEquals("42", actualProductRating.getProductId());
        assertEquals(1, actualProductRating.getRatingStars().intValue());
        assertEquals("Review", actualProductRating.getReview());
        assertEquals("janedoe", actualProductRating.getUserName());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link ProductRating#ProductRating(String, Integer, String, String, String, String)}
     *   <li>{@link ProductRating#setElasticSearchProductId(String)}
     *   <li>{@link ProductRating#setId(String)}
     *   <li>{@link ProductRating#setProductId(String)}
     *   <li>{@link ProductRating#setRatingStars(Integer)}
     *   <li>{@link ProductRating#setReview(String)}
     *   <li>{@link ProductRating#setUserName(String)}
     * </ul>
     */
    @Test
    public void testConstructor2() {
        ProductRating actualProductRating = new ProductRating("42", 1, "42", "42", "Review", "janedoe");
        actualProductRating.setElasticSearchProductId("42");
        actualProductRating.setId("42");
        actualProductRating.setProductId("42");
        actualProductRating.setRatingStars(1);
        actualProductRating.setReview("Review");
        actualProductRating.setUserName("janedoe");
        assertEquals("42", actualProductRating.getElasticSearchProductId());
        assertEquals("42", actualProductRating.getId());
        assertEquals("42", actualProductRating.getProductId());
        assertEquals(1, actualProductRating.getRatingStars().intValue());
        assertEquals("Review", actualProductRating.getReview());
        assertEquals("janedoe", actualProductRating.getUserName());
    }

    /**
     * Method under test: {@link ProductRating#equals(Object)}
     */
    @Test
    public void testEquals() {
        assertNotEquals(new ProductRating(), null);
        assertNotEquals(new ProductRating(), "Different type to ProductRating");
    }

    /**
     * Method under test: {@link ProductRating#equals(Object)}
     */
    @Test
    public void testEquals2() {
        ProductRating productRating = new ProductRating();
        assertEquals(productRating, productRating);
        int expectedHashCodeResult = productRating.hashCode();
        assertEquals(expectedHashCodeResult, productRating.hashCode());
    }

    /**
     * Method under test: {@link ProductRating#equals(Object)}
     */
    @Test
    public void testEquals3() {
        ProductRating productRating = new ProductRating();
        ProductRating productRating1 = new ProductRating();
        assertEquals(productRating, productRating1);
        int expectedHashCodeResult = productRating.hashCode();
        assertEquals(expectedHashCodeResult, productRating1.hashCode());
    }

    /**
     * Method under test: {@link ProductRating#equals(Object)}
     */
    @Test
    public void testEquals4() {
        ProductRating productRating = new ProductRating("42", 1, "42", "42", "Review", "janedoe");
        assertNotEquals(productRating, new ProductRating());
    }

    /**
     * Method under test: {@link ProductRating#equals(Object)}
     */
    @Test
    public void testEquals5() {
        ProductRating productRating = new ProductRating();
        assertNotEquals(productRating, new ProductRating("42", 1, "42", "42", "Review", "janedoe"));
    }

    /**
     * Method under test: {@link ProductRating#equals(Object)}
     */
    @Test
    public void testEquals6() {
        ProductRating productRating = new ProductRating();
        productRating.setRatingStars(1);
        assertNotEquals(productRating, new ProductRating());
    }

    /**
     * Method under test: {@link ProductRating#equals(Object)}
     */
    @Test
    public void testEquals7() {
        ProductRating productRating = new ProductRating();
        productRating.setProductId("42");
        assertNotEquals(productRating, new ProductRating());
    }

    /**
     * Method under test: {@link ProductRating#equals(Object)}
     */
    @Test
    public void testEquals8() {
        ProductRating productRating = new ProductRating();
        productRating.setElasticSearchProductId("42");
        assertNotEquals(productRating, new ProductRating());
    }

    /**
     * Method under test: {@link ProductRating#equals(Object)}
     */
    @Test
    public void testEquals9() {
        ProductRating productRating = new ProductRating();
        productRating.setReview("Review");
        assertNotEquals(productRating, new ProductRating());
    }

    /**
     * Method under test: {@link ProductRating#equals(Object)}
     */
    @Test
    public void testEquals10() {
        ProductRating productRating = new ProductRating();
        productRating.setUserName("janedoe");
        assertNotEquals(productRating, new ProductRating());
    }

    /**
     * Method under test: {@link ProductRating#equals(Object)}
     */
    @Test
    public void testEquals11() {
        ProductRating productRating = new ProductRating("42", 1, "42", "42", "Review", "janedoe");
        ProductRating productRating1 = new ProductRating("42", 1, "42", "42", "Review", "janedoe");

        assertEquals(productRating, productRating1);
        int expectedHashCodeResult = productRating.hashCode();
        assertEquals(expectedHashCodeResult, productRating1.hashCode());
    }

    /**
     * Method under test: {@link ProductRating#equals(Object)}
     */
    @Test
    public void testEquals12() {
        ProductRating productRating = new ProductRating();

        ProductRating productRating1 = new ProductRating();
        productRating1.setRatingStars(1);
        assertNotEquals(productRating, productRating1);
    }

    /**
     * Method under test: {@link ProductRating#equals(Object)}
     */
    @Test
    public void testEquals13() {
        ProductRating productRating = new ProductRating();

        ProductRating productRating1 = new ProductRating();
        productRating1.setProductId("42");
        assertNotEquals(productRating, productRating1);
    }

    /**
     * Method under test: {@link ProductRating#equals(Object)}
     */
    @Test
    public void testEquals14() {
        ProductRating productRating = new ProductRating();

        ProductRating productRating1 = new ProductRating();
        productRating1.setElasticSearchProductId("42");
        assertNotEquals(productRating, productRating1);
    }

    /**
     * Method under test: {@link ProductRating#equals(Object)}
     */
    @Test
    public void testEquals15() {
        ProductRating productRating = new ProductRating();

        ProductRating productRating1 = new ProductRating();
        productRating1.setReview("Review");
        assertNotEquals(productRating, productRating1);
    }

    /**
     * Method under test: {@link ProductRating#equals(Object)}
     */
    @Test
    public void testEquals16() {
        ProductRating productRating = new ProductRating();

        ProductRating productRating1 = new ProductRating();
        productRating1.setUserName("janedoe");
        assertNotEquals(productRating, productRating1);
    }
}

