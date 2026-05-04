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

import com.grosses.projet.entity.CommentaireGyneco;
import com.grosses.projet.service.interfaces.CommentaireGynecoService;

@RestController
@RequestMapping("/api/mamans/question/commentaire")
@CrossOrigin("*")
public class CommentaireGynecoController {
    @Autowired
    CommentaireGynecoService service;

    @PostMapping
    public CommentaireGyneco addCommentaire(@RequestBody CommentaireGyneco commentaire) {
        return service.save(commentaire);
    }

    @GetMapping("/{idQuestion}")
    public List<CommentaireGyneco> getCommentaireByQuestion(@PathVariable Long idQuestion) {
        return service.findById(idQuestion);
    }

}
