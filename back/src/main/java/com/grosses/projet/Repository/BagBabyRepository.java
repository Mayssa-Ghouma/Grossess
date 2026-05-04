package com.grosses.projet.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grosses.projet.entity.BagBaby;
@Repository
public interface BagBabyRepository extends JpaRepository<BagBaby, Long>{
    BagBaby findByMamanId(Long mamanId);


}
