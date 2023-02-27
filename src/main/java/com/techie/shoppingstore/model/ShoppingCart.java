package com.techie.shoppingstore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.io.Serializable;
import java.util.Set;
@Document(collection = "shoppingcart")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShoppingCart implements Serializable {
    private static final long serialVersionUID = -5933882633489466961L;
    @Id
    private String id;
    private Set<ShoppingCartItem> shoppingCartItems;
    private String username;



}
