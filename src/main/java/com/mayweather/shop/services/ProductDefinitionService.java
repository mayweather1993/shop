package com.mayweather.shop.services;

import com.mayweather.shop.domain.ProductDefinition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductDefinitionService {
    ProductDefinition findById(Long id);
    void saveProduct(ProductDefinition productDefinition);
    void deleteProductById(Long id);
    Page<ProductDefinition> getAllProducts(Pageable pageable);
}
