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

import com.grosses.projet.entity.QuestionMaman;
import com.grosses.projet.service.interfaces.QuestionMamanService;

@RestController
@RequestMapping("/api/mamans/question")
@CrossOrigin("*")
public class QuestionMamanController {
    @Autowired
    QuestionMamanService service;

    @PostMapping
    public QuestionMaman createQuestion(@RequestBody QuestionMaman question) {
        return service.save(question);
    }

    @GetMapping("/maman/{mamanId}")
    public List<QuestionMaman> getQuestionsByMaman(@PathVariable Long mamanId) {
        return service.getByMaman(mamanId);
    }

}
