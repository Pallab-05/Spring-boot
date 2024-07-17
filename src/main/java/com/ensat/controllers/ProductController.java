package com.ensat.controllers;

import com.ensat.entities.Product;
import com.ensat.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public List<Product> getListOfProducts() {
        return productService.getAllProducts();
    }

    @PutMapping("/product/{id}")
    private Product updateProduct(@RequestBody Product product, @PathVariable Integer id) {

        Optional<Product> productOptional = productService.getProductById(id);
        System.out.println(productOptional);
        product.setId(product.getId());
        product.setName(product.getName());
        product.setPrice(product.getPrice());

       return productService.saveProduct(product);
    }

}
