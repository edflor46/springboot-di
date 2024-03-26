package com.yahiko.di.app.springbootdi.repositories;

import java.util.List;

import com.yahiko.di.app.springbootdi.model.Product;

public interface IProductService {
    List<Product> findAll();

    Product productFindById(Long id);

}
