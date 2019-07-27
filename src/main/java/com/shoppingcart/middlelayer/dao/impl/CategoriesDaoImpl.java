package com.shoppingcart.middlelayer.dao.impl;

import com.shoppingcart.middlelayer.dao.CategoriesDao;
import com.shoppingcart.middlelayer.dto.Category;
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
    private static final String GET_ONE_CATEGORY = "select catid, catname from categories where catid = ?";

    @Override
    public List<Category> getAllCategories() {
        return jdbcTemplate.query(GET_ALL_CATEGORIES, new BeanPropertyRowMapper<>(Category.class));
    }

    @Override
    public Category getParticularCategory(Integer catId) {
        return (Category) jdbcTemplate.query(GET_ONE_CATEGORY, new Object[]{catId},
                new BeanPropertyRowMapper<>(Category.class));
    }
}