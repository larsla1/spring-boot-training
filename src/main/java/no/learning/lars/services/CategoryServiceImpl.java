package no.learning.lars.services;

import no.learning.lars.entity.Category;
import no.learning.lars.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Lars on 19.04.2016.
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;

    @Autowired
    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Iterable<Category> listAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Integer id) {
        return categoryRepository.findOne(id);
    }

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }
}
