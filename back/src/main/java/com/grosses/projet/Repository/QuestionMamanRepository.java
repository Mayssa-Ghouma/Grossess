package com.grosses.projet.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grosses.projet.entity.QuestionMaman;
@Repository
public interface QuestionMamanRepository extends JpaRepository<QuestionMaman, Long>{
    List<QuestionMaman> findByMamanId(Long mamanId);

}
