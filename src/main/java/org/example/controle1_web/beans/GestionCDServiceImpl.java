package org.example.controle1_web.beans;

import jakarta.ejb.Remote;
import jakarta.ejb.Stateful;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.controle1_web.CD;
import org.example.controle1_web.Emprunt;

import java.util.List;

@Stateful
@Remote(GestionCDService.class)
public class GestionCDServiceImpl implements GestionCDService {
    @PersistenceContext
    private EntityManager em;

    @Override
    public void ajouterCD(CD cd) {
        em.persist(cd);
    }

    @Override
    public void modifierCD(CD cd) {
        em.merge(cd);
    }

    @Override
    public void supprimerCD(Long cdId) {
        CD cd = em.find(CD.class, cdId);
        if (cd != null) {
            em.remove(cd);
        }
    }

    @Override
    public List<Emprunt> consulterEmprunts() {
        return em.createQuery("SELECT e FROM Emprunt e", Emprunt.class).getResultList();
    }
}
