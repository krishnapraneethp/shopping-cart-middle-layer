package com.shoppingcart.middlelayer.dao.impl;

import com.shoppingcart.middlelayer.dao.CategoriesDao;
import com.shoppingcart.middlelayer.dto.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CategoriesDaoImpl implements CategoriesDao {

    private static final String GET_ALL_CATEGORIES = "select catid, catname from categories";
    private static final String GET_ONE_CATEGORY = "select catid, catname from categories where catid = ?";
    private static final String INSERT_CATEGORIES = "insert into categories (catname) values (?)";
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Category> getAllCategories() {
        return jdbcTemplate.query(GET_ALL_CATEGORIES, new BeanPropertyRowMapper<>(Category.class));
    }

    @Override
    public List<Category> getParticularCategory(Integer catId) {
        return jdbcTemplate.query(GET_ONE_CATEGORY, new Object[]{catId},
                new BeanPropertyRowMapper<>(Category.class));
    }

    @Override
    public boolean insertCategory(List<String> categories) {
        int[] result = jdbcTemplate.batchUpdate(INSERT_CATEGORIES, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setString(1, categories.get(i));
            }

            @Override
            public int getBatchSize() {
                return categories.size();
            }
        });
        return result != null;
    }

}