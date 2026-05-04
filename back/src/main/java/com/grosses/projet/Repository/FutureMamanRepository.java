package com.grosses.projet.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grosses.projet.entity.FutureMaman;

@Repository
public interface FutureMamanRepository extends JpaRepository<FutureMaman, Long> {
    List <FutureMaman> findByEmail(String email);

}
