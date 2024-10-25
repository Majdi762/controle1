package org.example.controle1_web.beans;

import jakarta.ejb.Remote;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.example.controle1_web.CD;
import org.example.controle1_web.Emprunt;


import java.time.LocalDate;
import java.util.List;

@Stateless
@Remote(EmpruntService.class)
public class EmpruntServiceImpl implements EmpruntService {
    @PersistenceContext
    private EntityManager em;

    @Override
    public void emprunterCD(Long clientId, Long cdId) {
        // Trouver le CD par ID
        CD cd = em.find(CD.class, cdId);
        if (cd != null && cd.isDisponible()) {
            // Créer un nouvel emprunt
            Emprunt emprunt = new Emprunt();
            emprunt.setClientId(clientId);
            emprunt.setItemId(cdId);
            emprunt.setDateEmprunt(LocalDate.now());

            // Marquer le CD comme non disponible
            cd.setDisponible(false);

            // Persister l'emprunt et mettre à jour le CD
            em.persist(emprunt);
            em.merge(cd);
        } else {
            throw new RuntimeException("CD non disponible ou inexistant.");
        }
    }

    @Override
    public void retournerCD(Long clientId, Long cdId) {
        // Trouver l'emprunt correspondant
        TypedQuery<Emprunt> query = em.createQuery(
                "SELECT e FROM Emprunt e WHERE e.clientId = :clientId AND e.itemId = :cdId AND e.dateRetour IS NULL",
                Emprunt.class);
        query.setParameter("clientId", clientId);
        query.setParameter("cdId", cdId);
        Emprunt emprunt = query.getResultStream().findFirst().orElse(null);

        if (emprunt != null) {
            // Mettre à jour la date de retour de l'emprunt
            emprunt.setDateRetour(LocalDate.now());
            em.merge(emprunt);

            // Mettre à jour la disponibilité du CD
            CD cd = em.find(CD.class, cdId);
            if (cd != null) {
                cd.setDisponible(true);
                em.merge(cd);
            }
        } else {
            throw new RuntimeException("Emprunt non trouvé.");
        }
    }

    @Override
    public List<CD> listerCDsDisponibles() {
        // Logique pour lister les CDs disponibles
        return em.createQuery("SELECT c FROM CD c WHERE c.disponible = true", CD.class).getResultList();
    }
}
