package com.techie.shoppingstore.repository;

import com.techie.shoppingstore.model.Category;
import com.techie.shoppingstore.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface ProductRepository extends MongoRepository<Product, String> {


    List<Product> findByCategory(Category category);

    Optional<Product> findBySku(String sku);
}
