package com.grosses.projet.entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "FutureMaman")
public class FutureMaman {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomComplet;
    private String email;
    private String motDePasse;

    private LocalDate dateAccouchementPrevue;
    private Integer moisGrossesse;

    private boolean emailVerifie = false;

    @OneToMany(mappedBy = "maman", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Contraction> contractions;
    
    @JsonBackReference
    @OneToOne(mappedBy = "maman", cascade = CascadeType.ALL)
    @JsonIgnore
    private BirthPlan birthPlan;

    @OneToOne(mappedBy = "maman", cascade = CascadeType.ALL)
    @JsonIgnore
    private BagMaman bagMaman;

    @OneToOne(mappedBy = "maman", cascade = CascadeType.ALL)
    @JsonIgnore
    private BagBaby bagBaby;

    @OneToOne(mappedBy = "maman", cascade = CascadeType.ALL)
    @JsonIgnore
    private BagPapa bagPapa;

}
