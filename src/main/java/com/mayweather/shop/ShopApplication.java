package com.mayweather.shop;

import com.mayweather.shop.domain.ProductDefinition;
import com.mayweather.shop.domain.ProductForCart;
import com.mayweather.shop.domain.ShoppingCart;
import com.mayweather.shop.services.ProductDefinitionService;
import com.mayweather.shop.services.ProductForCartService;
import com.mayweather.shop.services.ShoppingCartService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@ComponentScan(basePackages = "com.mayweather.shop")
@AllArgsConstructor
public class ShopApplication implements CommandLineRunner {

    private final ProductDefinitionService productDefinitionService;
    private final ProductForCartService productForCartService;
    private final ShoppingCartService shoppingCartService;

    public static void main(String[] args) {
        SpringApplication.run(ShopApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        ProductDefinition product = new ProductDefinition(1L, "Apple iPhone7", 10020);
        ProductDefinition product2 = new ProductDefinition(2L, "Apple iPhoneX", 9000);
        ProductDefinition product3 = new ProductDefinition(3L, "Apple iPhone10", 103300);
        ProductForCart cart = new ProductForCart(1L, 2L, product);
        ProductForCart cart2 = new ProductForCart(2L, 1L, product2);
        ProductForCart cart3 = new ProductForCart(3L, 4L, product3);
        productDefinitionService.saveProduct(product);
        productDefinitionService.saveProduct(product2);
        productDefinitionService.saveProduct(product3);
        productForCartService.save(cart);
        productForCartService.save(cart2);
        productForCartService.save(cart3);
        List<ProductForCart> productForCartsList = Arrays.asList(cart, cart2, cart3);
        ShoppingCart shoppingCart = new ShoppingCart(1L, productForCartsList);
        shoppingCartService.saveCart(shoppingCart);
    }
}
