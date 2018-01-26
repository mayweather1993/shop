package com.mayweather.shop.services;

import com.mayweather.shop.dao.ShoppingCartRepository;
import com.mayweather.shop.domain.ProductForCart;
import com.mayweather.shop.domain.ShoppingCart;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;
    private final ProductDefinitionService productDefinitionService;
    private final ProductForCartService productForCartService;


    @Override
    public ShoppingCart findById(Long id) {
        return shoppingCartRepository.findOne(id);
    }

    @Override
    public void saveCart(ShoppingCart shoppingCart) {
        shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public void addProduct(Long cartId, Long productFromCartId) {
        ShoppingCart cart = findById(cartId);
        List<ProductForCart> products = cart.getProducts();
        for (ProductForCart product :
                products) {
            if (product.getProductDefinition().getId().equals(productFromCartId)) {
                Long count = product.getCount();
                product.setCount(++count);
                productForCartService.save(product);
            }
        }
        if(products.isEmpty() || !products.contains(productForCartService.findById(productFromCartId))){
            products.add(productForCartService.findById(productFromCartId));
        }
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
