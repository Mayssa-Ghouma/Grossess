package com.grosses.projet.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grosses.projet.entity.Post;
import com.grosses.projet.entity.TypePost;
@Repository
public interface PostRepository extends JpaRepository<Post, Long>{
    List<Post> findByType(TypePost type);

}
