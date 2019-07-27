package com.shoppingcart.middlelayer.controllers;

import com.shoppingcart.middlelayer.dto.CategoriesWrapper;
import com.shoppingcart.middlelayer.dto.Category;
import com.shoppingcart.middlelayer.service.CategoriesService;
import com.shoppingcart.middlelayer.utils.ShoppingCartOutput;
import com.shoppingcart.middlelayer.utils.ShoppingCartOutputGenerator;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "shopping-cart-middle-layer")
public class CategoriesController {

    private final CategoriesWrapper categoriesWrapper;
    private final CategoriesService categoriesService;
    private final ShoppingCartOutputGenerator<CategoriesWrapper> shoppingCartOutputGenerator;

    public CategoriesController(CategoriesWrapper categoriesWrapper, CategoriesService categoriesService,
                                ShoppingCartOutputGenerator<CategoriesWrapper> shoppingCartOutputGenerator) {
        this.categoriesWrapper = categoriesWrapper;
        this.categoriesService = categoriesService;
        this.shoppingCartOutputGenerator = shoppingCartOutputGenerator;
    }

    @GetMapping(value = "get-all-categories")
    public ShoppingCartOutput<CategoriesWrapper> getAllCategories() {
        List<Category> categories = categoriesService.getAllCategories();
        categoriesWrapper.setCategories(categories);
        return shoppingCartOutputGenerator.generateSuccessResponse(categoriesWrapper);
    }

    @GetMapping(value = "get-category/{categoryId}")
    public ShoppingCartOutput<CategoriesWrapper> getOneCategory(@PathVariable Integer categoryId) {
        Category category = categoriesService.getParticularCategory(categoryId);
        categoriesWrapper.setCategory(category);
        return shoppingCartOutputGenerator.generateSuccessResponse(categoriesWrapper);
    }
}