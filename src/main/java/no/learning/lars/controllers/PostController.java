package no.learning.lars.controllers;

import no.learning.lars.entity.Post;
import no.learning.lars.services.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class PostController {

    private PostService postService;
    private static final Logger logger = LoggerFactory.getLogger(PostController.class);

    @Autowired // denne kan slettes og settes direkte på private variabelen
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
    public String savePost(@Valid Post post, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "postform";
        }
        postService.savePost(post);
        logger.debug("Saved posts with id: " + post.getId() + " to DB");
        return "redirect:/post/" + post.getId();
    }
}
