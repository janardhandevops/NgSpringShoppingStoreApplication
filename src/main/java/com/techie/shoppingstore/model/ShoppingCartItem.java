package com.techie.shoppingstore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.techie.shoppingstore.dto.ProductAvailability;
import com.techie.shoppingstore.dto.ProductRatingDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingCartItem {

    private String productName;
    private String imageUrl;
    private String sku;
    private Integer price;
    private String description;
    private String manufacturer;
    private ProductAvailability availability;
    private List<ProductAttribute> attributeList;
    private Integer quantity;
    private boolean featured;
    private List<ProductRatingDto> productRatingDtoList;
    private Integer total;
}
