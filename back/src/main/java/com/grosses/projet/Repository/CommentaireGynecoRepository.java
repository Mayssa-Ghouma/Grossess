package com.grosses.projet.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grosses.projet.entity.CommentaireGyneco;
@Repository
public interface CommentaireGynecoRepository extends JpaRepository<CommentaireGyneco, Long>{
    List<CommentaireGyneco> findByQuestionId(Long questionId);
}
