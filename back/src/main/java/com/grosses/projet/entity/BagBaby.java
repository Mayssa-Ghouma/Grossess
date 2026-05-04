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
@Table(name="BagBaby")
public class BagBaby {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean bonnet;
    private boolean pyjamas;
    private boolean chaussettes;
    private boolean tenueSortie;
    private boolean couches;
    private boolean lingettes;
    private boolean serviette;
    private boolean couverture;
    private boolean biberon;
    private boolean carnetSante;  

    @OneToOne
    @JoinColumn(name = "maman_id", unique = true)
    private FutureMaman maman;
}