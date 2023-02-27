package com.techie.shoppingstore.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ProductAvailabilityTest {
    /**
     * Method under test: {@link ProductAvailability#canEqual(Object)}
     */
    @Test
    public void testCanEqual() {
        assertFalse((new ProductAvailability("Availability", "Color")).canEqual("Other"));
    }

    /**
     * Method under test: {@link ProductAvailability#canEqual(Object)}
     */
    @Test
    public void testCanEqual2() {
        ProductAvailability productAvailability = new ProductAvailability("Availability", "Color");
        assertTrue(productAvailability.canEqual(new ProductAvailability("Availability", "Color")));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link ProductAvailability#ProductAvailability()}
     *   <li>{@link ProductAvailability#setAvailability(String)}
     *   <li>{@link ProductAvailability#setColor(String)}
     * </ul>
     */
    @Test
    public void testConstructor() {
        ProductAvailability actualProductAvailability = new ProductAvailability();
        actualProductAvailability.setAvailability("Availability");
        actualProductAvailability.setColor("Color");
        assertEquals("Availability", actualProductAvailability.getAvailability());
        assertEquals("Color", actualProductAvailability.getColor());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link ProductAvailability#ProductAvailability(String, String)}
     *   <li>{@link ProductAvailability#setAvailability(String)}
     *   <li>{@link ProductAvailability#setColor(String)}
     * </ul>
     */
    @Test
    public void testConstructor2() {
        ProductAvailability actualProductAvailability = new ProductAvailability("Availability", "Color");
        actualProductAvailability.setAvailability("Availability");
        actualProductAvailability.setColor("Color");
        assertEquals("Availability", actualProductAvailability.getAvailability());
        assertEquals("Color", actualProductAvailability.getColor());
    }

    /**
     * Method under test: {@link ProductAvailability#equals(Object)}
     */
    @Test
    public void testEquals() {
        assertNotEquals(new ProductAvailability("Availability", "Color"), null);
        assertNotEquals(new ProductAvailability("Availability", "Color"), "Different type to ProductAvailability");
    }

    /**
     * Method under test: {@link ProductAvailability#equals(Object)}
     */
    @Test
    public void testEquals2() {
        ProductAvailability productAvailability = new ProductAvailability("Availability", "Color");
        assertEquals(productAvailability, productAvailability);
        int expectedHashCodeResult = productAvailability.hashCode();
        assertEquals(expectedHashCodeResult, productAvailability.hashCode());
    }

    /**
     * Method under test: {@link ProductAvailability#equals(Object)}
     */
    @Test
    public void testEquals3() {
        ProductAvailability productAvailability = new ProductAvailability("Availability", "Color");
        ProductAvailability productAvailability1 = new ProductAvailability("Availability", "Color");

        assertEquals(productAvailability, productAvailability1);
        int expectedHashCodeResult = productAvailability.hashCode();
        assertEquals(expectedHashCodeResult, productAvailability1.hashCode());
    }

    /**
     * Method under test: {@link ProductAvailability#equals(Object)}
     */
    @Test
    public void testEquals4() {
        ProductAvailability productAvailability = new ProductAvailability("Color", "Color");
        assertNotEquals(productAvailability, new ProductAvailability("Availability", "Color"));
    }

    /**
     * Method under test: {@link ProductAvailability#equals(Object)}
     */
    @Test
    public void testEquals5() {
        ProductAvailability productAvailability = new ProductAvailability(null, "Color");
        assertNotEquals(productAvailability, new ProductAvailability("Availability", "Color"));
    }

    /**
     * Method under test: {@link ProductAvailability#equals(Object)}
     */
    @Test
    public void testEquals6() {
        ProductAvailability productAvailability = new ProductAvailability("Availability", "Availability");
        assertNotEquals(productAvailability, new ProductAvailability("Availability", "Color"));
    }

    /**
     * Method under test: {@link ProductAvailability#equals(Object)}
     */
    @Test
    public void testEquals7() {
        ProductAvailability productAvailability = new ProductAvailability("Availability", null);
        assertNotEquals(productAvailability, new ProductAvailability("Availability", "Color"));
    }

    /**
     * Method under test: {@link ProductAvailability#equals(Object)}
     */
    @Test
    public void testEquals8() {
        ProductAvailability productAvailability = new ProductAvailability(null, "Color");
        ProductAvailability productAvailability1 = new ProductAvailability(null, "Color");

        assertEquals(productAvailability, productAvailability1);
        int expectedHashCodeResult = productAvailability.hashCode();
        assertEquals(expectedHashCodeResult, productAvailability1.hashCode());
    }

    /**
     * Method under test: {@link ProductAvailability#equals(Object)}
     */
    @Test
    public void testEquals9() {
        ProductAvailability productAvailability = new ProductAvailability("Availability", null);
        ProductAvailability productAvailability1 = new ProductAvailability("Availability", null);

        assertEquals(productAvailability, productAvailability1);
        int expectedHashCodeResult = productAvailability.hashCode();
        assertEquals(expectedHashCodeResult, productAvailability1.hashCode());
    }
}

