package com.shoppingcart.middlelayer.utils;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartOutputGenerator<T> {

    private final ShoppingCartOutput<T> shoppingCartOutput;

    public ShoppingCartOutputGenerator(ShoppingCartOutput<T> shoppingCartOutput) {
        this.shoppingCartOutput = shoppingCartOutput;
    }

    public ShoppingCartOutput<T> generateSuccessResponse(T obj) {
        shoppingCartOutput.setCode(HttpStatus.OK.value());
        shoppingCartOutput.setDescription(HttpStatus.OK.getReasonPhrase());
        shoppingCartOutput.setData(obj);
        return shoppingCartOutput;
    }
}
