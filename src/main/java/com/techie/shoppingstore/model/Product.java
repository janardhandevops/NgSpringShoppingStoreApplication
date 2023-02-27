package com.techie.shoppingstore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

import java.util.List;

@Document(collection = "Product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {
    private String id;
    private String name;
    private String description;
    private Integer price;
    private String sku;
    private String imageUrl;
    private Category category;
    private Long categoryId;
    private List<ProductAttribute> productAttributeList;
    private Integer stock;
    private String manufacturer;
    private Integer quantity;
    private boolean featured;
    private List<ProductRating> productRating;
}
