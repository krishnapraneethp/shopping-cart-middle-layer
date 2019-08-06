package com.shoppingcart.middlelayer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class ShoppingCartMiddleLayerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShoppingCartMiddleLayerApplication.class, args);
    }

}
