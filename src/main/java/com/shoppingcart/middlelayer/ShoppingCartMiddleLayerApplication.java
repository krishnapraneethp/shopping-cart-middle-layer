package com.shoppingcart.middlelayer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.shoppingcart.middlelayer")
//@EnableJpaRepositories
public class ShoppingCartMiddleLayerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShoppingCartMiddleLayerApplication.class, args);
    }
}
