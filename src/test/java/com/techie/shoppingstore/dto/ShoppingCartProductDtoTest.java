package com.techie.shoppingstore.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.techie.shoppingstore.model.ProductAttribute;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ShoppingCartProductDtoTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link ShoppingCartProductDto#ShoppingCartProductDto()}
     *   <li>{@link ShoppingCartProductDto#setAttributeList(List)}
     *   <li>{@link ShoppingCartProductDto#setAvailability(ProductAvailability)}
     *   <li>{@link ShoppingCartProductDto#setDescription(String)}
     *   <li>{@link ShoppingCartProductDto#setFeatured(boolean)}
     *   <li>{@link ShoppingCartProductDto#setImageUrl(String)}
     *   <li>{@link ShoppingCartProductDto#setManufacturer(String)}
     *   <li>{@link ShoppingCartProductDto#setPrice(Integer)}
     *   <li>{@link ShoppingCartProductDto#setProductName(String)}
     *   <li>{@link ShoppingCartProductDto#setSku(String)}
     *   <li>{@link ShoppingCartProductDto#setTotal(Integer)}
     * </ul>
     */
    @Test
    public void testConstructor() {
        ShoppingCartProductDto actualShoppingCartProductDto = new ShoppingCartProductDto();
        ArrayList<ProductAttribute> productAttributeList = new ArrayList<>();
        actualShoppingCartProductDto.setAttributeList(productAttributeList);
        ProductAvailability productAvailability = new ProductAvailability("Availability", "Color");

        actualShoppingCartProductDto.setAvailability(productAvailability);
        actualShoppingCartProductDto.setDescription("The characteristics of someone or something");
        actualShoppingCartProductDto.setFeatured(true);
        actualShoppingCartProductDto.setImageUrl("https://example.org/example");
        actualShoppingCartProductDto.setManufacturer("Manufacturer");
        actualShoppingCartProductDto.setPrice(1);
        actualShoppingCartProductDto.setProductName("Product Name");
        actualShoppingCartProductDto.setSku("Sku");
        actualShoppingCartProductDto.setTotal(1);
        assertNull(actualShoppingCartProductDto.getAddtoCart());
        assertSame(productAttributeList, actualShoppingCartProductDto.getAttributeList());
        assertSame(productAvailability, actualShoppingCartProductDto.getAvailability());
        assertEquals("The characteristics of someone or something", actualShoppingCartProductDto.getDescription());
        assertEquals("https://example.org/example", actualShoppingCartProductDto.getImageUrl());
        assertEquals("Manufacturer", actualShoppingCartProductDto.getManufacturer());
        assertEquals(1, actualShoppingCartProductDto.getPrice().intValue());
        assertEquals("Product Name", actualShoppingCartProductDto.getProductName());
        assertNull(actualShoppingCartProductDto.getProductRatingDtoList());
        assertEquals("Sku", actualShoppingCartProductDto.getSku());
        assertEquals(1, actualShoppingCartProductDto.getTotal().intValue());
        assertTrue(actualShoppingCartProductDto.isFeatured());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link ShoppingCartProductDto#ShoppingCartProductDto(String, String, String, Integer, String, String, ProductAvailability, List, Integer, boolean, List, Integer)}
     *   <li>{@link ShoppingCartProductDto#setAttributeList(List)}
     *   <li>{@link ShoppingCartProductDto#setAvailability(ProductAvailability)}
     *   <li>{@link ShoppingCartProductDto#setDescription(String)}
     *   <li>{@link ShoppingCartProductDto#setFeatured(boolean)}
     *   <li>{@link ShoppingCartProductDto#setImageUrl(String)}
     *   <li>{@link ShoppingCartProductDto#setManufacturer(String)}
     *   <li>{@link ShoppingCartProductDto#setPrice(Integer)}
     *   <li>{@link ShoppingCartProductDto#setProductName(String)}
     *   <li>{@link ShoppingCartProductDto#setSku(String)}
     *   <li>{@link ShoppingCartProductDto#setTotal(Integer)}
     * </ul>
     */
    @Test
    public void testConstructor2() {
        ProductAvailability productAvailability = new ProductAvailability("Availability", "Color");

        ArrayList<ProductAttribute> attributeList = new ArrayList<>();
        ArrayList<ProductRatingDto> productRatingDtoList = new ArrayList<>();
        ShoppingCartProductDto actualShoppingCartProductDto = new ShoppingCartProductDto("Product Name",
                "https://example.org/example", "Sku", 1, "The characteristics of someone or something", "Manufacturer",
                productAvailability, attributeList, 1, true, productRatingDtoList, 1);
        ArrayList<ProductAttribute> productAttributeList = new ArrayList<>();
        actualShoppingCartProductDto.setAttributeList(productAttributeList);
        ProductAvailability productAvailability1 = new ProductAvailability("Availability", "Color");

        actualShoppingCartProductDto.setAvailability(productAvailability1);
        actualShoppingCartProductDto.setDescription("The characteristics of someone or something");
        actualShoppingCartProductDto.setFeatured(true);
        actualShoppingCartProductDto.setImageUrl("https://example.org/example");
        actualShoppingCartProductDto.setManufacturer("Manufacturer");
        actualShoppingCartProductDto.setPrice(1);
        actualShoppingCartProductDto.setProductName("Product Name");
        actualShoppingCartProductDto.setSku("Sku");
        actualShoppingCartProductDto.setTotal(1);
        assertEquals(1, actualShoppingCartProductDto.getAddtoCart().intValue());
        assertSame(productAttributeList, actualShoppingCartProductDto.getAttributeList());
        ProductAvailability availability = actualShoppingCartProductDto.getAvailability();
        assertSame(productAvailability1, availability);
        assertEquals(productAvailability, availability);
        assertEquals("The characteristics of someone or something", actualShoppingCartProductDto.getDescription());
        assertEquals("https://example.org/example", actualShoppingCartProductDto.getImageUrl());
        assertEquals("Manufacturer", actualShoppingCartProductDto.getManufacturer());
        assertEquals(1, actualShoppingCartProductDto.getPrice().intValue());
        assertEquals("Product Name", actualShoppingCartProductDto.getProductName());
        assertSame(productRatingDtoList, actualShoppingCartProductDto.getProductRatingDtoList());
        assertEquals("Sku", actualShoppingCartProductDto.getSku());
        assertEquals(1, actualShoppingCartProductDto.getTotal().intValue());
        assertTrue(actualShoppingCartProductDto.isFeatured());
    }

    /**
     * Method under test: {@link ShoppingCartProductDto#equals(Object)}
     */
    @Test
    public void testEquals() {
        assertNotEquals(new ShoppingCartProductDto(), null);
        assertNotEquals(new ShoppingCartProductDto(), "Different type to ShoppingCartProductDto");
    }

    /**
     * Method under test: {@link ShoppingCartProductDto#equals(Object)}
     */
    @Test
    public void testEquals2() {
        ShoppingCartProductDto shoppingCartProductDto = new ShoppingCartProductDto();
        assertEquals(shoppingCartProductDto, shoppingCartProductDto);
        int expectedHashCodeResult = shoppingCartProductDto.hashCode();
        assertEquals(expectedHashCodeResult, shoppingCartProductDto.hashCode());
    }

    /**
     * Method under test: {@link ShoppingCartProductDto#equals(Object)}
     */
    @Test
    public void testEquals3() {
        ShoppingCartProductDto shoppingCartProductDto = new ShoppingCartProductDto();
        ShoppingCartProductDto shoppingCartProductDto1 = new ShoppingCartProductDto();
        assertEquals(shoppingCartProductDto, shoppingCartProductDto1);
        int expectedHashCodeResult = shoppingCartProductDto.hashCode();
        assertEquals(expectedHashCodeResult, shoppingCartProductDto1.hashCode());
    }

    /**
     * Method under test: {@link ShoppingCartProductDto#equals(Object)}
     */
    @Test
    public void testEquals4() {
        ProductAvailability availability = new ProductAvailability("Availability", "Color");

        ArrayList<ProductAttribute> attributeList = new ArrayList<>();
        ShoppingCartProductDto shoppingCartProductDto = new ShoppingCartProductDto("Product Name",
                "https://example.org/example", "Sku", 1, "The characteristics of someone or something", "Manufacturer",
                availability, attributeList, 1, true, new ArrayList<>(), 1);
        assertNotEquals(shoppingCartProductDto, new ShoppingCartProductDto());
    }

    /**
     * Method under test: {@link ShoppingCartProductDto#equals(Object)}
     */
    @Test
    public void testEquals5() {
        ShoppingCartProductDto shoppingCartProductDto = new ShoppingCartProductDto();
        ProductAvailability availability = new ProductAvailability("Availability", "Color");

        ArrayList<ProductAttribute> attributeList = new ArrayList<>();
        assertNotEquals(shoppingCartProductDto,
                new ShoppingCartProductDto("Product Name", "https://example.org/example", "Sku", 1,
                        "The characteristics of someone or something", "Manufacturer", availability, attributeList, 1, true,
                        new ArrayList<>(), 1));
    }

    /**
     * Method under test: {@link ShoppingCartProductDto#equals(Object)}
     */
    @Test
    public void testEquals6() {
        ShoppingCartProductDto shoppingCartProductDto = new ShoppingCartProductDto();
        shoppingCartProductDto.setImageUrl("https://example.org/example");
        assertNotEquals(shoppingCartProductDto, new ShoppingCartProductDto());
    }

    /**
     * Method under test: {@link ShoppingCartProductDto#equals(Object)}
     */
    @Test
    public void testEquals7() {
        ShoppingCartProductDto shoppingCartProductDto = new ShoppingCartProductDto();
        shoppingCartProductDto.setSku("Sku");
        assertNotEquals(shoppingCartProductDto, new ShoppingCartProductDto());
    }

    /**
     * Method under test: {@link ShoppingCartProductDto#equals(Object)}
     */
    @Test
    public void testEquals8() {
        ShoppingCartProductDto shoppingCartProductDto = new ShoppingCartProductDto();
        shoppingCartProductDto.setPrice(1);
        assertNotEquals(shoppingCartProductDto, new ShoppingCartProductDto());
    }

    /**
     * Method under test: {@link ShoppingCartProductDto#equals(Object)}
     */
    @Test
    public void testEquals9() {
        ShoppingCartProductDto shoppingCartProductDto = new ShoppingCartProductDto();
        shoppingCartProductDto.setDescription("The characteristics of someone or something");
        assertNotEquals(shoppingCartProductDto, new ShoppingCartProductDto());
    }

    /**
     * Method under test: {@link ShoppingCartProductDto#equals(Object)}
     */
    @Test
    public void testEquals10() {
        ShoppingCartProductDto shoppingCartProductDto = new ShoppingCartProductDto();
        shoppingCartProductDto.setManufacturer("Manufacturer");
        assertNotEquals(shoppingCartProductDto, new ShoppingCartProductDto());
    }

    /**
     * Method under test: {@link ShoppingCartProductDto#equals(Object)}
     */
    @Test
    public void testEquals11() {
        ShoppingCartProductDto shoppingCartProductDto = new ShoppingCartProductDto();
        shoppingCartProductDto.setAvailability(new ProductAvailability("Availability", "Color"));
        assertNotEquals(shoppingCartProductDto, new ShoppingCartProductDto());
    }

    /**
     * Method under test: {@link ShoppingCartProductDto#equals(Object)}
     */
    @Test
    public void testEquals12() {
        ShoppingCartProductDto shoppingCartProductDto = new ShoppingCartProductDto();
        shoppingCartProductDto.setAttributeList(new ArrayList<>());
        assertNotEquals(shoppingCartProductDto, new ShoppingCartProductDto());
    }

    /**
     * Method under test: {@link ShoppingCartProductDto#equals(Object)}
     */
    @Test
    public void testEquals13() {
        ShoppingCartProductDto shoppingCartProductDto = new ShoppingCartProductDto();
        shoppingCartProductDto.setFeatured(true);
        assertNotEquals(shoppingCartProductDto, new ShoppingCartProductDto());
    }

    /**
     * Method under test: {@link ShoppingCartProductDto#equals(Object)}
     */
    @Test
    public void testEquals14() {
        ShoppingCartProductDto shoppingCartProductDto = new ShoppingCartProductDto();
        shoppingCartProductDto.setTotal(1);
        assertNotEquals(shoppingCartProductDto, new ShoppingCartProductDto());
    }

    /**
     * Method under test: {@link ShoppingCartProductDto#equals(Object)}
     */
    @Test
    public void testEquals15() {
        ProductAvailability availability = new ProductAvailability("Availability", "Color");

        ArrayList<ProductAttribute> attributeList = new ArrayList<>();
        ShoppingCartProductDto shoppingCartProductDto = new ShoppingCartProductDto("Product Name",
                "https://example.org/example", "Sku", 1, "The characteristics of someone or something", "Manufacturer",
                availability, attributeList, 1, true, new ArrayList<>(), 1);
        ProductAvailability availability1 = new ProductAvailability("Availability", "Color");

        ArrayList<ProductAttribute> attributeList1 = new ArrayList<>();
        ShoppingCartProductDto shoppingCartProductDto1 = new ShoppingCartProductDto("Product Name",
                "https://example.org/example", "Sku", 1, "The characteristics of someone or something", "Manufacturer",
                availability1, attributeList1, 1, true, new ArrayList<>(), 1);

        assertEquals(shoppingCartProductDto, shoppingCartProductDto1);
        int expectedHashCodeResult = shoppingCartProductDto.hashCode();
        assertEquals(expectedHashCodeResult, shoppingCartProductDto1.hashCode());
    }

    /**
     * Method under test: {@link ShoppingCartProductDto#equals(Object)}
     */
    @Test
    public void testEquals16() {
        ShoppingCartProductDto shoppingCartProductDto = new ShoppingCartProductDto();

        ShoppingCartProductDto shoppingCartProductDto1 = new ShoppingCartProductDto();
        shoppingCartProductDto1.setImageUrl("https://example.org/example");
        assertNotEquals(shoppingCartProductDto, shoppingCartProductDto1);
    }

    /**
     * Method under test: {@link ShoppingCartProductDto#equals(Object)}
     */
    @Test
    public void testEquals17() {
        ShoppingCartProductDto shoppingCartProductDto = new ShoppingCartProductDto();

        ShoppingCartProductDto shoppingCartProductDto1 = new ShoppingCartProductDto();
        shoppingCartProductDto1.setSku("Sku");
        assertNotEquals(shoppingCartProductDto, shoppingCartProductDto1);
    }

    /**
     * Method under test: {@link ShoppingCartProductDto#equals(Object)}
     */
    @Test
    public void testEquals18() {
        ShoppingCartProductDto shoppingCartProductDto = new ShoppingCartProductDto();

        ShoppingCartProductDto shoppingCartProductDto1 = new ShoppingCartProductDto();
        shoppingCartProductDto1.setPrice(1);
        assertNotEquals(shoppingCartProductDto, shoppingCartProductDto1);
    }

    /**
     * Method under test: {@link ShoppingCartProductDto#equals(Object)}
     */
    @Test
    public void testEquals19() {
        ShoppingCartProductDto shoppingCartProductDto = new ShoppingCartProductDto();

        ShoppingCartProductDto shoppingCartProductDto1 = new ShoppingCartProductDto();
        shoppingCartProductDto1.setDescription("The characteristics of someone or something");
        assertNotEquals(shoppingCartProductDto, shoppingCartProductDto1);
    }

    /**
     * Method under test: {@link ShoppingCartProductDto#equals(Object)}
     */
    @Test
    public void testEquals20() {
        ShoppingCartProductDto shoppingCartProductDto = new ShoppingCartProductDto();

        ShoppingCartProductDto shoppingCartProductDto1 = new ShoppingCartProductDto();
        shoppingCartProductDto1.setManufacturer("Manufacturer");
        assertNotEquals(shoppingCartProductDto, shoppingCartProductDto1);
    }

    /**
     * Method under test: {@link ShoppingCartProductDto#equals(Object)}
     */
    @Test
    public void testEquals21() {
        ShoppingCartProductDto shoppingCartProductDto = new ShoppingCartProductDto();

        ShoppingCartProductDto shoppingCartProductDto1 = new ShoppingCartProductDto();
        shoppingCartProductDto1.setAvailability(new ProductAvailability("Availability", "Color"));
        assertNotEquals(shoppingCartProductDto, shoppingCartProductDto1);
    }

    /**
     * Method under test: {@link ShoppingCartProductDto#equals(Object)}
     */
    @Test
    public void testEquals22() {
        ShoppingCartProductDto shoppingCartProductDto = new ShoppingCartProductDto();

        ShoppingCartProductDto shoppingCartProductDto1 = new ShoppingCartProductDto();
        shoppingCartProductDto1.setAttributeList(new ArrayList<>());
        assertNotEquals(shoppingCartProductDto, shoppingCartProductDto1);
    }

    /**
     * Method under test: {@link ShoppingCartProductDto#equals(Object)}
     */
    @Test
    public void testEquals23() {
        ShoppingCartProductDto shoppingCartProductDto = new ShoppingCartProductDto();

        ShoppingCartProductDto shoppingCartProductDto1 = new ShoppingCartProductDto();
        shoppingCartProductDto1.setTotal(1);
        assertNotEquals(shoppingCartProductDto, shoppingCartProductDto1);
    }

    /**
     * Method under test: {@link ShoppingCartProductDto#equals(Object)}
     */
    @Test
    public void testEquals24() {
        ProductAvailability availability = new ProductAvailability("Availability", "Color");

        ArrayList<ProductAttribute> attributeList = new ArrayList<>();
        ShoppingCartProductDto shoppingCartProductDto = new ShoppingCartProductDto("Product Name",
                "https://example.org/example", "Sku", 1, "The characteristics of someone or something", "Manufacturer",
                availability, attributeList, 3, true, new ArrayList<>(), 1);
        ProductAvailability availability1 = new ProductAvailability("Availability", "Color");

        ArrayList<ProductAttribute> attributeList1 = new ArrayList<>();
        assertNotEquals(shoppingCartProductDto,
                new ShoppingCartProductDto("Product Name", "https://example.org/example", "Sku", 1,
                        "The characteristics of someone or something", "Manufacturer", availability1, attributeList1, 1, true,
                        new ArrayList<>(), 1));
    }

    /**
     * Method under test: {@link ShoppingCartProductDto#equals(Object)}
     */
    @Test
    public void testEquals25() {
        ProductAvailability availability = new ProductAvailability("Availability", "Color");

        ArrayList<ProductAttribute> attributeList = new ArrayList<>();
        ShoppingCartProductDto shoppingCartProductDto = new ShoppingCartProductDto("Product Name",
                "https://example.org/example", "Sku", 1, "The characteristics of someone or something", "Manufacturer",
                availability, attributeList, null, true, new ArrayList<>(), 1);
        ProductAvailability availability1 = new ProductAvailability("Availability", "Color");

        ArrayList<ProductAttribute> attributeList1 = new ArrayList<>();
        assertNotEquals(shoppingCartProductDto,
                new ShoppingCartProductDto("Product Name", "https://example.org/example", "Sku", 1,
                        "The characteristics of someone or something", "Manufacturer", availability1, attributeList1, 1, true,
                        new ArrayList<>(), 1));
    }

    /**
     * Method under test: {@link ShoppingCartProductDto#equals(Object)}
     */
    @Test
    public void testEquals26() {
        ArrayList<ProductRatingDto> productRatingDtoList = new ArrayList<>();
        productRatingDtoList.add(new ProductRatingDto());
        ProductAvailability availability = new ProductAvailability("Availability", "Color");

        ShoppingCartProductDto shoppingCartProductDto = new ShoppingCartProductDto("Product Name",
                "https://example.org/example", "Sku", 1, "The characteristics of someone or something", "Manufacturer",
                availability, new ArrayList<>(), 1, true, productRatingDtoList, 1);
        ProductAvailability availability1 = new ProductAvailability("Availability", "Color");

        ArrayList<ProductAttribute> attributeList = new ArrayList<>();
        assertNotEquals(shoppingCartProductDto,
                new ShoppingCartProductDto("Product Name", "https://example.org/example", "Sku", 1,
                        "The characteristics of someone or something", "Manufacturer", availability1, attributeList, 1, true,
                        new ArrayList<>(), 1));
    }
}

