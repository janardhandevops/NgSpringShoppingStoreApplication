package com.techie.shoppingstore.service;


import com.techie.shoppingstore.dto.CartItems;

import com.techie.shoppingstore.model.ShoppingCart;
import com.techie.shoppingstore.model.ShoppingCartItem;
import com.techie.shoppingstore.repository.CartRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
@AllArgsConstructor
public class CartService {

    private final AuthService authService;
    private final CartRepository cartRepository;

    public String cartItems(ShoppingCartItem s) {

        Optional<User> currentUser = authService.getCurrentUser();
        ShoppingCart cart = cartRepository.findByUsername(currentUser.get().getUsername());
        Set<ShoppingCartItem> shoppingCartItems = new HashSet<ShoppingCartItem>();

        if (cart != null) {
            if ( cart.getShoppingCartItems().size() >= 1) {
                boolean found = false;
                ShoppingCartItem existingItem = new ShoppingCartItem();
                for(ShoppingCartItem item : cart.getShoppingCartItems()){
                    if (item.getProductName().equals(s.getProductName())) {
                        found = true;
                        item.setQuantity(item.getQuantity() + 1);
                        existingItem = item;
                        break;
                    }
                }
                if (found) {
//                    ShoppingCart cart2 = cart;
//                    cartRepository.delete(cart);
                    cartRepository.save(cart);
                } else {
                    shoppingCartItems.addAll(cart.getShoppingCartItems());
                    shoppingCartItems.add(s);
                    cart.setShoppingCartItems(shoppingCartItems);
                    cart.setUsername(currentUser.get().getUsername());
                    cartRepository.save(cart);
//                    ShoppingCart cart2 = cart;
//                    cartRepository.delete(cart);
//                    cartRepository.save(cart2);
                }
            } else {
                shoppingCartItems.add(s);
                cart.setShoppingCartItems(shoppingCartItems);
                cart.setUsername(currentUser.get().getUsername());
                cartRepository.save(cart);
//                ShoppingCart cart2 = cart;
//                cartRepository.delete(cart);
//                cartRepository.save(cart2);
            }
        } else {
            ShoppingCart newCart = new ShoppingCart();
            shoppingCartItems.add(s);
            newCart.setShoppingCartItems(shoppingCartItems);
            newCart.setUsername(currentUser.get().getUsername());
            cartRepository.save(newCart);
//            ShoppingCart cart2 = cart;
//            cartRepository.delete(cart);
//            cartRepository.save(cart2);
        }

        return "success";
    }

    public CartItems getCartItems() {

        Optional<User> currentUser = authService.getCurrentUser();

        ShoppingCart shoppingCart=  cartRepository.findByUsername(currentUser.get().getUsername());
//      shoppingCart.stream().forEach(s->{
//          Integer total=0;
//          total=total+s.getCartTotalPrice();
//      });
//        Integer total=0;
//        for(int  i=0;i<shoppingCart.size();i++){
//
//        total=total+shoppingCart.get(i).getCartTotalPrice();
//        }
        Integer total=0;
        for(ShoppingCartItem language : shoppingCart.getShoppingCartItems()) {

            total=total+language.getTotal();
        }

        CartItems cartItems = new CartItems();
        cartItems.setShoppingCart(shoppingCart);
      cartItems.setTotal(total);

    return cartItems;
    }


    public String removeCartItem(ShoppingCartItem s) {
        Optional<User> currentUser = authService.getCurrentUser();
        ShoppingCart cart = cartRepository.findByUsername(currentUser.get().getUsername());
        Set<ShoppingCartItem> shoppingCartItems = new HashSet<ShoppingCartItem>();
        if (cart != null) {
            if ( cart.getShoppingCartItems().size() >= 1) {
                boolean found = false;

                for(ShoppingCartItem item : cart.getShoppingCartItems()){
                    if (item.getProductName().equals(s.getProductName())) {
                        found = true;
                        cart.getShoppingCartItems().remove(item);

                        break;
                    }
                }
                if (found) {
                    cartRepository.save(cart);
                }else{
                    shoppingCartItems.addAll(cart.getShoppingCartItems());
                    shoppingCartItems.add(s);
                    cart.setShoppingCartItems(shoppingCartItems);
                    cart.setUsername(currentUser.get().getUsername());
                    cartRepository.save(cart);
                }
            }
            else{
                shoppingCartItems.add(s);
                cart.setShoppingCartItems(shoppingCartItems);
                cart.setUsername(currentUser.get().getUsername());
                cartRepository.save(cart);
            }

            }


        return "cart item removed successfully";
    }

    public String removeAllCartItem() {
        Optional<User> currentUser = authService.getCurrentUser();
        ShoppingCart cart = cartRepository.findByUsername(currentUser.get().getUsername());
        Set<ShoppingCartItem> shoppingCartItems = new HashSet<ShoppingCartItem>();
        if (cart != null) {
            if ( cart.getShoppingCartItems().size() >= 1) {
                cart.getShoppingCartItems().removeAll(cart.getShoppingCartItems());
                cartRepository.save(cart);
            }
        }else{
            cartRepository.save(cart);
        }

        return "cart item removed successfully";
    }

    public String removeOneQuantityFromCart(ShoppingCartItem s) {
        Optional<User> currentUser = authService.getCurrentUser();
        ShoppingCart cart = cartRepository.findByUsername(currentUser.get().getUsername());
        Set<ShoppingCartItem> shoppingCartItems = new HashSet<ShoppingCartItem>();
        if (cart != null) {
            if ( cart.getShoppingCartItems().size() >= 1) {
                boolean found = false;

                for(ShoppingCartItem item : cart.getShoppingCartItems()){
                    if (item.getProductName().equals(s.getProductName())) {
                        found = true;
//                       item.setQuantity(item.getQuantity()-1);
//                       if(item.getQuantity().equals(0) ){
//                           cart.getShoppingCartItems().remove(item);
//                       }
                       if(item.getQuantity().equals(1)){
                           cart.getShoppingCartItems().remove(item);
                       }else{
                           item.setQuantity(item.getQuantity()-1);
                       }

                        break;
                    }
                }
                if (found) {
                    cartRepository.save(cart);
                }else{
                    shoppingCartItems.addAll(cart.getShoppingCartItems());
                    shoppingCartItems.add(s);
                    cart.setShoppingCartItems(shoppingCartItems);
                    cart.setUsername(currentUser.get().getUsername());
                    cartRepository.save(cart);
                }
            }
            else{
                shoppingCartItems.add(s);
                cart.setShoppingCartItems(shoppingCartItems);
                cart.setUsername(currentUser.get().getUsername());
                cartRepository.save(cart);
            }

        }


        return "cart item removed successfully";

    }
}
