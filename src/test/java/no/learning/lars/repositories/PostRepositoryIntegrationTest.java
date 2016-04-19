package no.learning.lars.repositories;

import no.learning.lars.config.RepositoryConfig;
import no.learning.lars.entity.Post;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Integration test of the post repository
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {RepositoryConfig.class})
public class PostRepositoryIntegrationTest {
    private PostRepository postRepository;

    @Autowired
    public void setPostRepository(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Test
    public void testSavePost() {
        Post post = new Post();
        post.setTopic("My test topic");
        post.setPrice(1337);
        post.setDescription("These are not the droids you are looking for!");
        post.setCategory("Diverse");
        post.setImgUrl("http://test.no/lightsaber");

        assertNull(post.getId());
        postRepository.save(post);
        assertNotNull(post.getId());

        Post DBPost = postRepository.findOne(post.getId());
        assertNotNull(DBPost);
        assertEquals(post.getId(), DBPost.getId());
    }

    @Test
    public void testUpdatePost() {
        Post post = new Post();
        post.setTopic("My test second topic");
        post.setPrice(46);
        post.setDescription("These are not the droids you are looking for!");
        post.setCategory("Diverse");
        post.setImgUrl("http://test.no/spaceship");
        postRepository.save(post);

        Post DBPost = postRepository.findOne(post.getId());
        DBPost.setTopic("New test topic");
        DBPost.setDescription("Time is an illusion. Lunchtime doubly so");
        DBPost.setPrice(42);
        postRepository.save(DBPost);

        Post updatedPost = postRepository.findOne(DBPost.getId());
        assertEquals(DBPost.getTopic(), updatedPost.getTopic());
        assertEquals(DBPost.getDescription(), updatedPost.getDescription());
        assertEquals(DBPost.getPrice(), updatedPost.getPrice());
    }

    @Test
    public void testRepositoryCountAndFindAll() {
        long postCount = postRepository.count();
        assertEquals(postCount, 2);

        Iterable<Post> posts = postRepository.findAll();
        int count = 0;
        for(Post p : posts) {
            count++;
        }
        assertEquals(count, 2);
    }


}
