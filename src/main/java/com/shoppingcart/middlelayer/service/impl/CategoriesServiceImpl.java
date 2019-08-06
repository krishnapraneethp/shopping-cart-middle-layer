package com.shoppingcart.middlelayer.service.impl;

import com.shoppingcart.middlelayer.dao.CategoryRepository;
import com.shoppingcart.middlelayer.dto.Category;
import com.shoppingcart.middlelayer.service.CategoriesService;
import com.shoppingcart.middlelayer.utils.CategoryNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriesServiceImpl implements CategoriesService {

    private final CategoryRepository categoryRepository;

    public CategoriesServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public List<Category> getCategories(Integer catId) {
        List<Category> categories = new ArrayList<>();
        if (catId != null) {
            Optional<Category> categoryRepo = categoryRepository.findById(catId);
            if (categoryRepo.isPresent()) {
                categories.add(categoryRepo.get());
            } else {
                throw new CategoryNotFoundException();
            }
        } else {
            categoryRepository.findAll().forEach(categories::add);
        }
        return categories;

    }

    @Override
    public boolean insertCategory(Category category) {
        categoryRepository.save(category);
        return true;
    }

    @Override
    public boolean updateCategory(Category category) {
        Category category1 = categoryRepository.save(category);
        return category1 != null;
    }

    @Override
    public boolean deleteCategory(Integer id) {
        categoryRepository.deleteById(id);
        return true;
    }

}