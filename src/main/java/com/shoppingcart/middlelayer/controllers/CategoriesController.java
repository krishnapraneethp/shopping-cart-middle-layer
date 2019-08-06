package com.shoppingcart.middlelayer.controllers;

import com.shoppingcart.middlelayer.dto.CategoriesWrapper;
import com.shoppingcart.middlelayer.dto.Category;
import com.shoppingcart.middlelayer.service.CategoriesService;
import com.shoppingcart.middlelayer.utils.ShoppingCartOutput;
import com.shoppingcart.middlelayer.utils.ShoppingCartOutputGenerator;
import org.springframework.web.bind.annotation.*;

import javax.inject.Provider;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "shopping-cart-middle-layer")
public class CategoriesController {

    private final Provider<CategoriesWrapper> categoriesWrapper;
    private final CategoriesService categoriesService;
    private final ShoppingCartOutputGenerator<CategoriesWrapper> shoppingCartOutputGenerator;

    public CategoriesController(Provider<CategoriesWrapper> categoriesWrapper, CategoriesService categoriesService,
                                ShoppingCartOutputGenerator<CategoriesWrapper> shoppingCartOutputGenerator) {
        this.categoriesWrapper = categoriesWrapper;
        this.categoriesService = categoriesService;
        this.shoppingCartOutputGenerator = shoppingCartOutputGenerator;
    }

    @GetMapping(value = {"categories/get", "category/get/{categoryId}"})
    public ShoppingCartOutput<CategoriesWrapper> getCategories(@PathVariable Optional<Integer> categoryId) {
        List<Category> categories = categoriesService.getCategories(categoryId.orElse(null));
        categoriesWrapper.get().setCategories(categories);
        return shoppingCartOutputGenerator.generateSuccessResponse(categoriesWrapper.get());
    }

    @PostMapping(value = {"category/save", "category/update"})
    public ShoppingCartOutput<CategoriesWrapper> updateInsertCategories(
            @RequestBody Category category) {
        if (category.getId() != null) {
            boolean isUpdated = categoriesService.updateCategory(category);
            categoriesWrapper.get().setUpdated(isUpdated);
        } else {
            boolean isInserted = categoriesService.insertCategory(category);
            categoriesWrapper.get().setInserted(isInserted);
        }
        return shoppingCartOutputGenerator.generateSuccessResponse(categoriesWrapper.get());
    }

    @DeleteMapping(value = "category/delete/{categoryId}")
    public ShoppingCartOutput<CategoriesWrapper> deleteCategory(@PathVariable Integer categoryId) {
        boolean isDeleted = categoriesService.deleteCategory(categoryId);
        categoriesWrapper.get().setDeleted(isDeleted);
        return shoppingCartOutputGenerator.generateSuccessResponse(categoriesWrapper.get());
    }
}