package com.grosses.projet.Controller;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grosses.projet.entity.Contraction;
import com.grosses.projet.service.interfaces.ContractionService;

@RestController
@RequestMapping("/api/mamans/contraction")
@CrossOrigin("*")
public class ContractionController {
    @Autowired
    ContractionService service;

    @PostMapping
    public Contraction addContraction(@RequestBody Contraction contraction) {
        return service.saveContraction(contraction);
    }

    @GetMapping("/{mamanId}")
    public List<Contraction> getTodayContractions(@PathVariable Long mamanId) {
        return service.getContractionByMaman(mamanId,LocalDate.now());
    }

    @GetMapping("/alert/{mamanId}")
    public String checkAlert(@PathVariable Long mamanId) {

        List<Contraction> contractions =
                service.getContractionByMaman(mamanId, LocalDate.now());

        LocalDateTime now = LocalDateTime.now();

        long count = contractions.stream()
                .filter(c ->
                        c.getDebut() != null &&
                        c.getDebut().isAfter(now.minusMinutes(15))
                )
                .count();

        if (count >= 2) {
            return "contractions rapprochées ! Allez à l'hôpital.";
        }

        return " pas d'alerte pour le moment";
    }




}
