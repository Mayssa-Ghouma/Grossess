package com.grosses.projet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.grosses.projet.entity.BagPapa;
@Repository
public interface BagPapaRepository extends JpaRepository<BagPapa, Long>{
        BagPapa findByMamanId(Long mamanId);

}
