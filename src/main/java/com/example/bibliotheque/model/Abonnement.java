package com.example.bibliotheque.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
public class Abonnement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_adherent", nullable = false)
    private Adherent adherent;

    private LocalDate dateDebut;
    private LocalDate dateFin;
    
    @Column(columnDefinition = "BOOLEAN DEFAULT TRUE")
    private Boolean estValide;
}