package com.example.bibliotheque.service;

import com.example.bibliotheque.model.Abonnement;
import com.example.bibliotheque.repository.AbonnementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class AbonnementService {
    private final AbonnementRepository repository;

    public boolean verifierAbonnementValide(Integer adherentId) {
        return repository.isAbonnementValide(adherentId, LocalDate.now());
    }

    public Abonnement getAbonnementByAdherentId(Integer adherentId) {
        return repository.findByAdherentId(adherentId)
               .orElseThrow(() -> new RuntimeException("Aucun abonnement trouvé"));
    }

    public Abonnement creerAbonnement(Abonnement abonnement) {
        return repository.save(abonnement);
    }
}