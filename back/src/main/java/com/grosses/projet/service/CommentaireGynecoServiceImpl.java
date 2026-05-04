package com.grosses.projet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grosses.projet.Repository.CommentaireGynecoRepository;
import com.grosses.projet.entity.CommentaireGyneco;
import com.grosses.projet.service.interfaces.CommentaireGynecoService;

@Service
public class CommentaireGynecoServiceImpl implements CommentaireGynecoService {
    @Autowired
    CommentaireGynecoRepository commentaireGynecoRepository;

    @Override
    public CommentaireGyneco save(CommentaireGyneco commentaireGyneco) {
        return commentaireGynecoRepository.save(commentaireGyneco);
    }

    @Override
    public List<CommentaireGyneco> findById(Long idQuestion) {
        return commentaireGynecoRepository.findByQuestionId(idQuestion);
    }
    

}
