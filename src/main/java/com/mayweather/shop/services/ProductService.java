package com.mayweather.shop.services;

import com.mayweather.shop.domain.Product;

import java.util.List;

public interface ProductService {
    Product findById(Long id);
    void saveProduct(Product product);
    void deleteProductById(Long id);
    List<Product> getAllProducts();
}
