package no.learning.lars.services;

import no.learning.lars.entity.Category;

/**
 * Created by Lars on 19.04.2016.
 */
public interface CategoryService {
    Iterable<Category> listAllCategories();

    Category getCategoryById(Integer id);

    Category saveCategory(Category category);
}
