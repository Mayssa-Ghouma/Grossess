package com.grosses.projet.service.interfaces;

import com.grosses.projet.entity.BirthPlan;

public interface BirthPlanService {
    BirthPlan saveBirthPlan(BirthPlan birthPlan);
    BirthPlan getBirthPlanByMaman(Long idMaman);
    BirthPlan updateBirthPlan(Long id, BirthPlan birthPlan);

}
