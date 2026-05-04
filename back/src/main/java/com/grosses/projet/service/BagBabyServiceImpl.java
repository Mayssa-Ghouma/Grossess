package com.grosses.projet.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grosses.projet.Repository.BagBabyRepository;
import com.grosses.projet.Repository.FutureMamanRepository;
import com.grosses.projet.entity.BagBaby;
import com.grosses.projet.entity.FutureMaman;
import com.grosses.projet.service.interfaces.BagBabyService;
@Service
public class BagBabyServiceImpl implements BagBabyService {
    @Autowired
    private BagBabyRepository bagBabyRepository;
    @Autowired
    private FutureMamanRepository futureMamanRepository;

    @Override
    public BagBaby saveBagBaby(BagBaby bagBaby) {
        // Charge la vraie entité maman depuis la BD
    if (bagBaby.getMaman() != null && bagBaby.getMaman().getId() != null) {
        FutureMaman maman;
        try {
            maman = (FutureMaman) futureMamanRepository.findById(bagBaby.getMaman().getId())
                    .orElseThrow(() -> new RuntimeException("Maman non trouvée avec id: " + bagBaby.getMaman().getId()));
            bagBaby.setMaman(maman);
        } catch (Throwable ex) {
            System.getLogger(BagBabyServiceImpl.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
    return bagBabyRepository.save(bagBaby);
    }

    @Override
    public BagBaby getBagBabyByMaman(Long idMaman) {
        return bagBabyRepository.findByMamanId(idMaman);
    }

    @Override
    public BagBaby updateBagBaby(Long id, BagBaby bagBaby) {
        bagBaby.setId(id);
        return bagBabyRepository.save(bagBaby);
    }

}
