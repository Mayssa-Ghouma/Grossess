package com.grosses.projet.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="BagMaman")
public class BagMaman {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean pyjama;
    private boolean soutiens;
    private boolean chaussettes;
    private boolean tenueSortie;
    private boolean brosse;
    private boolean deodorant;
    private boolean serviette;
    private boolean carte;
    private boolean dossier;
    private boolean telephone;

    @OneToOne
    @JoinColumn(name = "maman_id", unique = true)
    private FutureMaman maman;
}