package com.yahiko.di.app.springbootdi.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.yahiko.di.app.springbootdi.model.Product;
import com.yahiko.di.app.springbootdi.repositories.IProductRepository;
import com.yahiko.di.app.springbootdi.repositories.IProductService;

@Service
public class ProductServiceImpl implements IProductService{

    @Autowired
    //@Qualifier("productRepositoryImpl")
    private IProductRepository productRepository;

    @Autowired
    private Environment environment;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll().stream().map(p ->{
            Double priceTax = p.getPrice() * environment.getProperty("config.price.tax",Double.class);

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
