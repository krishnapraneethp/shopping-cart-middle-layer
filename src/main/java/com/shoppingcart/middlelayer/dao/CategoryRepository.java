package com.shoppingcart.middlelayer.dao;

import com.shoppingcart.middlelayer.dto.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Integer> {

}
