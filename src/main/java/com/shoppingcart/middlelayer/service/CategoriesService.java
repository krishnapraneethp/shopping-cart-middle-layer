package com.shoppingcart.middlelayer.service;

import com.shoppingcart.middlelayer.dto.Category;

import java.util.List;

public interface CategoriesService {

    List<Category> getCategories(Integer catId);

    boolean insertCategory(Category category);

    boolean updateCategory(Category category);

    boolean deleteCategory(Integer id);
}