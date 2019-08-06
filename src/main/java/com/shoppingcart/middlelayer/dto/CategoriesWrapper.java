package com.shoppingcart.middlelayer.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

@Component
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class CategoriesWrapper {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Category category;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Category> categories;

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private boolean isInserted;

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private boolean isUpdated;

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private boolean isDeleted;

    public boolean isDeleted() {
        return isDeleted;
    }

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public boolean isUpdated() {
        return isUpdated;
    }

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    public void setUpdated(boolean updated) {
        isUpdated = updated;
    }

    public boolean isInserted() {
        return isInserted;
    }

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    public void setInserted(boolean inserted) {
        isInserted = inserted;
    }

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
