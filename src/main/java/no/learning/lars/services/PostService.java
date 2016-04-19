package no.learning.lars.services;

import no.learning.lars.entity.Post;

/**
 *
 */
public interface PostService {
    Iterable<Post> listAllPosts();

    Post getPostById(Integer id);

    Post savePost(Post post);
}
