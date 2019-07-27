package com.shoppingcart.middlelayer.dao;

import com.shoppingcart.middlelayer.dto.Category;

import java.util.List;

public interface CategoriesDao {
    List<Category> getAllCategories();

    Category getParticularCategory(Integer catId);
}
