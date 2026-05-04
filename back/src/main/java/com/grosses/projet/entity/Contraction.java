package com.grosses.projet.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Contraction")
public class Contraction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime debut;
    private LocalDateTime fin;
    private long dureeSecondes;
    private LocalDate dateContraction;


    @ManyToOne
    @JoinColumn(name = "FutureMaman_id")
    @JsonIgnoreProperties({"contractions", "bagBaby", "bagMaman", "bagPapa", "birthPlan", "emailVerifie", "motDePasse", "dateAccouchementPrevue", "moisGrossesse", "email", "nomComplet"})
    private FutureMaman maman;

    @PrePersist
    public void prePersist() {
    if (this.debut != null) {
        this.dateContraction = this.debut.toLocalDate();
    }
}


}
