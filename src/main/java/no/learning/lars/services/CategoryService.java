package no.learning.lars.services;

import no.learning.lars.entity.Category;

public interface CategoryService {
    Iterable<Category> listAllCategories();

    Category getCategoryById(Integer id);

    Category saveCategory(Category category);
}
