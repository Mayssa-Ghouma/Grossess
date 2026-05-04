package com.grosses.projet.service;
import com.grosses.projet.entity.Contraction;
import com.grosses.projet.service.interfaces.ContractionService;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grosses.projet.Repository.ContractionRepository;
@Service
public class ContractionServiceImpl implements ContractionService {
    @Autowired
    ContractionRepository contractionRepository;

    @Override
    public Contraction saveContraction(Contraction contraction) {
        return contractionRepository.save(contraction);
    }

    @Override
    public List<Contraction> getContractionByMaman(Long mamanId, LocalDate date) {
        return contractionRepository.findByMamanIdAndDateContraction(mamanId, date);
    }

}