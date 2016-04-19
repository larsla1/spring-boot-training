package no.learning.lars.repositories;

import no.learning.lars.entity.Post;
import org.springframework.data.repository.CrudRepository;

/**
 * Using CrudRepo since this app is mainly using CRUD functions.
 * JpaRepository could also be an option - provides flushing if needed at a later point
 * Spring Data JPA uses generics and reflection to generate the concrete implementation of the interface defined
 * The two classes that is needed here are the Entity class and the type of the id variable in the entity class.
 */
public interface PostRepository extends CrudRepository<Post, Integer>{
}
