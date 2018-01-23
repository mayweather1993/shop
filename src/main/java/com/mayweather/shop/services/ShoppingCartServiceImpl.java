package com.mayweather.shop.services;

import com.mayweather.shop.dao.ProductRepository;
import com.mayweather.shop.dao.ShoppingCartRepository;
import com.mayweather.shop.domain.Product;
import com.mayweather.shop.domain.ShoppingCart;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;
    private final ProductRepository productRepository;

    @Override
    public ShoppingCart findById(Long id) {
        return shoppingCartRepository.findOne(id);
    }

    @Override
    public void saveCart(ShoppingCart shoppingCart) {
        shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public void addProduct(Long cartId, Long productId) {
        Product product = productRepository.findOne(productId);
        ShoppingCart cart = shoppingCartRepository.findOne(cartId);
        cart.getProducts().add(product);
    }

    @Override
    public void deleteCartById(Long id) {
        shoppingCartRepository.delete(id);
    }

    @Override
    public List<ShoppingCart> findAllCarts() {
        return shoppingCartRepository.findAll();
    }
}
