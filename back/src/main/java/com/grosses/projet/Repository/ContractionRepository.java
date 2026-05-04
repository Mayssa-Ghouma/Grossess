package com.grosses.projet.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grosses.projet.entity.Contraction;
@Repository
public interface ContractionRepository extends JpaRepository<Contraction, Long> {
    List<Contraction> findByMamanIdAndDateContraction(Long mamanId, LocalDate date);

}
