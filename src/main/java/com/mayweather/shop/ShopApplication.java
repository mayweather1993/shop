package com.mayweather.shop;

import com.mayweather.shop.domain.Product;
import com.mayweather.shop.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.mayweather.shop")
@AllArgsConstructor
public class ShopApplication implements CommandLineRunner {

    private final ProductService productService;

    public static void main(String[] args) {
        SpringApplication.run(ShopApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        final Product product = new Product(1l , "Apple iPhone" , 1000);
        productService.saveProduct(product);
    }
}
