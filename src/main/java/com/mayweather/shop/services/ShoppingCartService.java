package com.mayweather.shop.services;

import com.mayweather.shop.domain.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {
    ShoppingCart findById(Long id);
    void saveCart(ShoppingCart shoppingCart);
    void addProduct(Long cartId, Long productId);
    void deleteCartById(Long id);
    List<ShoppingCart> findAllCarts();

}
