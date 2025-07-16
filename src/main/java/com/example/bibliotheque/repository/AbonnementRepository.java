package com.example.bibliotheque.repository;

import com.example.bibliotheque.model.Abonnement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Optional;

public interface AbonnementRepository extends JpaRepository<Abonnement, Integer> {

    // Trouver l'abonnement par ID d'adhérent
    @Query("SELECT a FROM Abonnement a WHERE a.adherent.id = :adherentId")
    Optional<Abonnement> findByAdherentId(@Param("adherentId") Integer adherentId);

    // Vérifier si un adhérent a un abonnement valide à une date donnée
    @Query("SELECT CASE WHEN COUNT(a) > 0 THEN true ELSE false END " +
           "FROM Abonnement a WHERE a.adherent.id = :adherentId " +
           "AND a.estValide = true " +
           "AND :date BETWEEN a.dateDebut AND a.dateFin")
    boolean isAbonnementValide(@Param("adherentId") Integer adherentId, 
                             @Param("date") LocalDate date);
}