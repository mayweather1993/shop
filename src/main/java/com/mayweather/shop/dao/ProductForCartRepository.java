package com.mayweather.shop.dao;

import com.mayweather.shop.domain.ProductForCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductForCartRepository extends JpaRepository<ProductForCart , Long> {
}
