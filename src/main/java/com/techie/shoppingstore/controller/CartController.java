package com.techie.shoppingstore.controller;

import com.techie.shoppingstore.dto.CartItems;
import com.techie.shoppingstore.dto.ShoppingCartDto;
import com.techie.shoppingstore.model.ShoppingCartItem;
import com.techie.shoppingstore.service.CartService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/cart/")
@AllArgsConstructor
public class CartController {

    private final CartService cartService;

    @PostMapping("/add/cartItems")
    public ResponseEntity<String> cartItems(@RequestBody ShoppingCartItem shoppingCartDto){

        return new ResponseEntity<>(cartService.cartItems(shoppingCartDto),OK);
    }
    @GetMapping("/add/getCartItems")
    public ResponseEntity<CartItems> getCartItems(){

        return new ResponseEntity<>(cartService.getCartItems(),OK);
    }
    @PostMapping("removeItem/removeCartItem")
    public ResponseEntity<String> removeCartItem(@RequestBody ShoppingCartItem shoppingCartDto){

        return new ResponseEntity<>(cartService.removeCartItem(shoppingCartDto),OK);
    }
    @PostMapping("removeItem/removeAllCartItem")
    public ResponseEntity<String> removeAllCartItem(){

        return new ResponseEntity<>(cartService.removeAllCartItem(),OK);
    }
    @PostMapping("removeItem/removeOneQuantityFromCart")
    public ResponseEntity<String> removeOneQuantityFromCart(@RequestBody ShoppingCartItem shoppingCartDto){

        return new ResponseEntity<>(cartService.removeOneQuantityFromCart(shoppingCartDto),OK);
    }
}
