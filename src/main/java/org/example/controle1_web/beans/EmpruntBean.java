package org.example.controle1_web.beans;


import jakarta.annotation.ManagedBean;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import org.example.controle1_web.CD;

import java.util.List;


@ManagedBean
@RequestScoped
public class EmpruntBean {
    @EJB
    private EmpruntService empruntService;

    private List<CD> cdsDisponibles;

    public List<CD> getCdsDisponibles() {
        if (cdsDisponibles == null) {
            cdsDisponibles = empruntService.listerCDsDisponibles();
        }
        return cdsDisponibles;
    }

    public void emprunterCD(Long cdId) {
        // Utilisez un ID fictif pour le client pour cet exemple
        Long clientId = 1L;
        empruntService.emprunterCD(clientId, cdId);

        // Recharger la liste des CDs disponibles après emprunt
        cdsDisponibles = empruntService.listerCDsDisponibles();
    }
}
