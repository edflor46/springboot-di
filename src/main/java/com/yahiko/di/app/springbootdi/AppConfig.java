package com.yahiko.di.app.springbootdi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import com.yahiko.di.app.springbootdi.repositories.IProductRepository;
import com.yahiko.di.app.springbootdi.repositories.ProductRepositoryJSON;

@Configuration
@PropertySource("classpath:config.properties")
public class AppConfig {

    @Bean
    @Primary
    IProductRepository productRepositoryJson(){
        return new ProductRepositoryJSON();
    }

}
