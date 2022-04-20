package pl.coderslab.charity.service;

import pl.coderslab.charity.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> categories();

    void saveCategory(Category category);
}
