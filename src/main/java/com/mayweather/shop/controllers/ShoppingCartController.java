package com.mayweather.shop.controllers;

import com.mayweather.shop.domain.ShoppingCart;
import com.mayweather.shop.services.ShoppingCartService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/shoppingCart")
@RestController
@AllArgsConstructor
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;


    @PostMapping
    public ResponseEntity<ShoppingCart> create(@RequestBody final ShoppingCart shoppingCart) {
        shoppingCartService.saveCart(shoppingCart);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping(value = "/{cartId}/add/{productId}")
    public ResponseEntity addProductToCart(@PathVariable("cartId") final Long cartId,
                                           @PathVariable("productId") final Long productId) {
        shoppingCartService.addProduct(cartId, productId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "{cartId}")
    public ResponseEntity<ShoppingCart> delete(@PathVariable("cartId") final Long cartId) {
        shoppingCartService.deleteCartById(cartId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ShoppingCart>> listAll() {
        List<ShoppingCart> allCarts = shoppingCartService.findAllCarts();
        return new ResponseEntity<>(allCarts, HttpStatus.OK);
    }

    @GetMapping("{cartId}")
    public ResponseEntity<ShoppingCart> findById(@PathVariable("cartId") final Long cartId) {
        ShoppingCart cart = shoppingCartService.findById(cartId);
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }
}
