package com.shoppingcart.middlelayer.dao.impl;

import com.shoppingcart.middlelayer.dao.CategoriesDao;
import com.shoppingcart.middlelayer.dto.Categories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoriesDaoImpl implements CategoriesDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String GET_ALL_CATEGORIES = "select catid, catname from categories";

    @Override
    public List<Categories> getAllCategories() {
        return jdbcTemplate.query(GET_ALL_CATEGORIES, new BeanPropertyRowMapper<>(Categories.class));
    }
}