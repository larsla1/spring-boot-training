package no.learning.lars.services;

import no.learning.lars.entity.Post;
import no.learning.lars.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.executable.ValidateOnExecution;

@Service
public class PostServiceImpl implements PostService {
    private PostRepository postRepository;

    @Autowired
    public void setPostRepository(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Iterable<Post> listAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post getPostById(Integer id) {
        return postRepository.findOne(id);
    }

    @ValidateOnExecution
    @Override
    public Post savePost(Post post) {
        return postRepository.save(post);
    }
}
