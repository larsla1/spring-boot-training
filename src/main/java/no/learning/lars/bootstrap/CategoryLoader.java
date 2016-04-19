package no.learning.lars.bootstrap;

import no.learning.lars.entity.Category;
import no.learning.lars.repositories.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by Lars on 19.04.2016.
 */
@Component
public class CategoryLoader implements ApplicationListener<ContextRefreshedEvent> {
    private CategoryRepository categoryRepository;

    private static final Logger logger = LoggerFactory.getLogger(CategoryLoader.class);

    @Autowired
    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Category c1 = new Category();
        c1.setName("accessories");
        categoryRepository.save(c1);
        logger.debug("Saved category: " + c1.getName());

        Category c2 = new Category();
        c2.setName("cloths");
        categoryRepository.save(c2);
        logger.debug("Saved category: " + c2.getName());

        Category c3 = new Category();
        c3.setName("hobbycraft");
        categoryRepository.save(c3);
        logger.debug("Saved category: " + c3.getName());

        Category c4 = new Category();
        c4.setName("hunting");
        categoryRepository.save(c4);
        logger.debug("Saved category: " + c4.getName());

        Category c5 = new Category();
        c5.setName("trash");
        categoryRepository.save(c5);
        logger.debug("Saved category: " + c5.getName());
    }
}
