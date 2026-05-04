package com.grosses.projet.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grosses.projet.entity.Gynecologue;
@Repository
public interface GynecologueRepository extends JpaRepository<Gynecologue, Long>{
    List <Gynecologue> findByEmail(String email);
    Optional findById(Long id);

}
