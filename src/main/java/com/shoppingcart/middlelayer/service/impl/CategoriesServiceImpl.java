package com.shoppingcart.middlelayer.service.impl;

import com.shoppingcart.middlelayer.dao.CategoriesDao;
import com.shoppingcart.middlelayer.dto.Categories;
import com.shoppingcart.middlelayer.service.CategoriesService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriesServiceImpl implements CategoriesService {


    private final CategoriesDao categoriesDao;

    public CategoriesServiceImpl(CategoriesDao categoriesDao) {
        this.categoriesDao = categoriesDao;
    }

    @Override
    public List<Categories> getAllCategories() {
        return categoriesDao.getAllCategories();
    }
}
