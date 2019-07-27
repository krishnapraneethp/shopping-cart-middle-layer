package com.shoppingcart.middlelayer.service;

import com.shoppingcart.middlelayer.dto.Category;

import java.util.List;

public interface CategoriesService {

    List<Category> getAllCategories();

    Category getParticularCategory(Integer catId);
}