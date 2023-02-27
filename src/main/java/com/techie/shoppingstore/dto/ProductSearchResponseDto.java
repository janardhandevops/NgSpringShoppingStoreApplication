package com.techie.shoppingstore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductSearchResponseDto {
    private List<ProductDto> products;
    private double minPrice;
    private double maxPrice;
    private List<FacetDto> facetDtos;


}