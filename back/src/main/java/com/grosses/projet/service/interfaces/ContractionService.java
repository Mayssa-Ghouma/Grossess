package com.grosses.projet.service.interfaces;
import java.time.LocalDate;
import java.util.List;
import com.grosses.projet.entity.Contraction;
public interface ContractionService {
    Contraction saveContraction(Contraction contraction);
    List <Contraction> getContractionByMaman(Long mamanId, LocalDate date);
}