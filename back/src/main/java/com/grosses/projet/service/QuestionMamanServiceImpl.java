package com.grosses.projet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grosses.projet.Repository.QuestionMamanRepository;
import com.grosses.projet.entity.QuestionMaman;
import com.grosses.projet.service.interfaces.QuestionMamanService;
@Service
public class QuestionMamanServiceImpl implements QuestionMamanService{
    @Autowired
    QuestionMamanRepository questionMamanRepository;
    @Override
    public QuestionMaman save(QuestionMaman question) {
        return questionMamanRepository.save(question);
    }

    @Override
    public List<QuestionMaman> getByMaman(Long mamanId) {
        return questionMamanRepository.findByMamanId(mamanId);
    }

}
