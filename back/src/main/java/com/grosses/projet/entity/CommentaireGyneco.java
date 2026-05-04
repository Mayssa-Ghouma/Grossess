package com.grosses.projet.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CommentaireGyneco")
public class CommentaireGyneco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String commentaire;
    private LocalDateTime dateCommentaire;

    @ManyToOne
    @JoinColumn(name = "Gynecologue_id")
    private Gynecologue gynecologue;

    @ManyToOne
    @JoinColumn(name = "QuestionMaman_id")
    private QuestionMaman question;



}
