package com.shoppingcart.middlelayer.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoriesWrapper {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Category category;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Category> categories;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
