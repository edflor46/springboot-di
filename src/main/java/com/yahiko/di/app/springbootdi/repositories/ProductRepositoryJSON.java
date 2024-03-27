package com.yahiko.di.app.springbootdi.repositories;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yahiko.di.app.springbootdi.model.Product;

public class ProductRepositoryJSON implements IProductRepository {

    //private static final String PATH_PRODUCT_JSON = "product.json";
    private static final String PATH_PRODUCT_JSON = "classpath:product.json";

    private List<Product> list;

    @Value(PATH_PRODUCT_JSON)
    private Resource resource;

    public ProductRepositoryJSON() {
        //Resource resource = new ClassPathResource(PATH_PRODUCT_JSON);
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            list = Arrays.asList(objectMapper.readValue(resource.getInputStream(), Product[].class));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Override
    public List<Product> findAll() {
        // TODO Auto-generated method stub
        return list;
    }

    @Override
    public Product findById(Long id) {
        // TODO Auto-generated method stub
        /*
         * return list.stream().filter(p -> {
         * return p.getId().equals(id);
         * }).findFirst().orElse(null);
         */

        return list.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

}
