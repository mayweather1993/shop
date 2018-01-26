package com.mayweather.shop.services;

import com.mayweather.shop.dao.ProductForCartRepository;
import com.mayweather.shop.domain.ProductForCart;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductForCartServiceImpl implements ProductForCartService{

    private final ProductForCartRepository productForCartRepository;

    @Override
    public void save(ProductForCart productForCart) {
        productForCartRepository.save(productForCart);
    }

    @Override
    public void deleteById(Long id) {
        productForCartRepository.delete(id);
    }

    @Override
    public List<ProductForCart> getAll() {
        return productForCartRepository.findAll();
    }

    @Override
    public ProductForCart findById(Long id) {
        return productForCartRepository.findOne(id);
    }
}
