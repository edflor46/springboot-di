package com.yahiko.di.app.springbootdi.repositories;

import java.util.List;


import com.yahiko.di.app.springbootdi.model.Product;

public interface IProductRepository {

    List<Product> findAll();
    Product findById(Long id);
}
