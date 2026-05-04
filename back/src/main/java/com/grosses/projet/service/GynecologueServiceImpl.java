package com.grosses.projet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grosses.projet.Repository.GynecologueRepository;
import com.grosses.projet.entity.Gynecologue;
import com.grosses.projet.service.interfaces.GynecologueService;

@Service
public class GynecologueServiceImpl implements GynecologueService {
    @Autowired
    GynecologueRepository gynecologueRepository;
    @Override
    public Gynecologue createGynecologue(Gynecologue gynecologue) {
        return gynecologueRepository.save(gynecologue);
    }


    @Override
    public List<Gynecologue> getAllGynecologues() {
        return gynecologueRepository.findAll();
    }



    

}
