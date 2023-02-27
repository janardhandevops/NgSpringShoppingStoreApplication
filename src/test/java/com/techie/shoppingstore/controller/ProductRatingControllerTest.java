package com.techie.shoppingstore.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techie.shoppingstore.dto.ProductRatingDto;
import com.techie.shoppingstore.service.ProductService;

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

@ContextConfiguration(classes = {ProductRatingController.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class ProductRatingControllerTest {
    @Autowired
    private ProductRatingController productRatingController;

    @MockBean
    private ProductService productService;

    /**
     * Method under test: {@link ProductRatingController#deleteRating(ProductRatingDto, String)}
     */
    @Test
    public void testDeleteRating() throws Exception {
        doNothing().when(this.productService).deleteProductRating((ProductRatingDto) any());

        ProductRatingDto productRatingDto = new ProductRatingDto();
        productRatingDto.setRatingId("42");
        productRatingDto.setRatingStars(1);
        productRatingDto.setReview("Review");
        productRatingDto.setSku("Sku");
        productRatingDto.setUserName("janedoe");
        String content = (new ObjectMapper()).writeValueAsString(productRatingDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/api/products/ratings/delete/{ratingId}", "42")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.productRatingController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link ProductRatingController#editRating(ProductRatingDto)}
     */
    @Test
    public void testEditRating() throws Exception {
        doNothing().when(this.productService).editProductRating((ProductRatingDto) any());

        ProductRatingDto productRatingDto = new ProductRatingDto();
        productRatingDto.setRatingId("42");
        productRatingDto.setRatingStars(1);
        productRatingDto.setReview("Review");
        productRatingDto.setSku("Sku");
        productRatingDto.setUserName("janedoe");
        String content = (new ObjectMapper()).writeValueAsString(productRatingDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/products/ratings/edit")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.productRatingController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link ProductRatingController#getRating(String)}
     */
    @Test
    public void testGetRating() throws Exception {
        when(this.productService.getProductRating((String) any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/products/ratings/get/{sku}", "Sku");
        MockMvcBuilders.standaloneSetup(this.productRatingController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link ProductRatingController#getRating(String)}
     */
    @Test
    public void testGetRating2() throws Exception {
        when(this.productService.getProductRating((String) any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/products/ratings/get/{sku}", "Sku");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(this.productRatingController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link ProductRatingController#postRating(ProductRatingDto)}
     */
    @Test
    public void testPostRating() throws Exception {
        doNothing().when(this.productService).postProductRating((ProductRatingDto) any());

        ProductRatingDto productRatingDto = new ProductRatingDto();
        productRatingDto.setRatingId("42");
        productRatingDto.setRatingStars(1);
        productRatingDto.setReview("Review");
        productRatingDto.setSku("Sku");
        productRatingDto.setUserName("janedoe");
        String content = (new ObjectMapper()).writeValueAsString(productRatingDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/products/ratings/submit")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.productRatingController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}

