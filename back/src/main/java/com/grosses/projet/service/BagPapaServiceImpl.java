package com.grosses.projet.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grosses.projet.Repository.BagPapaRepository;
import com.grosses.projet.entity.BagPapa;
import com.grosses.projet.service.interfaces.BagPapaService;

@Service
public class BagPapaServiceImpl implements BagPapaService {
    @Autowired
    private BagPapaRepository bagPapaRepository;

    @Override
    public BagPapa saveBagPapa(BagPapa bagPapa) {
        return bagPapaRepository.save(bagPapa);
    }

    @Override
    public BagPapa getBagPapaByMaman(Long idMaman) {
        return bagPapaRepository.findByMamanId(idMaman);
    }

    @Override
    public BagPapa updateBagPapa(Long id, BagPapa bagPapa) {
        bagPapa.setId(id);
        return bagPapaRepository.save(bagPapa);
    }

}
