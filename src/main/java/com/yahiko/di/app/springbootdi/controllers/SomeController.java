package com.yahiko.di.app.springbootdi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yahiko.di.app.springbootdi.model.Product;
import com.yahiko.di.app.springbootdi.repositories.IProductService;

@RequestMapping("api/v0")
@RestController
public class SomeController {

    @Autowired
    private IProductService productService;

    @GetMapping("/products")
    public List<Product> listProducts() {
        return productService.findAll();
    }

    @GetMapping("/products/{product-id}")
    public Product getProductById(@PathVariable(name = "product-id") Long productId) {
        return productService.productFindById(productId);
    }

}
