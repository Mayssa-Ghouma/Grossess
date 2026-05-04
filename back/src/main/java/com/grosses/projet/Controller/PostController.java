package com.grosses.projet.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grosses.projet.entity.Post;
import com.grosses.projet.entity.TypePost;
import com.grosses.projet.service.interfaces.PostService;

@RestController
@RequestMapping("/api/mamans/post")
@CrossOrigin("*")
public class PostController {
    @Autowired
    private PostService service;

    @PostMapping
    public Post createPost(@RequestBody Post post) {
        return service.save(post);
    }

    @GetMapping("/{type}")
    public List<Post> getPostsByType(@PathVariable TypePost type) {
        return service.findByTypePost(type);
    }
    @GetMapping
    public List<Post> getAllPosts() {
        return service.findAll();
    }

}
