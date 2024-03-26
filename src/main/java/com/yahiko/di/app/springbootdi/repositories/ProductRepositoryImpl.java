package com.yahiko.di.app.springbootdi.repositories;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;
import com.yahiko.di.app.springbootdi.model.Product;

@Repository
public class ProductRepositoryImpl implements IProductRepository {

    private List<Product> data;

    public ProductRepositoryImpl() {
        this.data = Arrays.asList(
                new Product(1223L, "Alcantara", 20000L),
                new Product(1333L, "ParaAguas", 200L),
                new Product(1444L, "MAC", 200234234242L),
                new Product(1434L, "PS5", 53535L)
        );
    }

    @Override
    public List<Product> findAll() {
        return data;
    }

    @Override
    public Product findById(Long id){
        return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

}
