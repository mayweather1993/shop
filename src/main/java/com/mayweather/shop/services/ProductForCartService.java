package com.mayweather.shop.services;

import com.mayweather.shop.domain.ProductForCart;

import java.util.List;

public interface ProductForCartService {
    void save(ProductForCart productForCart);
    void deleteById(Long id);
    List<ProductForCart> getAll();
    ProductForCart findById(Long id);
}
