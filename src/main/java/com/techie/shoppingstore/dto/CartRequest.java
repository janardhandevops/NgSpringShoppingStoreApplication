package com.techie.shoppingstore.dto;

import lombok.Data;

@Data
public class CartRequest {
    private Integer cartTotalPrice;
    private int numberOfItems;
}
