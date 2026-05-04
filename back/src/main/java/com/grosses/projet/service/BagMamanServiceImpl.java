package com.grosses.projet.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grosses.projet.Repository.BagMamanRepository;
import com.grosses.projet.entity.BagMaman;
import com.grosses.projet.service.interfaces.BagMamanService;
@Service
public class BagMamanServiceImpl implements BagMamanService {
    @Autowired
    private BagMamanRepository bagMamanRepository;

    @Override
    public BagMaman saveBagMaman(BagMaman bagMaman) {
        return bagMamanRepository.save(bagMaman);
    }

    @Override
    public BagMaman getBagMamanByMaman(Long idMaman) {
        return bagMamanRepository.findByMamanId(idMaman);
    }

    @Override
    public BagMaman updateBagMaman(Long id, BagMaman bagMaman) {
        bagMaman.setId(id);
        return bagMamanRepository.save(bagMaman);
    }

}
