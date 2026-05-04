package com.grosses.projet.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "QuestionMaman")
public class QuestionMaman {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String question;
    private LocalDateTime dateQuestion;

    @ManyToOne
    @JoinColumn(name = "FutureMaman_id")
    private FutureMaman maman;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<CommentaireGyneco> commentaires;

}
