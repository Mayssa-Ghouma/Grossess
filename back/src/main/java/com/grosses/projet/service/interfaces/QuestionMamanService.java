package com.grosses.projet.service.interfaces;

import java.util.List;

import com.grosses.projet.entity.QuestionMaman;

public interface QuestionMamanService {
    QuestionMaman save(QuestionMaman question);
    List<QuestionMaman> getByMaman(Long mamanId);

}
