package com.mayweather.shop.services;

import com.mayweather.shop.dao.ProductRepository;
import com.mayweather.shop.domain.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Product findById(final Long id) {

        return productRepository.findOne(id);
    }

    @Override
    public void saveProduct(final Product product) {

        productRepository.save(product);
    }

    @Override
    public void deleteProductById(final Long id) {

        productRepository.delete(id);
    }

    @Override
    public List<Product> getAllProducts() {

        return productRepository.findAll();
    }
}
