package org.example.controle1_web.beans;

import jakarta.ejb.Remote;
import org.example.controle1_web.CD;
import org.example.controle1_web.Emprunt;

import java.util.List;

@Remote
public interface GestionCDService {
    void ajouterCD(CD cd);
    void modifierCD(CD cd);
    void supprimerCD(Long cdId);
    List<Emprunt> consulterEmprunts();
}
