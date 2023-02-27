package com.techie.shoppingstore.dto;

import com.techie.shoppingstore.model.ProductAttribute;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingCartProductDto implements Serializable {
    private String productName;
    private String imageUrl;
    private String sku;
    private Integer price;
    private String description;
    private String manufacturer;
    private ProductAvailability availability;
    private List<ProductAttribute> attributeList;
    private Integer addtoCart;
    private boolean featured;
    private List<ProductRatingDto> productRatingDtoList;
    private Integer total;
}
