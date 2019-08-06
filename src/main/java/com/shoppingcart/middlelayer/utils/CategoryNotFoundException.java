package com.shoppingcart.middlelayer.utils;

import java.security.InvalidParameterException;

public class CategoryNotFoundException extends InvalidParameterException {

    @Override
    public String getMessage() {
        return "Invalid Category ID provided";
    }
}
