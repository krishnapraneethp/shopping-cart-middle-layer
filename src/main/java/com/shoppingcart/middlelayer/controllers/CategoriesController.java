package com.shoppingcart.middlelayer.controllers;

import com.shoppingcart.middlelayer.utils.ShoppingCartOutput;
import com.shoppingcart.middlelayer.utils.ShoppingCartOutputGenerator;
import com.shoppingcart.middlelayer.dto.Categories;
import com.shoppingcart.middlelayer.service.CategoriesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "shopping-cart-middle-layer")
public class CategoriesController {


    private final CategoriesService categoriesService;
    private final ShoppingCartOutputGenerator<List<Categories>> shoppingCartOutputGenerator;

    public CategoriesController(CategoriesService categoriesService,
                                ShoppingCartOutputGenerator<List<Categories>> shoppingCartOutputGenerator1) {
        this.categoriesService = categoriesService;
        this.shoppingCartOutputGenerator = shoppingCartOutputGenerator1;
    }

    @GetMapping(value = "get-all-categories")
    public ShoppingCartOutput<List<Categories>> getAllCategories() {
        List<Categories> categories = categoriesService.getAllCategories();
        return shoppingCartOutputGenerator.generateSuccessResponse(categories);
    }
}