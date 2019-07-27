package com.shoppingcart.middlelayer.utils;

import org.springframework.stereotype.Component;

@Component
public class ShoppingCartOutput<T> {

    private Integer code;
    private String description;
    private T data;

    public Integer getCode() {
        return code;
    }

    void setCode(Integer code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    void setDescription(String description) {
        this.description = description;
    }

    public T getData() {
        return data;
    }

    void setData(T data) {
        this.data = data;
    }
}