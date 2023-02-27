package com.techie.shoppingstore.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techie.shoppingstore.dto.CartItems;
import com.techie.shoppingstore.dto.ProductAvailability;
import com.techie.shoppingstore.model.ShoppingCartItem;
import com.techie.shoppingstore.service.CartService;

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

@ContextConfiguration(classes = {CartController.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class CartControllerTest {
    @Autowired
    private CartController cartController;

    @MockBean
    private CartService cartService;

    /**
     * Method under test: {@link CartController#cartItems(ShoppingCartItem)}
     */
    @Test
    public void testCartItems() throws Exception {
        when(this.cartService.cartItems((ShoppingCartItem) any())).thenReturn("Cart Items");

        ShoppingCartItem shoppingCartItem = new ShoppingCartItem();
        shoppingCartItem.setAttributeList(new ArrayList<>());
        shoppingCartItem.setAvailability(new ProductAvailability("Availability", "Color"));
        shoppingCartItem.setDescription("The characteristics of someone or something");
        shoppingCartItem.setFeatured(true);
        shoppingCartItem.setImageUrl("https://example.org/example");
        shoppingCartItem.setManufacturer("Manufacturer");
        shoppingCartItem.setPrice(1);
        shoppingCartItem.setProductName("Product Name");
        shoppingCartItem.setQuantity(1);
        shoppingCartItem.setSku("Sku");
        shoppingCartItem.setTotal(1);
        String content = (new ObjectMapper()).writeValueAsString(shoppingCartItem);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/cart/add/cartItems")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.cartController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Cart Items"));
    }

    /**
     * Method under test: {@link CartController#getCartItems()}
     */
    @Test
    public void testGetCartItems() throws Exception {
        when(this.cartService.getCartItems()).thenReturn(new CartItems());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/cart/add/getCartItems");
        MockMvcBuilders.standaloneSetup(this.cartController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content().string("{\"shoppingCart\":null,\"total\":null}"));
    }

    /**
     * Method under test: {@link CartController#removeCartItem(ShoppingCartItem)}
     */
    @Test
    public void testRemoveCartItem() throws Exception {
        when(this.cartService.removeCartItem((ShoppingCartItem) any())).thenReturn("Remove Cart Item");

        ShoppingCartItem shoppingCartItem = new ShoppingCartItem();
        shoppingCartItem.setAttributeList(new ArrayList<>());
        shoppingCartItem.setAvailability(new ProductAvailability("Availability", "Color"));
        shoppingCartItem.setDescription("The characteristics of someone or something");
        shoppingCartItem.setFeatured(true);
        shoppingCartItem.setImageUrl("https://example.org/example");
        shoppingCartItem.setManufacturer("Manufacturer");
        shoppingCartItem.setPrice(1);
        shoppingCartItem.setProductName("Product Name");
        shoppingCartItem.setQuantity(1);
        shoppingCartItem.setSku("Sku");
        shoppingCartItem.setTotal(1);
        String content = (new ObjectMapper()).writeValueAsString(shoppingCartItem);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/cart/removeItem/removeCartItem")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.cartController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Remove Cart Item"));
    }

    /**
     * Method under test: {@link CartController#removeAllCartItem()}
     */
    @Test
    public void testRemoveAllCartItem() throws Exception {
        when(this.cartService.removeAllCartItem()).thenReturn("Remove All Cart Item");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/api/cart/removeItem/removeAllCartItem");
        MockMvcBuilders.standaloneSetup(this.cartController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Remove All Cart Item"));
    }

    /**
     * Method under test: {@link CartController#removeOneQuantityFromCart(ShoppingCartItem)}
     */
    @Test
    public void testRemoveOneQuantityFromCart() throws Exception {
        when(this.cartService.removeOneQuantityFromCart((ShoppingCartItem) any())).thenReturn("jane.doe@example.org");

        ShoppingCartItem shoppingCartItem = new ShoppingCartItem();
        shoppingCartItem.setAttributeList(new ArrayList<>());
        shoppingCartItem.setAvailability(new ProductAvailability("Availability", "Color"));
        shoppingCartItem.setDescription("The characteristics of someone or something");
        shoppingCartItem.setFeatured(true);
        shoppingCartItem.setImageUrl("https://example.org/example");
        shoppingCartItem.setManufacturer("Manufacturer");
        shoppingCartItem.setPrice(1);
        shoppingCartItem.setProductName("Product Name");
        shoppingCartItem.setQuantity(1);
        shoppingCartItem.setSku("Sku");
        shoppingCartItem.setTotal(1);
        String content = (new ObjectMapper()).writeValueAsString(shoppingCartItem);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/api/cart/removeItem/removeOneQuantityFromCart")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.cartController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("jane.doe@example.org"));
    }
}

