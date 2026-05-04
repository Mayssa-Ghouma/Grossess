package com.grosses.projet.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grosses.projet.Repository.PostRepository;
import com.grosses.projet.entity.Post;
import com.grosses.projet.entity.TypePost;
import com.grosses.projet.service.interfaces.PostService;
@Service
public class PosteServiceImpl implements PostService{
    @Autowired
    PostRepository postRepository;
    @Override
    public Post save(Post post) {
        return postRepository.save(post);
    }

    @Override
    public  List<Post> findByTypePost(TypePost type) {
        return postRepository.findByType(type);}
    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }
}
