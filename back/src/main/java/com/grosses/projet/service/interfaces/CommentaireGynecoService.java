package com.grosses.projet.service.interfaces;

import java.util.List;

import com.grosses.projet.entity.CommentaireGyneco;

public interface CommentaireGynecoService {
    CommentaireGyneco save(CommentaireGyneco commentaireGyneco);
    List<CommentaireGyneco> findById(Long idQuestion);
    

}
