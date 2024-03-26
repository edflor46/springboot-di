package com.yahiko.di.app.springbootdi.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yahiko.di.app.springbootdi.model.Product;
import com.yahiko.di.app.springbootdi.repositories.IProductService;
import com.yahiko.di.app.springbootdi.repositories.ProductRepositoryImpl;

@Service
public class ProductServiceImpl implements IProductService{

    @Autowired
    private ProductRepositoryImpl productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll().stream().map(p ->{
            Double priceTax = p.getPrice() * 1.25;

            Product product = (Product) p.clone();
            product.setPrice(priceTax.longValue());

            return product;
        }).collect(Collectors.toList());
    }

    @Override
    public Product productFindById(Long id) {
        return productRepository.findById(id);
    }

   

}
