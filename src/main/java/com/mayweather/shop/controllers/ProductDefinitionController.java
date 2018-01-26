package com.mayweather.shop.controllers;

import com.mayweather.shop.domain.ProductDefinition;
import com.mayweather.shop.services.ProductDefinitionService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductDefinitionController {

    private final ProductDefinitionService productDefinitionService;

    @GetMapping
    public ResponseEntity<Page<ProductDefinition>> listAll(Pageable pageable) {
        Page<ProductDefinition> allProducts = productDefinitionService.getAllProducts(pageable);
        return new ResponseEntity<>(allProducts, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<ProductDefinition> get(@PathVariable("id")final Long id) {
        ProductDefinition productDefinition = productDefinitionService.findById(id);
        return new ResponseEntity<>(productDefinition, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity post(@RequestBody final ProductDefinition productDefinition) {
        productDefinitionService.saveProduct(productDefinition);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") final Long id) {
        productDefinitionService.deleteProductById(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
