package com.grosses.projet.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "BirthPlan")
public class BirthPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean lumDouce;
    private boolean ballon;
    private boolean douche;
    private boolean peridurale;
    private boolean massage;
    private boolean respiration;
    private boolean PeauPeau;
    private boolean Papa;
    private boolean allaitement;
    private boolean Biberon;

    @OneToOne
    @JoinColumn(name = "maman_id", unique = true)
    private FutureMaman maman;

}
