package com.techie.shoppingstore.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techie.shoppingstore.dto.ProductDto;
import com.techie.shoppingstore.dto.ProductSearchResponseDto;
import com.techie.shoppingstore.dto.SearchQueryDto;
import com.techie.shoppingstore.service.CategoryService;
import com.techie.shoppingstore.service.ProductService;
import com.techie.shoppingstore.service.SearchService;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {CatalogController.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class CatalogControllerTest {
    @Autowired
    private CatalogController catalogController;

    @MockBean
    private CategoryService categoryService;

    @MockBean
    private ProductService productService;

    @MockBean
    private SearchService searchService;

    /**
     * Method under test: {@link CatalogController#filterForFacets(SearchQueryDto, String)}
     */
    @Test
    public void testFilterForFacets() throws Exception {
        when(this.searchService.searchWithFilters((SearchQueryDto) any(), (String) any()))
                .thenReturn(new ProductSearchResponseDto());

        SearchQueryDto searchQueryDto = new SearchQueryDto();
        searchQueryDto.setFilters(new ArrayList<>());
        searchQueryDto.setTextQuery("Text Query");
        String content = (new ObjectMapper()).writeValueAsString(searchQueryDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/api/store/catalog/{categoryName}/facets/filter", "Category Name")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.catalogController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"products\":null,\"minPrice\":0.0,\"maxPrice\":0.0,\"facetDtos\":null}"));
    }

    /**
     * Method under test: {@link CatalogController#filterForFacets(SearchQueryDto, String)}
     */
    @Test
    public void testFilterForFacets2() throws Exception {
        when(this.searchService.searchWithFilters((SearchQueryDto) any(), (String) any()))
                .thenReturn(new ProductSearchResponseDto());

        SearchQueryDto searchQueryDto = new SearchQueryDto();
        searchQueryDto.setFilters(new ArrayList<>());
        searchQueryDto.setTextQuery("Text Query");
        String content = (new ObjectMapper()).writeValueAsString(searchQueryDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/api/store/catalog/{categoryName}/facets/filter", "Category Name")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.catalogController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"products\":null,\"minPrice\":0.0,\"maxPrice\":0.0,\"facetDtos\":null}"));
    }

    /**
     * Method under test: {@link CatalogController#readOneProduct(String)}
     */
    @Test
    public void testReadOneProduct() throws Exception {
        when(this.productService.readOneProduct((String) any())).thenReturn(new ProductDto());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/store/catalog/products/{sku}",
                "Sku");
        MockMvcBuilders.standaloneSetup(this.catalogController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"productName\":null,\"imageUrl\":null,\"sku\":null,\"price\":null,\"description\":null,\"manufacturer\""
                                        + ":null,\"availability\":null,\"attributeList\":null,\"quantity\":null,\"featured\":false,\"productRatingDtoList"
                                        + "\":null}"));
    }

    /**
     * Method under test: {@link CatalogController#readOneProduct(String)}
     */
    @Test
    public void testReadOneProduct2() throws Exception {
        when(this.productService.findAll()).thenReturn(new ArrayList<>());
        when(this.productService.readOneProduct((String) any())).thenReturn(new ProductDto());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/store/catalog/products/{sku}", "",
                "Uri Vars");
        MockMvcBuilders.standaloneSetup(this.catalogController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link CatalogController#search(SearchQueryDto)}
     */
    @Test
    public void testSearch() throws Exception {
        when(this.searchService.search((SearchQueryDto) any())).thenReturn(new ProductSearchResponseDto());

        SearchQueryDto searchQueryDto = new SearchQueryDto();
        searchQueryDto.setFilters(new ArrayList<>());
        searchQueryDto.setTextQuery("Text Query");
        String content = (new ObjectMapper()).writeValueAsString(searchQueryDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/store/catalog/search")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.catalogController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"products\":null,\"minPrice\":0.0,\"maxPrice\":0.0,\"facetDtos\":null}"));
    }

    /**
     * Method under test: {@link CatalogController#readAllCategories()}
     */
    @Test
    public void testReadAllCategories() throws Exception {
        when(this.categoryService.findAll()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/store/catalog/categories");
        MockMvcBuilders.standaloneSetup(this.catalogController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link CatalogController#readAllCategories()}
     */
    @Test
    public void testReadAllCategories2() throws Exception {
        when(this.categoryService.findAll()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/store/catalog/categories");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(this.catalogController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link CatalogController#readAllProducts()}
     */
    @Test
    public void testReadAllProducts() throws Exception {
        when(this.productService.findAll()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/store/catalog/products");
        MockMvcBuilders.standaloneSetup(this.catalogController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link CatalogController#readAllProducts()}
     */
    @Test
    public void testReadAllProducts2() throws Exception {
        when(this.productService.findAll()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/store/catalog/products");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(this.catalogController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link CatalogController#readFeaturedProducts()}
     */
    @Test
    public void testReadFeaturedProducts() throws Exception {
        when(this.productService.findAll()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/store/catalog/products/featured");
        MockMvcBuilders.standaloneSetup(this.catalogController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link CatalogController#readProductByCategory(String)}
     */
    @Test
    public void testReadProductByCategory() throws Exception {
        when(this.productService.findByCategoryName((String) any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/store/catalog/products/category/{categoryName}", "Category Name");
        MockMvcBuilders.standaloneSetup(this.catalogController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }
}

