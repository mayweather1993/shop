package com.mayweather.shop.dao;

import com.mayweather.shop.domain.ProductDefinition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDefinitionRepository extends JpaRepository<ProductDefinition, Long> {
}
