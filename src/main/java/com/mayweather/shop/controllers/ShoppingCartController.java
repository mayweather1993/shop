package com.mayweather.shop.controllers;

import com.mayweather.shop.services.ProductService;
import com.mayweather.shop.services.ShoppingCartService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//in progress
@RequestMapping("/shoppingCart")
@RestController
@AllArgsConstructor
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;
    private final ProductService productService;






}
