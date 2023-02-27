package com.techie.shoppingstore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRatingDto implements Serializable {
    private String ratingId;
    @Min(1)
    @Max(5)
    private Integer ratingStars;
    private String review;
    private String userName;
    private String sku;
}