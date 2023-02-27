package com.techie.shoppingstore.repository;

import com.techie.shoppingstore.model.Product;
import com.techie.shoppingstore.model.ShoppingCart;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface CartRepository extends MongoRepository<ShoppingCart, String> {
    public List<ShoppingCart> findAllByUsername(String username);
    public ShoppingCart findByUsername(String username);

    ShoppingCart findByShoppingCartItems_ProductName(String name);


}
