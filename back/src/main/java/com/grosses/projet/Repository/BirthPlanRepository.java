package com.grosses.projet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grosses.projet.entity.BirthPlan;
@Repository
public interface BirthPlanRepository extends JpaRepository<BirthPlan, Long>{
        BirthPlan findByMamanId(Long mamanId);

}
