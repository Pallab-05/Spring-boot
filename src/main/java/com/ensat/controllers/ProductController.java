package com.ensat.controllers;

import com.ensat.entities.Product;
import com.ensat.services.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController("/products")
public class ProductController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public List<Product> getListOfProducts() {
        LOGGER.info("Listing out all products");
        return productService.getAllProducts();
    }

    @PutMapping("/product/{id}")
    private Product updateProduct(@RequestBody Product product) {
        LOGGER.info("Updating single product");
       return productService.saveProduct(product);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Integer id){
        LOGGER.warn("Deleting single product");
       return productService.deleteProductById(id);
    }
    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product){
        LOGGER.info("Adding product");
        return productService.saveProduct(product);
    }

}
