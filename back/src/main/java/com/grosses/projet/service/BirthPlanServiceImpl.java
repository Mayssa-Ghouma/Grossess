package com.grosses.projet.service;
import com.grosses.projet.service.interfaces.BirthPlanService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grosses.projet.Repository.BirthPlanRepository;
import com.grosses.projet.entity.BirthPlan;

@Service
public class BirthPlanServiceImpl implements BirthPlanService{
    @Autowired
    BirthPlanRepository birthPlanRepository;
    @Override
    public BirthPlan saveBirthPlan(BirthPlan birthPlan) {
        return birthPlanRepository.save(birthPlan);
    }

    @Override
    public BirthPlan getBirthPlanByMaman(Long idMaman) { 
        return birthPlanRepository.findByMamanId(idMaman);
    }

    @Override
    public BirthPlan updateBirthPlan(Long id, BirthPlan birthPlan) {
        birthPlan.setId(id);
        return birthPlanRepository.save(birthPlan);
    }

}
