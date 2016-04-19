package no.learning.lars.controllers;

import no.learning.lars.entity.Post;
import no.learning.lars.services.PostService;
import no.learning.lars.validator.PostValidator;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Lars on 17.04.2016.
 */

@Controller
public class PostController {

    private PostService postService;
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(PostController.class);

    @Autowired
    public void setPostService(PostService postService) {
        this.postService = postService;
    }


    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("posts", postService.listAllPosts());
        logger.debug("Fetching all posts from the DB");
        return "posts";
    }

    @RequestMapping(value = "post/{id}", method = RequestMethod.GET)
    public String showPost(@PathVariable Integer id, Model model) {
        model.addAttribute("post", postService.getPostById(id));
        logger.debug("Fetching posts with id: " + id + " from the DB");
        return "postshow";
    }

    @RequestMapping("post/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("post", postService.getPostById(id));
        logger.debug("Fetching posts with id: " + id + " for editing");
        return "postform";
    }

    @RequestMapping("post/new")
    public String newPost(Model model) {
        model.addAttribute("post", new Post());
        return "postform";
    }

    @RequestMapping(value = "post", method = RequestMethod.POST)
    public String savePost(Post post) {
        postService.savePost(post);
        logger.debug("Saved posts with id: " + post.getId() + " to DB");
        return "redirect:/post/" + post.getId();
    }
}
