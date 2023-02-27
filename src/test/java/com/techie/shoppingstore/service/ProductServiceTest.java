package com.techie.shoppingstore.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.techie.shoppingstore.dto.ProductAvailability;
import com.techie.shoppingstore.dto.ProductDto;
import com.techie.shoppingstore.dto.ProductRatingDto;
import com.techie.shoppingstore.exceptions.SpringStoreException;
import com.techie.shoppingstore.model.Category;
import com.techie.shoppingstore.model.ElasticSearchProduct;
import com.techie.shoppingstore.model.Product;
import com.techie.shoppingstore.model.ProductAttribute;
import com.techie.shoppingstore.model.ProductRating;
import com.techie.shoppingstore.repository.CategoryRepository;
import com.techie.shoppingstore.repository.ProductRepository;
import com.techie.shoppingstore.repository.ProductSearchRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Ignore;

import org.junit.Rule;

import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.redis.core.RedisKeyValueAdapter;
import org.springframework.data.redis.core.RedisKeyValueTemplate;
import org.springframework.data.redis.core.mapping.RedisMappingContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {ProductService.class, RedisKeyValueTemplate.class, RedisKeyValueAdapter.class,
        RedisMappingContext.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class ProductServiceTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @MockBean
    private CategoryRepository categoryRepository;

    @MockBean
    private ProductMapper productMapper;

    @MockBean
    private ProductRepository productRepository;

    @MockBean
    private ProductSearchRepository productSearchRepository;

    @Autowired
    private ProductService productService;

    /**
     * Method under test: {@link ProductService#findAll()}
     */
    @Test
    public void testFindAll() {
        when(this.productRepository.findAll()).thenReturn(new ArrayList<>());
        assertTrue(this.productService.findAll().isEmpty());
        verify(this.productRepository).findAll();
    }

    /**
     * Method under test: {@link ProductService#findAll()}
     */
    @Test
    public void testFindAll2() {
        Category category = new Category();
        category.setId(123L);
        category.setName("XAss");
        category.setPossibleFacets(new ArrayList<>());

        Product product = new Product();
        product.setCategory(category);
        product.setCategoryId(123L);
        product.setDescription("The characteristics of someone or something");
        product.setFeatured(true);
        product.setId("42");
        product.setImageUrl("https://example.org/example");
        product.setManufacturer("XAss");
        product.setName("XAss");
        product.setPrice(4);
        product.setProductAttributeList(new ArrayList<>());
        product.setProductRating(new ArrayList<>());
        product.setQuantity(4);
        product.setSku("XAss");
        product.setStock(4);

        ArrayList<Product> productList = new ArrayList<>();
        productList.add(product);
        when(this.productRepository.findAll()).thenReturn(productList);
        assertEquals(1, this.productService.findAll().size());
        verify(this.productRepository).findAll();
    }

    /**
     * Method under test: {@link ProductService#findAll()}
     */
    @Test
    public void testFindAll3() {
        when(this.productRepository.findAll()).thenThrow(new SpringStoreException("An error occurred"));
        thrown.expect(SpringStoreException.class);
        this.productService.findAll();
        verify(this.productRepository).findAll();
    }

    /**
     * Method under test: {@link ProductService#findAll()}
     */
    @Test
    public void testFindAll4() {
        Category category = new Category();
        category.setId(123L);
        category.setName("XAss");
        category.setPossibleFacets(new ArrayList<>());

        Product product = new Product();
        product.setCategory(category);
        product.setCategoryId(123L);
        product.setDescription("The characteristics of someone or something");
        product.setFeatured(true);
        product.setId("42");
        product.setImageUrl("https://example.org/example");
        product.setManufacturer("XAss");
        product.setName("XAss");
        product.setPrice(4);
        product.setProductAttributeList(new ArrayList<>());
        product.setProductRating(new ArrayList<>());
        product.setQuantity(4);
        product.setSku("XAss");
        product.setStock(4);

        Category category1 = new Category();
        category1.setId(123L);
        category1.setName("XAss");
        category1.setPossibleFacets(new ArrayList<>());

        Product product1 = new Product();
        product1.setCategory(category1);
        product1.setCategoryId(123L);
        product1.setDescription("The characteristics of someone or something");
        product1.setFeatured(true);
        product1.setId("42");
        product1.setImageUrl("https://example.org/example");
        product1.setManufacturer("XAss");
        product1.setName("XAss");
        product1.setPrice(4);
        product1.setProductAttributeList(new ArrayList<>());
        product1.setProductRating(new ArrayList<>());
        product1.setQuantity(4);
        product1.setSku("XAss");
        product1.setStock(4);

        ArrayList<Product> productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product);
        when(this.productRepository.findAll()).thenReturn(productList);
        assertEquals(2, this.productService.findAll().size());
        verify(this.productRepository).findAll();
    }

    /**
     * Method under test: {@link ProductService#findAll()}
     */
    @Test
    public void testFindAll5() {
        Category category = new Category();
        category.setId(123L);
        category.setName("XAss");
        category.setPossibleFacets(new ArrayList<>());
        Product product = mock(Product.class);
        when(product.isFeatured()).thenReturn(true);
        when(product.getPrice()).thenReturn(1);
        when(product.getQuantity()).thenReturn(0);
        when(product.getDescription()).thenReturn("The characteristics of someone or something");
        when(product.getImageUrl()).thenReturn("https://example.org/example");
        when(product.getManufacturer()).thenReturn("Manufacturer");
        when(product.getName()).thenReturn("Name");
        when(product.getSku()).thenReturn("Sku");
        when(product.getProductAttributeList()).thenReturn(new ArrayList<>());
        when(product.getProductRating()).thenReturn(new ArrayList<>());
        doNothing().when(product).setCategory((Category) any());
        doNothing().when(product).setCategoryId((Long) any());
        doNothing().when(product).setDescription((String) any());
        doNothing().when(product).setFeatured(anyBoolean());
        doNothing().when(product).setId((String) any());
        doNothing().when(product).setImageUrl((String) any());
        doNothing().when(product).setManufacturer((String) any());
        doNothing().when(product).setName((String) any());
        doNothing().when(product).setPrice((Integer) any());
        doNothing().when(product).setProductAttributeList((List<ProductAttribute>) any());
        doNothing().when(product).setProductRating((List<ProductRating>) any());
        doNothing().when(product).setQuantity((Integer) any());
        doNothing().when(product).setSku((String) any());
        doNothing().when(product).setStock((Integer) any());
        product.setCategory(category);
        product.setCategoryId(123L);
        product.setDescription("The characteristics of someone or something");
        product.setFeatured(true);
        product.setId("42");
        product.setImageUrl("https://example.org/example");
        product.setManufacturer("XAss");
        product.setName("XAss");
        product.setPrice(4);
        product.setProductAttributeList(new ArrayList<>());
        product.setProductRating(new ArrayList<>());
        product.setQuantity(4);
        product.setSku("XAss");
        product.setStock(4);

        ArrayList<Product> productList = new ArrayList<>();
        productList.add(product);
        when(this.productRepository.findAll()).thenReturn(productList);
        assertEquals(1, this.productService.findAll().size());
        verify(this.productRepository).findAll();
        verify(product).isFeatured();
        verify(product).getPrice();
        verify(product, atLeast(1)).getQuantity();
        verify(product).getDescription();
        verify(product).getImageUrl();
        verify(product).getManufacturer();
        verify(product).getName();
        verify(product).getSku();
        verify(product).getProductAttributeList();
        verify(product, atLeast(1)).getProductRating();
        verify(product).setCategory((Category) any());
        verify(product).setCategoryId((Long) any());
        verify(product).setDescription((String) any());
        verify(product).setFeatured(anyBoolean());
        verify(product).setId((String) any());
        verify(product).setImageUrl((String) any());
        verify(product).setManufacturer((String) any());
        verify(product).setName((String) any());
        verify(product).setPrice((Integer) any());
        verify(product).setProductAttributeList((List<ProductAttribute>) any());
        verify(product).setProductRating((List<ProductRating>) any());
        verify(product).setQuantity((Integer) any());
        verify(product).setSku((String) any());
        verify(product).setStock((Integer) any());
    }

    /**
     * Method under test: {@link ProductService#readOneProduct(String)}
     */
    @Test
    public void testReadOneProduct() {
        Category category = new Category();
        category.setId(123L);
        category.setName("Name");
        category.setPossibleFacets(new ArrayList<>());

        Product product = new Product();
        product.setCategory(category);
        product.setCategoryId(123L);
        product.setDescription("The characteristics of someone or something");
        product.setFeatured(true);
        product.setId("42");
        product.setImageUrl("https://example.org/example");
        product.setManufacturer("Manufacturer");
        product.setName("Name");
        product.setPrice(1);
        product.setProductAttributeList(new ArrayList<>());
        product.setProductRating(new ArrayList<>());
        product.setQuantity(1);
        product.setSku("Sku");
        product.setStock(1);
        Optional<Product> ofResult = Optional.of(product);
        when(this.productRepository.findBySku((String) any())).thenReturn(ofResult);
        ProductDto actualReadOneProductResult = this.productService.readOneProduct("Sku");
        assertTrue(actualReadOneProductResult.getAttributeList().isEmpty());
        assertTrue(actualReadOneProductResult.isFeatured());
        assertEquals("Sku", actualReadOneProductResult.getSku());
        assertEquals(1, actualReadOneProductResult.getQuantity().intValue());
        assertTrue(actualReadOneProductResult.getProductRatingDtoList().isEmpty());
        assertEquals("Name", actualReadOneProductResult.getProductName());
        assertEquals(1, actualReadOneProductResult.getPrice().intValue());
        assertEquals("Manufacturer", actualReadOneProductResult.getManufacturer());
        assertEquals("https://example.org/example", actualReadOneProductResult.getImageUrl());
        assertEquals("The characteristics of someone or something", actualReadOneProductResult.getDescription());
        ProductAvailability availability = actualReadOneProductResult.getAvailability();
        assertEquals("Out of Stock", availability.getAvailability());
        assertEquals("forestgreen", availability.getColor());
        verify(this.productRepository).findBySku((String) any());
    }

    /**
     * Method under test: {@link ProductService#readOneProduct(String)}
     */
    @Test
    public void testReadOneProduct2() {
        Category category = new Category();
        category.setId(123L);
        category.setName("Name");
        category.setPossibleFacets(new ArrayList<>());
        Product product = mock(Product.class);
        when(product.isFeatured()).thenReturn(true);
        when(product.getPrice()).thenReturn(1);
        when(product.getQuantity()).thenReturn(0);
        when(product.getDescription()).thenReturn("The characteristics of someone or something");
        when(product.getImageUrl()).thenReturn("https://example.org/example");
        when(product.getManufacturer()).thenReturn("Manufacturer");
        when(product.getName()).thenReturn("Name");
        when(product.getSku()).thenReturn("Sku");
        when(product.getProductAttributeList()).thenReturn(new ArrayList<>());
        when(product.getProductRating()).thenReturn(new ArrayList<>());
        doNothing().when(product).setCategory((Category) any());
        doNothing().when(product).setCategoryId((Long) any());
        doNothing().when(product).setDescription((String) any());
        doNothing().when(product).setFeatured(anyBoolean());
        doNothing().when(product).setId((String) any());
        doNothing().when(product).setImageUrl((String) any());
        doNothing().when(product).setManufacturer((String) any());
        doNothing().when(product).setName((String) any());
        doNothing().when(product).setPrice((Integer) any());
        doNothing().when(product).setProductAttributeList((List<ProductAttribute>) any());
        doNothing().when(product).setProductRating((List<ProductRating>) any());
        doNothing().when(product).setQuantity((Integer) any());
        doNothing().when(product).setSku((String) any());
        doNothing().when(product).setStock((Integer) any());
        product.setCategory(category);
        product.setCategoryId(123L);
        product.setDescription("The characteristics of someone or something");
        product.setFeatured(true);
        product.setId("42");
        product.setImageUrl("https://example.org/example");
        product.setManufacturer("Manufacturer");
        product.setName("Name");
        product.setPrice(1);
        product.setProductAttributeList(new ArrayList<>());
        product.setProductRating(new ArrayList<>());
        product.setQuantity(1);
        product.setSku("Sku");
        product.setStock(1);
        Optional<Product> ofResult = Optional.of(product);
        when(this.productRepository.findBySku((String) any())).thenReturn(ofResult);
        ProductDto actualReadOneProductResult = this.productService.readOneProduct("Sku");
        assertTrue(actualReadOneProductResult.getAttributeList().isEmpty());
        assertTrue(actualReadOneProductResult.isFeatured());
        assertEquals("Sku", actualReadOneProductResult.getSku());
        assertEquals(0, actualReadOneProductResult.getQuantity().intValue());
        assertTrue(actualReadOneProductResult.getProductRatingDtoList().isEmpty());
        assertEquals("Name", actualReadOneProductResult.getProductName());
        assertEquals(1, actualReadOneProductResult.getPrice().intValue());
        assertEquals("Manufacturer", actualReadOneProductResult.getManufacturer());
        assertEquals("https://example.org/example", actualReadOneProductResult.getImageUrl());
        assertEquals("The characteristics of someone or something", actualReadOneProductResult.getDescription());
        ProductAvailability availability = actualReadOneProductResult.getAvailability();
        assertEquals("Out of Stock", availability.getAvailability());
        assertEquals("red", availability.getColor());
        verify(this.productRepository).findBySku((String) any());
        verify(product).isFeatured();
        verify(product).getPrice();
        verify(product, atLeast(1)).getQuantity();
        verify(product).getDescription();
        verify(product).getImageUrl();
        verify(product).getManufacturer();
        verify(product).getName();
        verify(product).getSku();
        verify(product).getProductAttributeList();
        verify(product, atLeast(1)).getProductRating();
        verify(product).setCategory((Category) any());
        verify(product).setCategoryId((Long) any());
        verify(product).setDescription((String) any());
        verify(product).setFeatured(anyBoolean());
        verify(product).setId((String) any());
        verify(product).setImageUrl((String) any());
        verify(product).setManufacturer((String) any());
        verify(product).setName((String) any());
        verify(product).setPrice((Integer) any());
        verify(product).setProductAttributeList((List<ProductAttribute>) any());
        verify(product).setProductRating((List<ProductRating>) any());
        verify(product).setQuantity((Integer) any());
        verify(product).setSku((String) any());
        verify(product).setStock((Integer) any());
    }

    /**
     * Method under test: {@link ProductService#readOneProduct(String)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testReadOneProduct3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException
        //       at java.util.Optional.orElseThrow(Optional.java:290)
        //       at com.techie.shoppingstore.service.ProductService.readOneProduct(ProductService.java:78)
        //   In order to prevent readOneProduct(String)
        //   from throwing IllegalArgumentException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   readOneProduct(String).
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.productRepository.findBySku((String) any())).thenReturn(Optional.empty());

        Category category = new Category();
        category.setId(123L);
        category.setName("Name");
        category.setPossibleFacets(new ArrayList<>());
        Product product = mock(Product.class);
        when(product.isFeatured()).thenReturn(true);
        when(product.getPrice()).thenReturn(1);
        when(product.getQuantity()).thenReturn(1);
        when(product.getDescription()).thenReturn("The characteristics of someone or something");
        when(product.getImageUrl()).thenReturn("https://example.org/example");
        when(product.getManufacturer()).thenReturn("Manufacturer");
        when(product.getName()).thenReturn("Name");
        when(product.getSku()).thenReturn("Sku");
        when(product.getProductAttributeList()).thenReturn(new ArrayList<>());
        when(product.getProductRating()).thenReturn(new ArrayList<>());
        doNothing().when(product).setCategory((Category) any());
        doNothing().when(product).setCategoryId((Long) any());
        doNothing().when(product).setDescription((String) any());
        doNothing().when(product).setFeatured(anyBoolean());
        doNothing().when(product).setId((String) any());
        doNothing().when(product).setImageUrl((String) any());
        doNothing().when(product).setManufacturer((String) any());
        doNothing().when(product).setName((String) any());
        doNothing().when(product).setPrice((Integer) any());
        doNothing().when(product).setProductAttributeList((java.util.List<ProductAttribute>) any());
        doNothing().when(product).setProductRating((java.util.List<ProductRating>) any());
        doNothing().when(product).setQuantity((Integer) any());
        doNothing().when(product).setSku((String) any());
        doNothing().when(product).setStock((Integer) any());
        product.setCategory(category);
        product.setCategoryId(123L);
        product.setDescription("The characteristics of someone or something");
        product.setFeatured(true);
        product.setId("42");
        product.setImageUrl("https://example.org/example");
        product.setManufacturer("Manufacturer");
        product.setName("Name");
        product.setPrice(1);
        product.setProductAttributeList(new ArrayList<>());
        product.setProductRating(new ArrayList<>());
        product.setQuantity(1);
        product.setSku("Sku");
        product.setStock(1);
        this.productService.readOneProduct("Sku");
    }

    /**
     * Method under test: {@link ProductService#findByCategoryName(String)}
     */
    @Test
    public void testFindByCategoryName() {
        when(this.productRepository.findByCategory((Category) any())).thenReturn(new ArrayList<>());

        Category category = new Category();
        category.setId(123L);
        category.setName("Name");
        category.setPossibleFacets(new ArrayList<>());
        Optional<Category> ofResult = Optional.of(category);
        when(this.categoryRepository.findByName((String) any())).thenReturn(ofResult);
        assertTrue(this.productService.findByCategoryName("Category Name").isEmpty());
        verify(this.productRepository).findByCategory((Category) any());
        verify(this.categoryRepository).findByName((String) any());
    }

    /**
     * Method under test: {@link ProductService#findByCategoryName(String)}
     */
    @Test
    public void testFindByCategoryName2() {
        when(this.productRepository.findByCategory((Category) any()))
                .thenThrow(new SpringStoreException("An error occurred"));

        Category category = new Category();
        category.setId(123L);
        category.setName("Name");
        category.setPossibleFacets(new ArrayList<>());
        Optional<Category> ofResult = Optional.of(category);
        when(this.categoryRepository.findByName((String) any())).thenReturn(ofResult);
        thrown.expect(SpringStoreException.class);
        this.productService.findByCategoryName("Category Name");
        verify(this.productRepository).findByCategory((Category) any());
        verify(this.categoryRepository).findByName((String) any());
    }

    /**
     * Method under test: {@link ProductService#findByCategoryName(String)}
     */
    @Test
    public void testFindByCategoryName3() {
        Category category = new Category();
        category.setId(123L);
        category.setName("Reading Products belonging to category- {}");
        category.setPossibleFacets(new ArrayList<>());

        Product product = new Product();
        product.setCategory(category);
        product.setCategoryId(123L);
        product.setDescription("The characteristics of someone or something");
        product.setFeatured(true);
        product.setId("42");
        product.setImageUrl("https://example.org/example");
        product.setManufacturer("Reading Products belonging to category- {}");
        product.setName("Reading Products belonging to category- {}");
        product.setPrice(1);
        product.setProductAttributeList(new ArrayList<>());
        product.setProductRating(new ArrayList<>());
        product.setQuantity(1);
        product.setSku("Reading Products belonging to category- {}");
        product.setStock(1);

        ArrayList<Product> productList = new ArrayList<>();
        productList.add(product);
        when(this.productRepository.findByCategory((Category) any())).thenReturn(productList);

        Category category1 = new Category();
        category1.setId(123L);
        category1.setName("Name");
        category1.setPossibleFacets(new ArrayList<>());
        Optional<Category> ofResult = Optional.of(category1);
        when(this.categoryRepository.findByName((String) any())).thenReturn(ofResult);
        assertEquals(1, this.productService.findByCategoryName("Category Name").size());
        verify(this.productRepository).findByCategory((Category) any());
        verify(this.categoryRepository).findByName((String) any());
    }

    /**
     * Method under test: {@link ProductService#findByCategoryName(String)}
     */
    @Test
    public void testFindByCategoryName4() {
        when(this.productRepository.findByCategory((Category) any())).thenReturn(new ArrayList<>());
        when(this.categoryRepository.findByName((String) any())).thenReturn(Optional.empty());
        thrown.expect(IllegalArgumentException.class);
        this.productService.findByCategoryName("Category Name");
        verify(this.categoryRepository).findByName((String) any());
    }

    /**
     * Method under test: {@link ProductService#findByCategoryName(String)}
     */
    @Test
    public void testFindByCategoryName5() {
        Category category = new Category();
        category.setId(123L);
        category.setName("Reading Products belonging to category- {}");
        category.setPossibleFacets(new ArrayList<>());

        Product product = new Product();
        product.setCategory(category);
        product.setCategoryId(123L);
        product.setDescription("The characteristics of someone or something");
        product.setFeatured(true);
        product.setId("42");
        product.setImageUrl("https://example.org/example");
        product.setManufacturer("Reading Products belonging to category- {}");
        product.setName("Reading Products belonging to category- {}");
        product.setPrice(1);
        product.setProductAttributeList(new ArrayList<>());
        product.setProductRating(new ArrayList<>());
        product.setQuantity(1);
        product.setSku("Reading Products belonging to category- {}");
        product.setStock(1);

        Category category1 = new Category();
        category1.setId(123L);
        category1.setName("Reading Products belonging to category- {}");
        category1.setPossibleFacets(new ArrayList<>());

        Product product1 = new Product();
        product1.setCategory(category1);
        product1.setCategoryId(123L);
        product1.setDescription("The characteristics of someone or something");
        product1.setFeatured(true);
        product1.setId("42");
        product1.setImageUrl("https://example.org/example");
        product1.setManufacturer("Reading Products belonging to category- {}");
        product1.setName("Reading Products belonging to category- {}");
        product1.setPrice(1);
        product1.setProductAttributeList(new ArrayList<>());
        product1.setProductRating(new ArrayList<>());
        product1.setQuantity(1);
        product1.setSku("Reading Products belonging to category- {}");
        product1.setStock(1);

        ArrayList<Product> productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product);
        when(this.productRepository.findByCategory((Category) any())).thenReturn(productList);

        Category category2 = new Category();
        category2.setId(123L);
        category2.setName("Name");
        category2.setPossibleFacets(new ArrayList<>());
        Optional<Category> ofResult = Optional.of(category2);
        when(this.categoryRepository.findByName((String) any())).thenReturn(ofResult);
        assertEquals(2, this.productService.findByCategoryName("Category Name").size());
        verify(this.productRepository).findByCategory((Category) any());
        verify(this.categoryRepository).findByName((String) any());
    }

    /**
     * Method under test: {@link ProductService#findByCategoryName(String)}
     */
    @Test
    public void testFindByCategoryName6() {
        Category category = new Category();
        category.setId(123L);
        category.setName("Reading Products belonging to category- {}");
        category.setPossibleFacets(new ArrayList<>());
        Product product = mock(Product.class);
        when(product.isFeatured()).thenReturn(true);
        when(product.getPrice()).thenReturn(1);
        when(product.getQuantity()).thenReturn(0);
        when(product.getDescription()).thenReturn("The characteristics of someone or something");
        when(product.getImageUrl()).thenReturn("https://example.org/example");
        when(product.getManufacturer()).thenReturn("Manufacturer");
        when(product.getName()).thenReturn("Name");
        when(product.getSku()).thenReturn("Sku");
        when(product.getProductAttributeList()).thenReturn(new ArrayList<>());
        when(product.getProductRating()).thenReturn(new ArrayList<>());
        doNothing().when(product).setCategory((Category) any());
        doNothing().when(product).setCategoryId((Long) any());
        doNothing().when(product).setDescription((String) any());
        doNothing().when(product).setFeatured(anyBoolean());
        doNothing().when(product).setId((String) any());
        doNothing().when(product).setImageUrl((String) any());
        doNothing().when(product).setManufacturer((String) any());
        doNothing().when(product).setName((String) any());
        doNothing().when(product).setPrice((Integer) any());
        doNothing().when(product).setProductAttributeList((List<ProductAttribute>) any());
        doNothing().when(product).setProductRating((List<ProductRating>) any());
        doNothing().when(product).setQuantity((Integer) any());
        doNothing().when(product).setSku((String) any());
        doNothing().when(product).setStock((Integer) any());
        product.setCategory(category);
        product.setCategoryId(123L);
        product.setDescription("The characteristics of someone or something");
        product.setFeatured(true);
        product.setId("42");
        product.setImageUrl("https://example.org/example");
        product.setManufacturer("Reading Products belonging to category- {}");
        product.setName("Reading Products belonging to category- {}");
        product.setPrice(1);
        product.setProductAttributeList(new ArrayList<>());
        product.setProductRating(new ArrayList<>());
        product.setQuantity(1);
        product.setSku("Reading Products belonging to category- {}");
        product.setStock(1);

        ArrayList<Product> productList = new ArrayList<>();
        productList.add(product);
        when(this.productRepository.findByCategory((Category) any())).thenReturn(productList);

        Category category1 = new Category();
        category1.setId(123L);
        category1.setName("Name");
        category1.setPossibleFacets(new ArrayList<>());
        Optional<Category> ofResult = Optional.of(category1);
        when(this.categoryRepository.findByName((String) any())).thenReturn(ofResult);
        assertEquals(1, this.productService.findByCategoryName("Category Name").size());
        verify(this.productRepository).findByCategory((Category) any());
        verify(product).isFeatured();
        verify(product).getPrice();
        verify(product, atLeast(1)).getQuantity();
        verify(product).getDescription();
        verify(product).getImageUrl();
        verify(product).getManufacturer();
        verify(product).getName();
        verify(product).getSku();
        verify(product).getProductAttributeList();
        verify(product, atLeast(1)).getProductRating();
        verify(product).setCategory((Category) any());
        verify(product).setCategoryId((Long) any());
        verify(product).setDescription((String) any());
        verify(product).setFeatured(anyBoolean());
        verify(product).setId((String) any());
        verify(product).setImageUrl((String) any());
        verify(product).setManufacturer((String) any());
        verify(product).setName((String) any());
        verify(product).setPrice((Integer) any());
        verify(product).setProductAttributeList((List<ProductAttribute>) any());
        verify(product).setProductRating((List<ProductRating>) any());
        verify(product).setQuantity((Integer) any());
        verify(product).setSku((String) any());
        verify(product).setStock((Integer) any());
        verify(this.categoryRepository).findByName((String) any());
    }

    /**
     * Method under test: {@link ProductService#save(ProductDto)}
     */
    @Test
    public void testSave() {
        // TODO: Complete this test.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by save(ProductDto)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        this.productService.save(new ProductDto());
    }

    /**
     * Method under test: {@link ProductService#save(ProductDto)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testSave2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.techie.shoppingstore.service.ProductService.save(ProductService.java:95)
        //   In order to prevent save(ProductDto)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   save(ProductDto).
        //   See https://diff.blue/R013 to resolve this issue.

        this.productService.save(null);
    }

    /**
     * Method under test: {@link ProductService#save(ProductDto)}
     */
    @Test
    public void testSave3() {
        ProductDto productDto = mock(ProductDto.class);
        when(productDto.getProductName()).thenReturn("Product Name");
        this.productService.save(productDto);
        verify(productDto).getProductName();
    }

    /**
     * Method under test: {@link ProductService#postProductRating(ProductRatingDto)}
     */
    @Test
    public void testPostProductRating() {
        when(this.productSearchRepository.save((ElasticSearchProduct) any())).thenReturn(new ElasticSearchProduct());
        when(this.productSearchRepository.findBySku((String) any())).thenReturn(Optional.of(new ElasticSearchProduct()));

        Category category = new Category();
        category.setId(123L);
        category.setName("Name");
        category.setPossibleFacets(new ArrayList<>());

        Product product = new Product();
        product.setCategory(category);
        product.setCategoryId(123L);
        product.setDescription("The characteristics of someone or something");
        product.setFeatured(true);
        product.setId("42");
        product.setImageUrl("https://example.org/example");
        product.setManufacturer("Manufacturer");
        product.setName("Name");
        product.setPrice(1);
        product.setProductAttributeList(new ArrayList<>());
        product.setProductRating(new ArrayList<>());
        product.setQuantity(1);
        product.setSku("Sku");
        product.setStock(1);
        Optional<Product> ofResult = Optional.of(product);

        Category category1 = new Category();
        category1.setId(123L);
        category1.setName("Name");
        category1.setPossibleFacets(new ArrayList<>());

        Product product1 = new Product();
        product1.setCategory(category1);
        product1.setCategoryId(123L);
        product1.setDescription("The characteristics of someone or something");
        product1.setFeatured(true);
        product1.setId("42");
        product1.setImageUrl("https://example.org/example");
        product1.setManufacturer("Manufacturer");
        product1.setName("Name");
        product1.setPrice(1);
        product1.setProductAttributeList(new ArrayList<>());
        product1.setProductRating(new ArrayList<>());
        product1.setQuantity(1);
        product1.setSku("Sku");
        product1.setStock(1);
        when(this.productRepository.save((Product) any())).thenReturn(product1);
        when(this.productRepository.findBySku((String) any())).thenReturn(ofResult);
        when(this.productMapper.mapProductRatingDto((ProductRatingDto) any())).thenReturn(new ProductRating());
        this.productService.postProductRating(new ProductRatingDto());
        verify(this.productSearchRepository).save((ElasticSearchProduct) any());
        verify(this.productSearchRepository).findBySku((String) any());
        verify(this.productRepository).save((Product) any());
        verify(this.productRepository).findBySku((String) any());
        verify(this.productMapper).mapProductRatingDto((ProductRatingDto) any());
    }

    /**
     * Method under test: {@link ProductService#postProductRating(ProductRatingDto)}
     */
    @Test
    public void testPostProductRating2() {
        when(this.productSearchRepository.save((ElasticSearchProduct) any())).thenReturn(new ElasticSearchProduct());
        when(this.productSearchRepository.findBySku((String) any())).thenReturn(Optional.of(new ElasticSearchProduct()));

        Category category = new Category();
        category.setId(123L);
        category.setName("Name");
        category.setPossibleFacets(new ArrayList<>());

        Product product = new Product();
        product.setCategory(category);
        product.setCategoryId(123L);
        product.setDescription("The characteristics of someone or something");
        product.setFeatured(true);
        product.setId("42");
        product.setImageUrl("https://example.org/example");
        product.setManufacturer("Manufacturer");
        product.setName("Name");
        product.setPrice(1);
        product.setProductAttributeList(new ArrayList<>());
        product.setProductRating(new ArrayList<>());
        product.setQuantity(1);
        product.setSku("Sku");
        product.setStock(1);
        Optional<Product> ofResult = Optional.of(product);
        when(this.productRepository.save((Product) any())).thenThrow(new SpringStoreException("An error occurred"));
        when(this.productRepository.findBySku((String) any())).thenReturn(ofResult);
        when(this.productMapper.mapProductRatingDto((ProductRatingDto) any())).thenReturn(new ProductRating());
        thrown.expect(SpringStoreException.class);
        this.productService.postProductRating(new ProductRatingDto());
        verify(this.productSearchRepository).save((ElasticSearchProduct) any());
        verify(this.productSearchRepository).findBySku((String) any());
        verify(this.productRepository).save((Product) any());
        verify(this.productRepository).findBySku((String) any());
        verify(this.productMapper).mapProductRatingDto((ProductRatingDto) any());
    }

    /**
     * Method under test: {@link ProductService#postProductRating(ProductRatingDto)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testPostProductRating3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.techie.shoppingstore.service.ProductService.postProductRating(ProductService.java:101)
        //   In order to prevent postProductRating(ProductRatingDto)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   postProductRating(ProductRatingDto).
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.productSearchRepository.save((ElasticSearchProduct) any())).thenReturn(new ElasticSearchProduct());
        when(this.productSearchRepository.findBySku((String) any())).thenReturn(null);

        Category category = new Category();
        category.setId(123L);
        category.setName("Name");
        category.setPossibleFacets(new ArrayList<>());

        Product product = new Product();
        product.setCategory(category);
        product.setCategoryId(123L);
        product.setDescription("The characteristics of someone or something");
        product.setFeatured(true);
        product.setId("42");
        product.setImageUrl("https://example.org/example");
        product.setManufacturer("Manufacturer");
        product.setName("Name");
        product.setPrice(1);
        product.setProductAttributeList(new ArrayList<>());
        product.setProductRating(new ArrayList<>());
        product.setQuantity(1);
        product.setSku("Sku");
        product.setStock(1);
        Optional<Product> ofResult = Optional.of(product);

        Category category1 = new Category();
        category1.setId(123L);
        category1.setName("Name");
        category1.setPossibleFacets(new ArrayList<>());

        Product product1 = new Product();
        product1.setCategory(category1);
        product1.setCategoryId(123L);
        product1.setDescription("The characteristics of someone or something");
        product1.setFeatured(true);
        product1.setId("42");
        product1.setImageUrl("https://example.org/example");
        product1.setManufacturer("Manufacturer");
        product1.setName("Name");
        product1.setPrice(1);
        product1.setProductAttributeList(new ArrayList<>());
        product1.setProductRating(new ArrayList<>());
        product1.setQuantity(1);
        product1.setSku("Sku");
        product1.setStock(1);
        when(this.productRepository.save((Product) any())).thenReturn(product1);
        when(this.productRepository.findBySku((String) any())).thenReturn(ofResult);
        when(this.productMapper.mapProductRatingDto((ProductRatingDto) any())).thenReturn(new ProductRating());
        this.productService.postProductRating(new ProductRatingDto());
    }

    /**
     * Method under test: {@link ProductService#postProductRating(ProductRatingDto)}
     */
    @Test
    public void testPostProductRating4() {
        when(this.productSearchRepository.save((ElasticSearchProduct) any())).thenReturn(new ElasticSearchProduct());
        when(this.productSearchRepository.findBySku((String) any())).thenReturn(Optional.empty());

        Category category = new Category();
        category.setId(123L);
        category.setName("Name");
        category.setPossibleFacets(new ArrayList<>());

        Product product = new Product();
        product.setCategory(category);
        product.setCategoryId(123L);
        product.setDescription("The characteristics of someone or something");
        product.setFeatured(true);
        product.setId("42");
        product.setImageUrl("https://example.org/example");
        product.setManufacturer("Manufacturer");
        product.setName("Name");
        product.setPrice(1);
        product.setProductAttributeList(new ArrayList<>());
        product.setProductRating(new ArrayList<>());
        product.setQuantity(1);
        product.setSku("Sku");
        product.setStock(1);
        Optional<Product> ofResult = Optional.of(product);

        Category category1 = new Category();
        category1.setId(123L);
        category1.setName("Name");
        category1.setPossibleFacets(new ArrayList<>());

        Product product1 = new Product();
        product1.setCategory(category1);
        product1.setCategoryId(123L);
        product1.setDescription("The characteristics of someone or something");
        product1.setFeatured(true);
        product1.setId("42");
        product1.setImageUrl("https://example.org/example");
        product1.setManufacturer("Manufacturer");
        product1.setName("Name");
        product1.setPrice(1);
        product1.setProductAttributeList(new ArrayList<>());
        product1.setProductRating(new ArrayList<>());
        product1.setQuantity(1);
        product1.setSku("Sku");
        product1.setStock(1);
        when(this.productRepository.save((Product) any())).thenReturn(product1);
        when(this.productRepository.findBySku((String) any())).thenReturn(ofResult);
        when(this.productMapper.mapProductRatingDto((ProductRatingDto) any())).thenReturn(new ProductRating());
        thrown.expect(SpringStoreException.class);
        this.productService.postProductRating(new ProductRatingDto());
        verify(this.productSearchRepository).findBySku((String) any());
        verify(this.productRepository).findBySku((String) any());
    }

    /**
     * Method under test: {@link ProductService#postProductRating(ProductRatingDto)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testPostProductRating5() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.techie.shoppingstore.service.ProductService.postProductRating(ProductService.java:100)
        //   In order to prevent postProductRating(ProductRatingDto)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   postProductRating(ProductRatingDto).
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.productSearchRepository.save((ElasticSearchProduct) any())).thenReturn(new ElasticSearchProduct());
        when(this.productSearchRepository.findBySku((String) any())).thenReturn(Optional.of(new ElasticSearchProduct()));

        Category category = new Category();
        category.setId(123L);
        category.setName("Name");
        category.setPossibleFacets(new ArrayList<>());

        Product product = new Product();
        product.setCategory(category);
        product.setCategoryId(123L);
        product.setDescription("The characteristics of someone or something");
        product.setFeatured(true);
        product.setId("42");
        product.setImageUrl("https://example.org/example");
        product.setManufacturer("Manufacturer");
        product.setName("Name");
        product.setPrice(1);
        product.setProductAttributeList(new ArrayList<>());
        product.setProductRating(new ArrayList<>());
        product.setQuantity(1);
        product.setSku("Sku");
        product.setStock(1);
        when(this.productRepository.save((Product) any())).thenReturn(product);
        when(this.productRepository.findBySku((String) any())).thenReturn(null);
        when(this.productMapper.mapProductRatingDto((ProductRatingDto) any())).thenReturn(new ProductRating());
        this.productService.postProductRating(new ProductRatingDto());
    }

    /**
     * Method under test: {@link ProductService#postProductRating(ProductRatingDto)}
     */
    @Test
    public void testPostProductRating6() {
        when(this.productSearchRepository.save((ElasticSearchProduct) any())).thenReturn(new ElasticSearchProduct());
        when(this.productSearchRepository.findBySku((String) any())).thenReturn(Optional.of(new ElasticSearchProduct()));

        Category category = new Category();
        category.setId(123L);
        category.setName("Name");
        category.setPossibleFacets(new ArrayList<>());

        Product product = new Product();
        product.setCategory(category);
        product.setCategoryId(123L);
        product.setDescription("The characteristics of someone or something");
        product.setFeatured(true);
        product.setId("42");
        product.setImageUrl("https://example.org/example");
        product.setManufacturer("Manufacturer");
        product.setName("Name");
        product.setPrice(1);
        product.setProductAttributeList(new ArrayList<>());
        product.setProductRating(new ArrayList<>());
        product.setQuantity(1);
        product.setSku("Sku");
        product.setStock(1);
        when(this.productRepository.save((Product) any())).thenReturn(product);
        when(this.productRepository.findBySku((String) any())).thenReturn(Optional.empty());
        when(this.productMapper.mapProductRatingDto((ProductRatingDto) any())).thenReturn(new ProductRating());
        thrown.expect(SpringStoreException.class);
        this.productService.postProductRating(new ProductRatingDto());
        verify(this.productRepository).findBySku((String) any());
    }

    /**
     * Method under test: {@link ProductService#postProductRating(ProductRatingDto)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testPostProductRating7() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.techie.shoppingstore.service.ProductService.postProductRating(ProductService.java:104)
        //   In order to prevent postProductRating(ProductRatingDto)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   postProductRating(ProductRatingDto).
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.productSearchRepository.save((ElasticSearchProduct) any())).thenReturn(new ElasticSearchProduct());
        when(this.productSearchRepository.findBySku((String) any())).thenReturn(Optional.of(new ElasticSearchProduct()));

        Category category = new Category();
        category.setId(123L);
        category.setName("Name");
        category.setPossibleFacets(new ArrayList<>());

        Product product = new Product();
        product.setCategory(category);
        product.setCategoryId(123L);
        product.setDescription("The characteristics of someone or something");
        product.setFeatured(true);
        product.setId("42");
        product.setImageUrl("https://example.org/example");
        product.setManufacturer("Manufacturer");
        product.setName("Name");
        product.setPrice(1);
        product.setProductAttributeList(new ArrayList<>());
        product.setProductRating(new ArrayList<>());
        product.setQuantity(1);
        product.setSku("Sku");
        product.setStock(1);
        Optional<Product> ofResult = Optional.of(product);

        Category category1 = new Category();
        category1.setId(123L);
        category1.setName("Name");
        category1.setPossibleFacets(new ArrayList<>());

        Product product1 = new Product();
        product1.setCategory(category1);
        product1.setCategoryId(123L);
        product1.setDescription("The characteristics of someone or something");
        product1.setFeatured(true);
        product1.setId("42");
        product1.setImageUrl("https://example.org/example");
        product1.setManufacturer("Manufacturer");
        product1.setName("Name");
        product1.setPrice(1);
        product1.setProductAttributeList(new ArrayList<>());
        product1.setProductRating(new ArrayList<>());
        product1.setQuantity(1);
        product1.setSku("Sku");
        product1.setStock(1);
        when(this.productRepository.save((Product) any())).thenReturn(product1);
        when(this.productRepository.findBySku((String) any())).thenReturn(ofResult);
        when(this.productMapper.mapProductRatingDto((ProductRatingDto) any())).thenReturn(null);
        this.productService.postProductRating(new ProductRatingDto());
    }

    /**
     * Method under test: {@link ProductService#postProductRating(ProductRatingDto)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testPostProductRating8() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.techie.shoppingstore.service.ProductService.postProductRating(ProductService.java:100)
        //   In order to prevent postProductRating(ProductRatingDto)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   postProductRating(ProductRatingDto).
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.productSearchRepository.save((ElasticSearchProduct) any())).thenReturn(new ElasticSearchProduct());
        when(this.productSearchRepository.findBySku((String) any())).thenReturn(Optional.of(new ElasticSearchProduct()));

        Category category = new Category();
        category.setId(123L);
        category.setName("Name");
        category.setPossibleFacets(new ArrayList<>());

        Product product = new Product();
        product.setCategory(category);
        product.setCategoryId(123L);
        product.setDescription("The characteristics of someone or something");
        product.setFeatured(true);
        product.setId("42");
        product.setImageUrl("https://example.org/example");
        product.setManufacturer("Manufacturer");
        product.setName("Name");
        product.setPrice(1);
        product.setProductAttributeList(new ArrayList<>());
        product.setProductRating(new ArrayList<>());
        product.setQuantity(1);
        product.setSku("Sku");
        product.setStock(1);
        Optional<Product> ofResult = Optional.of(product);

        Category category1 = new Category();
        category1.setId(123L);
        category1.setName("Name");
        category1.setPossibleFacets(new ArrayList<>());

        Product product1 = new Product();
        product1.setCategory(category1);
        product1.setCategoryId(123L);
        product1.setDescription("The characteristics of someone or something");
        product1.setFeatured(true);
        product1.setId("42");
        product1.setImageUrl("https://example.org/example");
        product1.setManufacturer("Manufacturer");
        product1.setName("Name");
        product1.setPrice(1);
        product1.setProductAttributeList(new ArrayList<>());
        product1.setProductRating(new ArrayList<>());
        product1.setQuantity(1);
        product1.setSku("Sku");
        product1.setStock(1);
        when(this.productRepository.save((Product) any())).thenReturn(product1);
        when(this.productRepository.findBySku((String) any())).thenReturn(ofResult);
        when(this.productMapper.mapProductRatingDto((ProductRatingDto) any())).thenReturn(new ProductRating());
        this.productService.postProductRating(null);
    }

    /**
     * Method under test: {@link ProductService#editProductRating(ProductRatingDto)}
     */
    @Test
    public void testEditProductRating() {
        when(this.productSearchRepository.findBySku((String) any())).thenReturn(Optional.of(new ElasticSearchProduct()));

        Category category = new Category();
        category.setId(123L);
        category.setName("Name");
        category.setPossibleFacets(new ArrayList<>());

        Product product = new Product();
        product.setCategory(category);
        product.setCategoryId(123L);
        product.setDescription("The characteristics of someone or something");
        product.setFeatured(true);
        product.setId("42");
        product.setImageUrl("https://example.org/example");
        product.setManufacturer("Manufacturer");
        product.setName("Name");
        product.setPrice(1);
        product.setProductAttributeList(new ArrayList<>());
        product.setProductRating(new ArrayList<>());
        product.setQuantity(1);
        product.setSku("Sku");
        product.setStock(1);
        Optional<Product> ofResult = Optional.of(product);
        when(this.productRepository.findBySku((String) any())).thenReturn(ofResult);
        thrown.expect(SpringStoreException.class);
        this.productService.editProductRating(new ProductRatingDto());
        verify(this.productSearchRepository).findBySku((String) any());
        verify(this.productRepository).findBySku((String) any());
    }

    /**
     * Method under test: {@link ProductService#editProductRating(ProductRatingDto)}
     */
    @Test
    public void testEditProductRating2() {
        when(this.productSearchRepository.findBySku((String) any()))
                .thenThrow(new SpringStoreException("An error occurred"));

        Category category = new Category();
        category.setId(123L);
        category.setName("Name");
        category.setPossibleFacets(new ArrayList<>());

        Product product = new Product();
        product.setCategory(category);
        product.setCategoryId(123L);
        product.setDescription("The characteristics of someone or something");
        product.setFeatured(true);
        product.setId("42");
        product.setImageUrl("https://example.org/example");
        product.setManufacturer("Manufacturer");
        product.setName("Name");
        product.setPrice(1);
        product.setProductAttributeList(new ArrayList<>());
        product.setProductRating(new ArrayList<>());
        product.setQuantity(1);
        product.setSku("Sku");
        product.setStock(1);
        Optional<Product> ofResult = Optional.of(product);
        when(this.productRepository.findBySku((String) any())).thenReturn(ofResult);
        thrown.expect(SpringStoreException.class);
        this.productService.editProductRating(new ProductRatingDto());
        verify(this.productSearchRepository).findBySku((String) any());
        verify(this.productRepository).findBySku((String) any());
    }

    /**
     * Method under test: {@link ProductService#editProductRating(ProductRatingDto)}
     */
    @Test
    public void testEditProductRating3() {
        when(this.productSearchRepository.findBySku((String) any())).thenReturn(Optional.empty());

        Category category = new Category();
        category.setId(123L);
        category.setName("Name");
        category.setPossibleFacets(new ArrayList<>());

        Product product = new Product();
        product.setCategory(category);
        product.setCategoryId(123L);
        product.setDescription("The characteristics of someone or something");
        product.setFeatured(true);
        product.setId("42");
        product.setImageUrl("https://example.org/example");
        product.setManufacturer("Manufacturer");
        product.setName("Name");
        product.setPrice(1);
        product.setProductAttributeList(new ArrayList<>());
        product.setProductRating(new ArrayList<>());
        product.setQuantity(1);
        product.setSku("Sku");
        product.setStock(1);
        Optional<Product> ofResult = Optional.of(product);
        when(this.productRepository.findBySku((String) any())).thenReturn(ofResult);
        thrown.expect(SpringStoreException.class);
        this.productService.editProductRating(new ProductRatingDto());
        verify(this.productSearchRepository).findBySku((String) any());
        verify(this.productRepository).findBySku((String) any());
    }

    /**
     * Method under test: {@link ProductService#editProductRating(ProductRatingDto)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testEditProductRating4() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //   In order to prevent editProductRating(ProductRatingDto)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   editProductRating(ProductRatingDto).
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.productSearchRepository.findBySku((String) any())).thenReturn(Optional.of(new ElasticSearchProduct()));

        Category category = new Category();
        category.setId(123L);
        category.setName("Name");
        category.setPossibleFacets(new ArrayList<>());

        ArrayList<ProductRating> productRatingList = new ArrayList<>();
        productRatingList.add(new ProductRating());

        Product product = new Product();
        product.setCategory(category);
        product.setCategoryId(123L);
        product.setDescription("The characteristics of someone or something");
        product.setFeatured(true);
        product.setId("42");
        product.setImageUrl("https://example.org/example");
        product.setManufacturer("Manufacturer");
        product.setName("Name");
        product.setPrice(1);
        product.setProductAttributeList(new ArrayList<>());
        product.setProductRating(productRatingList);
        product.setQuantity(1);
        product.setSku("Sku");
        product.setStock(1);
        Optional<Product> ofResult = Optional.of(product);
        when(this.productRepository.findBySku((String) any())).thenReturn(ofResult);
        this.productService.editProductRating(new ProductRatingDto());
    }

    /**
     * Method under test: {@link ProductService#editProductRating(ProductRatingDto)}
     */
    @Test
    public void testEditProductRating5() {
        when(this.productSearchRepository.findBySku((String) any())).thenReturn(Optional.of(new ElasticSearchProduct()));
        when(this.productRepository.findBySku((String) any())).thenReturn(Optional.empty());
        thrown.expect(SpringStoreException.class);
        this.productService.editProductRating(new ProductRatingDto());
        verify(this.productRepository).findBySku((String) any());
    }

    /**
     * Method under test: {@link ProductService#editProductRating(ProductRatingDto)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testEditProductRating6() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.techie.shoppingstore.service.ProductService.editProductRating(ProductService.java:118)
        //   In order to prevent editProductRating(ProductRatingDto)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   editProductRating(ProductRatingDto).
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.productSearchRepository.findBySku((String) any())).thenReturn(Optional.of(new ElasticSearchProduct()));

        Category category = new Category();
        category.setId(123L);
        category.setName("Name");
        category.setPossibleFacets(new ArrayList<>());

        Product product = new Product();
        product.setCategory(category);
        product.setCategoryId(123L);
        product.setDescription("The characteristics of someone or something");
        product.setFeatured(true);
        product.setId("42");
        product.setImageUrl("https://example.org/example");
        product.setManufacturer("Manufacturer");
        product.setName("Name");
        product.setPrice(1);
        product.setProductAttributeList(new ArrayList<>());
        product.setProductRating(new ArrayList<>());
        product.setQuantity(1);
        product.setSku("Sku");
        product.setStock(1);
        Optional<Product> ofResult = Optional.of(product);
        when(this.productRepository.findBySku((String) any())).thenReturn(ofResult);
        this.productService.editProductRating(null);
    }

    /**
     * Method under test: {@link ProductService#deleteProductRating(ProductRatingDto)}
     */
    @Test
    public void testDeleteProductRating() {
        when(this.productSearchRepository.save((ElasticSearchProduct) any())).thenReturn(new ElasticSearchProduct());
        when(this.productSearchRepository.findBySku((String) any())).thenReturn(Optional.of(new ElasticSearchProduct()));

        Category category = new Category();
        category.setId(123L);
        category.setName("Name");
        category.setPossibleFacets(new ArrayList<>());

        Product product = new Product();
        product.setCategory(category);
        product.setCategoryId(123L);
        product.setDescription("The characteristics of someone or something");
        product.setFeatured(true);
        product.setId("42");
        product.setImageUrl("https://example.org/example");
        product.setManufacturer("Manufacturer");
        product.setName("Name");
        product.setPrice(1);
        product.setProductAttributeList(new ArrayList<>());
        product.setProductRating(new ArrayList<>());
        product.setQuantity(1);
        product.setSku("Sku");
        product.setStock(1);
        Optional<Product> ofResult = Optional.of(product);

        Category category1 = new Category();
        category1.setId(123L);
        category1.setName("Name");
        category1.setPossibleFacets(new ArrayList<>());

        Product product1 = new Product();
        product1.setCategory(category1);
        product1.setCategoryId(123L);
        product1.setDescription("The characteristics of someone or something");
        product1.setFeatured(true);
        product1.setId("42");
        product1.setImageUrl("https://example.org/example");
        product1.setManufacturer("Manufacturer");
        product1.setName("Name");
        product1.setPrice(1);
        product1.setProductAttributeList(new ArrayList<>());
        product1.setProductRating(new ArrayList<>());
        product1.setQuantity(1);
        product1.setSku("Sku");
        product1.setStock(1);
        when(this.productRepository.save((Product) any())).thenReturn(product1);
        when(this.productRepository.findBySku((String) any())).thenReturn(ofResult);
        this.productService.deleteProductRating(new ProductRatingDto());
        verify(this.productSearchRepository).save((ElasticSearchProduct) any());
        verify(this.productSearchRepository).findBySku((String) any());
        verify(this.productRepository).save((Product) any());
        verify(this.productRepository).findBySku((String) any());
    }

    /**
     * Method under test: {@link ProductService#deleteProductRating(ProductRatingDto)}
     */
    @Test
    public void testDeleteProductRating2() {
        when(this.productSearchRepository.save((ElasticSearchProduct) any())).thenReturn(new ElasticSearchProduct());
        when(this.productSearchRepository.findBySku((String) any())).thenReturn(Optional.of(new ElasticSearchProduct()));

        Category category = new Category();
        category.setId(123L);
        category.setName("Name");
        category.setPossibleFacets(new ArrayList<>());

        Product product = new Product();
        product.setCategory(category);
        product.setCategoryId(123L);
        product.setDescription("The characteristics of someone or something");
        product.setFeatured(true);
        product.setId("42");
        product.setImageUrl("https://example.org/example");
        product.setManufacturer("Manufacturer");
        product.setName("Name");
        product.setPrice(1);
        product.setProductAttributeList(new ArrayList<>());
        product.setProductRating(new ArrayList<>());
        product.setQuantity(1);
        product.setSku("Sku");
        product.setStock(1);
        Optional<Product> ofResult = Optional.of(product);
        when(this.productRepository.save((Product) any())).thenThrow(new SpringStoreException("An error occurred"));
        when(this.productRepository.findBySku((String) any())).thenReturn(ofResult);
        thrown.expect(SpringStoreException.class);
        this.productService.deleteProductRating(new ProductRatingDto());
        verify(this.productSearchRepository).save((ElasticSearchProduct) any());
        verify(this.productSearchRepository).findBySku((String) any());
        verify(this.productRepository).save((Product) any());
        verify(this.productRepository).findBySku((String) any());
    }

    /**
     * Method under test: {@link ProductService#deleteProductRating(ProductRatingDto)}
     */
    @Test
    public void testDeleteProductRating3() {
        when(this.productSearchRepository.save((ElasticSearchProduct) any())).thenReturn(new ElasticSearchProduct());
        when(this.productSearchRepository.findBySku((String) any())).thenReturn(Optional.empty());

        Category category = new Category();
        category.setId(123L);
        category.setName("Name");
        category.setPossibleFacets(new ArrayList<>());

        Product product = new Product();
        product.setCategory(category);
        product.setCategoryId(123L);
        product.setDescription("The characteristics of someone or something");
        product.setFeatured(true);
        product.setId("42");
        product.setImageUrl("https://example.org/example");
        product.setManufacturer("Manufacturer");
        product.setName("Name");
        product.setPrice(1);
        product.setProductAttributeList(new ArrayList<>());
        product.setProductRating(new ArrayList<>());
        product.setQuantity(1);
        product.setSku("Sku");
        product.setStock(1);
        Optional<Product> ofResult = Optional.of(product);

        Category category1 = new Category();
        category1.setId(123L);
        category1.setName("Name");
        category1.setPossibleFacets(new ArrayList<>());

        Product product1 = new Product();
        product1.setCategory(category1);
        product1.setCategoryId(123L);
        product1.setDescription("The characteristics of someone or something");
        product1.setFeatured(true);
        product1.setId("42");
        product1.setImageUrl("https://example.org/example");
        product1.setManufacturer("Manufacturer");
        product1.setName("Name");
        product1.setPrice(1);
        product1.setProductAttributeList(new ArrayList<>());
        product1.setProductRating(new ArrayList<>());
        product1.setQuantity(1);
        product1.setSku("Sku");
        product1.setStock(1);
        when(this.productRepository.save((Product) any())).thenReturn(product1);
        when(this.productRepository.findBySku((String) any())).thenReturn(ofResult);
        thrown.expect(SpringStoreException.class);
        this.productService.deleteProductRating(new ProductRatingDto());
        verify(this.productSearchRepository).findBySku((String) any());
        verify(this.productRepository).findBySku((String) any());
    }

    /**
     * Method under test: {@link ProductService#deleteProductRating(ProductRatingDto)}
     */
    @Test
    public void testDeleteProductRating4() {
        when(this.productSearchRepository.save((ElasticSearchProduct) any())).thenReturn(new ElasticSearchProduct());
        when(this.productSearchRepository.findBySku((String) any())).thenReturn(Optional.of(new ElasticSearchProduct()));

        Category category = new Category();
        category.setId(123L);
        category.setName("Name");
        category.setPossibleFacets(new ArrayList<>());

        Product product = new Product();
        product.setCategory(category);
        product.setCategoryId(123L);
        product.setDescription("The characteristics of someone or something");
        product.setFeatured(true);
        product.setId("42");
        product.setImageUrl("https://example.org/example");
        product.setManufacturer("Manufacturer");
        product.setName("Name");
        product.setPrice(1);
        product.setProductAttributeList(new ArrayList<>());
        product.setProductRating(new ArrayList<>());
        product.setQuantity(1);
        product.setSku("Sku");
        product.setStock(1);
        when(this.productRepository.save((Product) any())).thenReturn(product);
        when(this.productRepository.findBySku((String) any())).thenReturn(Optional.empty());
        thrown.expect(SpringStoreException.class);
        this.productService.deleteProductRating(new ProductRatingDto());
        verify(this.productRepository).findBySku((String) any());
    }

    /**
     * Method under test: {@link ProductService#deleteProductRating(ProductRatingDto)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testDeleteProductRating5() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.techie.shoppingstore.service.ProductService.deleteProductRating(ProductService.java:132)
        //   In order to prevent deleteProductRating(ProductRatingDto)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   deleteProductRating(ProductRatingDto).
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.productSearchRepository.save((ElasticSearchProduct) any())).thenReturn(new ElasticSearchProduct());
        when(this.productSearchRepository.findBySku((String) any())).thenReturn(Optional.of(new ElasticSearchProduct()));

        Category category = new Category();
        category.setId(123L);
        category.setName("Name");
        category.setPossibleFacets(new ArrayList<>());

        Product product = new Product();
        product.setCategory(category);
        product.setCategoryId(123L);
        product.setDescription("The characteristics of someone or something");
        product.setFeatured(true);
        product.setId("42");
        product.setImageUrl("https://example.org/example");
        product.setManufacturer("Manufacturer");
        product.setName("Name");
        product.setPrice(1);
        product.setProductAttributeList(new ArrayList<>());
        product.setProductRating(new ArrayList<>());
        product.setQuantity(1);
        product.setSku("Sku");
        product.setStock(1);
        Optional<Product> ofResult = Optional.of(product);

        Category category1 = new Category();
        category1.setId(123L);
        category1.setName("Name");
        category1.setPossibleFacets(new ArrayList<>());

        Product product1 = new Product();
        product1.setCategory(category1);
        product1.setCategoryId(123L);
        product1.setDescription("The characteristics of someone or something");
        product1.setFeatured(true);
        product1.setId("42");
        product1.setImageUrl("https://example.org/example");
        product1.setManufacturer("Manufacturer");
        product1.setName("Name");
        product1.setPrice(1);
        product1.setProductAttributeList(new ArrayList<>());
        product1.setProductRating(new ArrayList<>());
        product1.setQuantity(1);
        product1.setSku("Sku");
        product1.setStock(1);
        when(this.productRepository.save((Product) any())).thenReturn(product1);
        when(this.productRepository.findBySku((String) any())).thenReturn(ofResult);
        this.productService.deleteProductRating(null);
    }

    /**
     * Method under test: {@link ProductService#getProductRating(String)}
     */
    @Test
    public void testGetProductRating() {
        Category category = new Category();
        category.setId(123L);
        category.setName("Name");
        category.setPossibleFacets(new ArrayList<>());

        Product product = new Product();
        product.setCategory(category);
        product.setCategoryId(123L);
        product.setDescription("The characteristics of someone or something");
        product.setFeatured(true);
        product.setId("42");
        product.setImageUrl("https://example.org/example");
        product.setManufacturer("Manufacturer");
        product.setName("Name");
        product.setPrice(1);
        product.setProductAttributeList(new ArrayList<>());
        product.setProductRating(new ArrayList<>());
        product.setQuantity(1);
        product.setSku("Sku");
        product.setStock(1);
        Optional<Product> ofResult = Optional.of(product);
        when(this.productRepository.findBySku((String) any())).thenReturn(ofResult);
        assertTrue(this.productService.getProductRating("Sku").isEmpty());
        verify(this.productRepository).findBySku((String) any());
    }

    /**
     * Method under test: {@link ProductService#getProductRating(String)}
     */
    @Test
    public void testGetProductRating2() {
        when(this.productRepository.findBySku((String) any())).thenReturn(Optional.empty());
        thrown.expect(SpringStoreException.class);
        this.productService.getProductRating("Sku");
        verify(this.productRepository).findBySku((String) any());
    }

    /**
     * Method under test: {@link ProductService#getProductRating(String)}
     */
    @Test
    public void testGetProductRating3() {
        when(this.productRepository.findBySku((String) any())).thenThrow(new SpringStoreException("An error occurred"));
        thrown.expect(SpringStoreException.class);
        this.productService.getProductRating("Sku");
        verify(this.productRepository).findBySku((String) any());
    }
}

