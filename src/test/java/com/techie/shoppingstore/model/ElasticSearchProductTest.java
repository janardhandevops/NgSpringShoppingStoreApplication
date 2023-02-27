package com.techie.shoppingstore.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.data.elasticsearch.core.completion.Completion;

public class ElasticSearchProductTest {
    /**
     * Method under test: {@link ElasticSearchProduct#canEqual(Object)}
     */
    @Test
    public void testCanEqual() {
        assertFalse((new ElasticSearchProduct()).canEqual("Other"));
    }

    /**
     * Method under test: {@link ElasticSearchProduct#canEqual(Object)}
     */
    @Test
    public void testCanEqual2() {
        ElasticSearchProduct elasticSearchProduct = new ElasticSearchProduct();
        assertTrue(elasticSearchProduct.canEqual(new ElasticSearchProduct()));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link ElasticSearchProduct#ElasticSearchProduct()}
     *   <li>{@link ElasticSearchProduct#setCategory(Category)}
     *   <li>{@link ElasticSearchProduct#setDescription(String)}
     *   <li>{@link ElasticSearchProduct#setFeatured(boolean)}
     *   <li>{@link ElasticSearchProduct#setId(String)}
     *   <li>{@link ElasticSearchProduct#setImageUrl(String)}
     *   <li>{@link ElasticSearchProduct#setManufacturer(String)}
     *   <li>{@link ElasticSearchProduct#setName(String)}
     *   <li>{@link ElasticSearchProduct#setPrice(Integer)}
     *   <li>{@link ElasticSearchProduct#setProductAttributeList(List)}
     *   <li>{@link ElasticSearchProduct#setProductRating(List)}
     *   <li>{@link ElasticSearchProduct#setQuantity(Integer)}
     *   <li>{@link ElasticSearchProduct#setSku(String)}
     *   <li>{@link ElasticSearchProduct#setSuggestions(Completion)}
     * </ul>
     */
    @Test
    public void testConstructor() {
        ElasticSearchProduct actualElasticSearchProduct = new ElasticSearchProduct();
        Category category = new Category();
        category.setId(123L);
        category.setName("Name");
        category.setPossibleFacets(new ArrayList<>());
        actualElasticSearchProduct.setCategory(category);
        actualElasticSearchProduct.setDescription("The characteristics of someone or something");
        actualElasticSearchProduct.setFeatured(true);
        actualElasticSearchProduct.setId("42");
        actualElasticSearchProduct.setImageUrl("https://example.org/example");
        actualElasticSearchProduct.setManufacturer("Manufacturer");
        actualElasticSearchProduct.setName("Name");
        actualElasticSearchProduct.setPrice(1);
        ArrayList<ProductAttribute> productAttributeList = new ArrayList<>();
        actualElasticSearchProduct.setProductAttributeList(productAttributeList);
        ArrayList<ProductRating> productRatingList = new ArrayList<>();
        actualElasticSearchProduct.setProductRating(productRatingList);
        actualElasticSearchProduct.setQuantity(1);
        actualElasticSearchProduct.setSku("Sku");
        Completion completion = new Completion(new String[]{"Input"});
        actualElasticSearchProduct.setSuggestions(completion);
        assertSame(category, actualElasticSearchProduct.getCategory());
        assertEquals("The characteristics of someone or something", actualElasticSearchProduct.getDescription());
        assertEquals("42", actualElasticSearchProduct.getId());
        assertEquals("https://example.org/example", actualElasticSearchProduct.getImageUrl());
        assertEquals("Manufacturer", actualElasticSearchProduct.getManufacturer());
        assertEquals("Name", actualElasticSearchProduct.getName());
        assertEquals(1, actualElasticSearchProduct.getPrice().intValue());
        assertSame(productAttributeList, actualElasticSearchProduct.getProductAttributeList());
        assertSame(productRatingList, actualElasticSearchProduct.getProductRating());
        assertEquals(1, actualElasticSearchProduct.getQuantity().intValue());
        assertEquals("Sku", actualElasticSearchProduct.getSku());
        assertSame(completion, actualElasticSearchProduct.getSuggestions());
        assertTrue(actualElasticSearchProduct.isFeatured());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link ElasticSearchProduct#ElasticSearchProduct(String, String, String, Integer, String, String, Category, List, Integer, String, boolean, Completion, List)}
     *   <li>{@link ElasticSearchProduct#setCategory(Category)}
     *   <li>{@link ElasticSearchProduct#setDescription(String)}
     *   <li>{@link ElasticSearchProduct#setFeatured(boolean)}
     *   <li>{@link ElasticSearchProduct#setId(String)}
     *   <li>{@link ElasticSearchProduct#setImageUrl(String)}
     *   <li>{@link ElasticSearchProduct#setManufacturer(String)}
     *   <li>{@link ElasticSearchProduct#setName(String)}
     *   <li>{@link ElasticSearchProduct#setPrice(Integer)}
     *   <li>{@link ElasticSearchProduct#setProductAttributeList(List)}
     *   <li>{@link ElasticSearchProduct#setProductRating(List)}
     *   <li>{@link ElasticSearchProduct#setQuantity(Integer)}
     *   <li>{@link ElasticSearchProduct#setSku(String)}
     *   <li>{@link ElasticSearchProduct#setSuggestions(Completion)}
     * </ul>
     */
    @Test
    public void testConstructor2() {
        Category category = new Category();
        category.setId(123L);
        category.setName("Name");
        category.setPossibleFacets(new ArrayList<>());
        ArrayList<ProductAttribute> productAttributeList = new ArrayList<>();
        Completion suggestions = new Completion(new String[]{"Input"});
        ElasticSearchProduct actualElasticSearchProduct = new ElasticSearchProduct("42", "Name",
                "The characteristics of someone or something", 1, "Sku", "https://example.org/example", category,
                productAttributeList, 1, "Manufacturer", true, suggestions, new ArrayList<>());
        Category category1 = new Category();
        category1.setId(123L);
        category1.setName("Name");
        category1.setPossibleFacets(new ArrayList<>());
        actualElasticSearchProduct.setCategory(category1);
        actualElasticSearchProduct.setDescription("The characteristics of someone or something");
        actualElasticSearchProduct.setFeatured(true);
        actualElasticSearchProduct.setId("42");
        actualElasticSearchProduct.setImageUrl("https://example.org/example");
        actualElasticSearchProduct.setManufacturer("Manufacturer");
        actualElasticSearchProduct.setName("Name");
        actualElasticSearchProduct.setPrice(1);
        ArrayList<ProductAttribute> productAttributeList1 = new ArrayList<>();
        actualElasticSearchProduct.setProductAttributeList(productAttributeList1);
        ArrayList<ProductRating> productRatingList = new ArrayList<>();
        actualElasticSearchProduct.setProductRating(productRatingList);
        actualElasticSearchProduct.setQuantity(1);
        actualElasticSearchProduct.setSku("Sku");
        Completion completion = new Completion(new String[]{"Input"});
        actualElasticSearchProduct.setSuggestions(completion);
        Category category2 = actualElasticSearchProduct.getCategory();
        assertSame(category1, category2);
        assertEquals(category, category2);
        assertEquals("The characteristics of someone or something", actualElasticSearchProduct.getDescription());
        assertEquals("42", actualElasticSearchProduct.getId());
        assertEquals("https://example.org/example", actualElasticSearchProduct.getImageUrl());
        assertEquals("Manufacturer", actualElasticSearchProduct.getManufacturer());
        assertEquals("Name", actualElasticSearchProduct.getName());
        assertEquals(1, actualElasticSearchProduct.getPrice().intValue());
        assertSame(productAttributeList1, actualElasticSearchProduct.getProductAttributeList());
        assertSame(productRatingList, actualElasticSearchProduct.getProductRating());
        assertEquals(1, actualElasticSearchProduct.getQuantity().intValue());
        assertEquals("Sku", actualElasticSearchProduct.getSku());
        assertSame(completion, actualElasticSearchProduct.getSuggestions());
        assertTrue(actualElasticSearchProduct.isFeatured());
    }

    /**
     * Method under test: {@link ElasticSearchProduct#equals(Object)}
     */
    @Test
    public void testEquals() {
        assertNotEquals(new ElasticSearchProduct(), null);
        assertNotEquals(new ElasticSearchProduct(), "Different type to ElasticSearchProduct");
    }

    /**
     * Method under test: {@link ElasticSearchProduct#equals(Object)}
     */
    @Test
    public void testEquals2() {
        ElasticSearchProduct elasticSearchProduct = new ElasticSearchProduct();
        assertEquals(elasticSearchProduct, elasticSearchProduct);
        int expectedHashCodeResult = elasticSearchProduct.hashCode();
        assertEquals(expectedHashCodeResult, elasticSearchProduct.hashCode());
    }

    /**
     * Method under test: {@link ElasticSearchProduct#equals(Object)}
     */
    @Test
    public void testEquals3() {
        ElasticSearchProduct elasticSearchProduct = new ElasticSearchProduct();
        ElasticSearchProduct elasticSearchProduct1 = new ElasticSearchProduct();
        assertEquals(elasticSearchProduct, elasticSearchProduct1);
        int expectedHashCodeResult = elasticSearchProduct.hashCode();
        assertEquals(expectedHashCodeResult, elasticSearchProduct1.hashCode());
    }

    /**
     * Method under test: {@link ElasticSearchProduct#equals(Object)}
     */
    @Test
    public void testEquals4() {
        Category category = new Category();
        ArrayList<ProductAttribute> productAttributeList = new ArrayList<>();
        Completion suggestions = new Completion(new String[]{"Input"});
        ElasticSearchProduct elasticSearchProduct = new ElasticSearchProduct("42", "Name",
                "The characteristics of someone or something", 1, "Sku", "https://example.org/example", category,
                productAttributeList, 1, "Manufacturer", true, suggestions, new ArrayList<>());
        assertNotEquals(elasticSearchProduct, new ElasticSearchProduct());
    }

    /**
     * Method under test: {@link ElasticSearchProduct#equals(Object)}
     */
    @Test
    public void testEquals5() {
        ElasticSearchProduct elasticSearchProduct = new ElasticSearchProduct();
        Category category = new Category();
        ArrayList<ProductAttribute> productAttributeList = new ArrayList<>();
        Completion suggestions = new Completion(new String[]{"Input"});
        assertNotEquals(elasticSearchProduct,
                new ElasticSearchProduct("42", "Name", "The characteristics of someone or something", 1, "Sku",
                        "https://example.org/example", category, productAttributeList, 1, "Manufacturer", true, suggestions,
                        new ArrayList<>()));
    }

    /**
     * Method under test: {@link ElasticSearchProduct#equals(Object)}
     */
    @Test
    public void testEquals6() {
        ElasticSearchProduct elasticSearchProduct = new ElasticSearchProduct();
        elasticSearchProduct.setName("Name");
        assertNotEquals(elasticSearchProduct, new ElasticSearchProduct());
    }

    /**
     * Method under test: {@link ElasticSearchProduct#equals(Object)}
     */
    @Test
    public void testEquals7() {
        ElasticSearchProduct elasticSearchProduct = new ElasticSearchProduct();
        elasticSearchProduct.setDescription("The characteristics of someone or something");
        assertNotEquals(elasticSearchProduct, new ElasticSearchProduct());
    }

    /**
     * Method under test: {@link ElasticSearchProduct#equals(Object)}
     */
    @Test
    public void testEquals8() {
        ElasticSearchProduct elasticSearchProduct = new ElasticSearchProduct();
        elasticSearchProduct.setPrice(1);
        assertNotEquals(elasticSearchProduct, new ElasticSearchProduct());
    }

    /**
     * Method under test: {@link ElasticSearchProduct#equals(Object)}
     */
    @Test
    public void testEquals9() {
        ElasticSearchProduct elasticSearchProduct = new ElasticSearchProduct();
        elasticSearchProduct.setSku("Sku");
        assertNotEquals(elasticSearchProduct, new ElasticSearchProduct());
    }

    /**
     * Method under test: {@link ElasticSearchProduct#equals(Object)}
     */
    @Test
    public void testEquals10() {
        ElasticSearchProduct elasticSearchProduct = new ElasticSearchProduct();
        elasticSearchProduct.setImageUrl("https://example.org/example");
        assertNotEquals(elasticSearchProduct, new ElasticSearchProduct());
    }

    /**
     * Method under test: {@link ElasticSearchProduct#equals(Object)}
     */
    @Test
    public void testEquals11() {
        Category category = new Category();
        category.setId(123L);
        category.setName("Name");
        category.setPossibleFacets(new ArrayList<>());

        ElasticSearchProduct elasticSearchProduct = new ElasticSearchProduct();
        elasticSearchProduct.setCategory(category);
        assertNotEquals(elasticSearchProduct, new ElasticSearchProduct());
    }

    /**
     * Method under test: {@link ElasticSearchProduct#equals(Object)}
     */
    @Test
    public void testEquals12() {
        ElasticSearchProduct elasticSearchProduct = new ElasticSearchProduct();
        elasticSearchProduct.setProductAttributeList(new ArrayList<>());
        assertNotEquals(elasticSearchProduct, new ElasticSearchProduct());
    }

    /**
     * Method under test: {@link ElasticSearchProduct#equals(Object)}
     */
    @Test
    public void testEquals13() {
        ElasticSearchProduct elasticSearchProduct = new ElasticSearchProduct();
        elasticSearchProduct.setQuantity(1);
        assertNotEquals(elasticSearchProduct, new ElasticSearchProduct());
    }

    /**
     * Method under test: {@link ElasticSearchProduct#equals(Object)}
     */
    @Test
    public void testEquals14() {
        ElasticSearchProduct elasticSearchProduct = new ElasticSearchProduct();
        elasticSearchProduct.setManufacturer("Manufacturer");
        assertNotEquals(elasticSearchProduct, new ElasticSearchProduct());
    }

    /**
     * Method under test: {@link ElasticSearchProduct#equals(Object)}
     */
    @Test
    public void testEquals15() {
        ElasticSearchProduct elasticSearchProduct = new ElasticSearchProduct();
        elasticSearchProduct.setFeatured(true);
        assertNotEquals(elasticSearchProduct, new ElasticSearchProduct());
    }

    /**
     * Method under test: {@link ElasticSearchProduct#equals(Object)}
     */
    @Test
    public void testEquals16() {
        ElasticSearchProduct elasticSearchProduct = new ElasticSearchProduct();
        elasticSearchProduct.setSuggestions(new Completion(new String[]{"Input"}));
        assertNotEquals(elasticSearchProduct, new ElasticSearchProduct());
    }

    /**
     * Method under test: {@link ElasticSearchProduct#equals(Object)}
     */
    @Test
    public void testEquals17() {
        ElasticSearchProduct elasticSearchProduct = new ElasticSearchProduct();
        elasticSearchProduct.setProductRating(new ArrayList<>());
        assertNotEquals(elasticSearchProduct, new ElasticSearchProduct());
    }

    /**
     * Method under test: {@link ElasticSearchProduct#equals(Object)}
     */
    @Test
    public void testEquals18() {
        Category category = new Category();
        ArrayList<ProductAttribute> productAttributeList = new ArrayList<>();
        Completion suggestions = new Completion(new String[]{"Input"});
        ElasticSearchProduct elasticSearchProduct = new ElasticSearchProduct("42", "Name",
                "The characteristics of someone or something", 1, "Sku", "https://example.org/example", category,
                productAttributeList, 1, "Manufacturer", true, suggestions, new ArrayList<>());
        Category category1 = new Category();
        ArrayList<ProductAttribute> productAttributeList1 = new ArrayList<>();
        Completion suggestions1 = new Completion(new String[]{"Input"});
        assertNotEquals(elasticSearchProduct,
                new ElasticSearchProduct("42", "Name", "The characteristics of someone or something", 1, "Sku",
                        "https://example.org/example", category1, productAttributeList1, 1, "Manufacturer", true, suggestions1,
                        new ArrayList<>()));
    }

    /**
     * Method under test: {@link ElasticSearchProduct#equals(Object)}
     */
    @Test
    public void testEquals19() {
        ElasticSearchProduct elasticSearchProduct = new ElasticSearchProduct();

        ElasticSearchProduct elasticSearchProduct1 = new ElasticSearchProduct();
        elasticSearchProduct1.setName("Name");
        assertNotEquals(elasticSearchProduct, elasticSearchProduct1);
    }

    /**
     * Method under test: {@link ElasticSearchProduct#equals(Object)}
     */
    @Test
    public void testEquals20() {
        ElasticSearchProduct elasticSearchProduct = new ElasticSearchProduct();

        ElasticSearchProduct elasticSearchProduct1 = new ElasticSearchProduct();
        elasticSearchProduct1.setDescription("The characteristics of someone or something");
        assertNotEquals(elasticSearchProduct, elasticSearchProduct1);
    }

    /**
     * Method under test: {@link ElasticSearchProduct#equals(Object)}
     */
    @Test
    public void testEquals21() {
        ElasticSearchProduct elasticSearchProduct = new ElasticSearchProduct();

        ElasticSearchProduct elasticSearchProduct1 = new ElasticSearchProduct();
        elasticSearchProduct1.setPrice(1);
        assertNotEquals(elasticSearchProduct, elasticSearchProduct1);
    }

    /**
     * Method under test: {@link ElasticSearchProduct#equals(Object)}
     */
    @Test
    public void testEquals22() {
        ElasticSearchProduct elasticSearchProduct = new ElasticSearchProduct();

        ElasticSearchProduct elasticSearchProduct1 = new ElasticSearchProduct();
        elasticSearchProduct1.setSku("Sku");
        assertNotEquals(elasticSearchProduct, elasticSearchProduct1);
    }

    /**
     * Method under test: {@link ElasticSearchProduct#equals(Object)}
     */
    @Test
    public void testEquals23() {
        ElasticSearchProduct elasticSearchProduct = new ElasticSearchProduct();

        ElasticSearchProduct elasticSearchProduct1 = new ElasticSearchProduct();
        elasticSearchProduct1.setImageUrl("https://example.org/example");
        assertNotEquals(elasticSearchProduct, elasticSearchProduct1);
    }

    /**
     * Method under test: {@link ElasticSearchProduct#equals(Object)}
     */
    @Test
    public void testEquals24() {
        ElasticSearchProduct elasticSearchProduct = new ElasticSearchProduct();

        Category category = new Category();
        category.setId(123L);
        category.setName("Name");
        category.setPossibleFacets(new ArrayList<>());

        ElasticSearchProduct elasticSearchProduct1 = new ElasticSearchProduct();
        elasticSearchProduct1.setCategory(category);
        assertNotEquals(elasticSearchProduct, elasticSearchProduct1);
    }

    /**
     * Method under test: {@link ElasticSearchProduct#equals(Object)}
     */
    @Test
    public void testEquals25() {
        ElasticSearchProduct elasticSearchProduct = new ElasticSearchProduct();

        ElasticSearchProduct elasticSearchProduct1 = new ElasticSearchProduct();
        elasticSearchProduct1.setProductAttributeList(new ArrayList<>());
        assertNotEquals(elasticSearchProduct, elasticSearchProduct1);
    }

    /**
     * Method under test: {@link ElasticSearchProduct#equals(Object)}
     */
    @Test
    public void testEquals26() {
        ElasticSearchProduct elasticSearchProduct = new ElasticSearchProduct();

        ElasticSearchProduct elasticSearchProduct1 = new ElasticSearchProduct();
        elasticSearchProduct1.setQuantity(1);
        assertNotEquals(elasticSearchProduct, elasticSearchProduct1);
    }

    /**
     * Method under test: {@link ElasticSearchProduct#equals(Object)}
     */
    @Test
    public void testEquals27() {
        ElasticSearchProduct elasticSearchProduct = new ElasticSearchProduct();

        ElasticSearchProduct elasticSearchProduct1 = new ElasticSearchProduct();
        elasticSearchProduct1.setManufacturer("Manufacturer");
        assertNotEquals(elasticSearchProduct, elasticSearchProduct1);
    }

    /**
     * Method under test: {@link ElasticSearchProduct#equals(Object)}
     */
    @Test
    public void testEquals28() {
        ElasticSearchProduct elasticSearchProduct = new ElasticSearchProduct();

        ElasticSearchProduct elasticSearchProduct1 = new ElasticSearchProduct();
        elasticSearchProduct1.setSuggestions(new Completion(new String[]{"Input"}));
        assertNotEquals(elasticSearchProduct, elasticSearchProduct1);
    }

    /**
     * Method under test: {@link ElasticSearchProduct#equals(Object)}
     */
    @Test
    public void testEquals29() {
        ElasticSearchProduct elasticSearchProduct = new ElasticSearchProduct();

        ElasticSearchProduct elasticSearchProduct1 = new ElasticSearchProduct();
        elasticSearchProduct1.setProductRating(new ArrayList<>());
        assertNotEquals(elasticSearchProduct, elasticSearchProduct1);
    }
}

