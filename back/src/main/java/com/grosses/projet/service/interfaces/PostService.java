package com.grosses.projet.service.interfaces;

import java.util.List;

import com.grosses.projet.entity.Post;
import com.grosses.projet.entity.TypePost;

public interface PostService {

    Post save(Post post);
    List<Post> findByTypePost(TypePost type);
    List<Post> findAll();
    

}
