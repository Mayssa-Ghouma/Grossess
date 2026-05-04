package com.grosses.projet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grosses.projet.Repository.FutureMamanRepository;
import com.grosses.projet.entity.FutureMaman;
import com.grosses.projet.service.interfaces.FutureMamanService;

@Service
public class FutureMamanServiceImpl implements FutureMamanService {
    @Autowired
    FutureMamanRepository fmRepo;
    @Override
    public FutureMaman createFutureMaman(FutureMaman futureMaman) {
        return fmRepo.save(futureMaman);
    }

    @Override
    public List<FutureMaman> getAllFutureMamans() {
        return fmRepo.findAll();
    }
    
    @Override
    public void deleteFutureMaman(Long id) {
        fmRepo.deleteById(id);
    }

    @Override
    public FutureMaman getFutureMamanById(Long id) {
        fmRepo.findById(id);
        throw new UnsupportedOperationException("Unimplemented method 'getFutureMamanById'");
    }

}
