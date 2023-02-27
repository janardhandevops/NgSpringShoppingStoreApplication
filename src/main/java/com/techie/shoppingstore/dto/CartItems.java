package com.techie.shoppingstore.dto;

import com.techie.shoppingstore.model.ShoppingCart;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItems {
    ShoppingCart shoppingCart;
    Integer total;
}
