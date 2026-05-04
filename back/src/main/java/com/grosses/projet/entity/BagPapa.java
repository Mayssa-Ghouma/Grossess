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
@Table(name="BagPapa")
public class BagPapa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean carte;
    private boolean telephone;
    private boolean trousse;
    private boolean eau;
    private boolean argent;

    @OneToOne
    @JoinColumn(name = "maman_id", unique = true)
    private FutureMaman maman;
}