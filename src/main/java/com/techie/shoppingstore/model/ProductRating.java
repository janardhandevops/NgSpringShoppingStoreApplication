package com.techie.shoppingstore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRating {
    private String id;
    @Min(1)
    @Max(5)
    private Integer ratingStars;
    private String productId;
    private String elasticSearchProductId;
    private String review;
    private String userName;
}
