package com.techie.shoppingstore.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.techie.shoppingstore.model.Category;
import com.techie.shoppingstore.model.ProductAttribute;
import com.techie.shoppingstore.model.ProductRating;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShoppingCartDto {
    ArrayList<ShoppingCartProductDto> cartItemList;
    Integer grandTotal;

}
