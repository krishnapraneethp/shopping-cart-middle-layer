package com.shoppingcart.middlelayer.dao;

import com.shoppingcart.middlelayer.dto.Categories;

import java.util.List;

public interface CategoriesDao {
    List<Categories> getAllCategories();
}
