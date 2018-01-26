package com.mayweather.shop.services;

import com.mayweather.shop.dao.ProductDefinitionRepository;
import com.mayweather.shop.domain.ProductDefinition;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductDefinitionServiceImpl implements ProductDefinitionService {

    private final ProductDefinitionRepository productDefinitionRepository;

    @Override
    public ProductDefinition findById(final Long id) {

        return productDefinitionRepository.findOne(id);
    }

    @Override
    public void saveProduct(final ProductDefinition productDefinition) {

        productDefinitionRepository.save(productDefinition);
    }

    @Override
    public void deleteProductById(final Long id) {

        productDefinitionRepository.delete(id);
    }

    @Override
    public Page<ProductDefinition> getAllProducts(Pageable pageable) {
        return productDefinitionRepository.findAll(pageable);
    }
}
