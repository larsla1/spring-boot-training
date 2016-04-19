package no.learning.lars.repositories;

import no.learning.lars.entity.Category;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Lars on 19.04.2016.
 */
public interface CategoryRepository extends CrudRepository<Category, Integer> {
}
