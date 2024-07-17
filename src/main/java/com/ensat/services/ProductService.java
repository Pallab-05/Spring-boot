package com.ensat.services;

import com.ensat.entities.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> getAllProducts();

    Product saveProduct(Product product);

    Optional<Product> getProductById(Integer id);

    Product updateProduct(Product product);

    void deleteProductById(Integer id);

}
