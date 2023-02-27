package com.techie.shoppingstore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.CompletionField;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.core.completion.Completion;


import java.util.List;

// Document used to store products in ElasticSearch
@Document(indexName = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ElasticSearchProduct {
    private String id;
    private String name;
    private String description;
    private Integer price;
    private String sku;
    private String imageUrl;
    private Category category;
    @Field(type = FieldType.Nested)
    private List<ProductAttribute> productAttributeList;
    private Integer quantity;
    private String manufacturer;
    private boolean featured;
    @CompletionField(maxInputLength = 100)
    private Completion suggestions;
    private List<ProductRating> productRating;
}
