package no.learning.lars.services;

import no.learning.lars.entity.Post;

/**
 * PostService interface. Created to proxy the repository methods.
 * This was done for training purposes.
 */
public interface PostService {
    Iterable<Post> listAllPosts();

    Post getPostById(Integer id);

    Post savePost(Post post);
}
