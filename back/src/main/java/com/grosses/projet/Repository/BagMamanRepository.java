package com.grosses.projet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.grosses.projet.entity.BagMaman;
@Repository
public interface BagMamanRepository extends JpaRepository<BagMaman, Long>{
        BagMaman findByMamanId(Long mamanId);

}
