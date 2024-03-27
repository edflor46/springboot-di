package com.yahiko.di.app.springbootdi.repositories;

import java.util.Collections;
import java.util.List;

//import org.springframework.context.annotation.Primary;
//import org.springframework.stereotype.Repository;

import com.yahiko.di.app.springbootdi.model.Product;

//@Primary
//@Repository
public class ProductRepositoryFoo implements IProductRepository{

    @Override
    public List<Product> findAll() {
        // TODO Auto-generated method stub
        return Collections.singletonList(new Product(1L,"Algo",1234L));
    }

    @Override
    public Product findById(Long id) {
        // TODO Auto-generated method stub
        return new Product(id,"Algo",1234L);
    }

}
