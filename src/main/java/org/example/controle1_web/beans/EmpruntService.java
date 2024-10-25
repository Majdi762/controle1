package org.example.controle1_web.beans;

import jakarta.ejb.Remote;
import org.example.controle1_web.CD;

import java.util.List;

@Remote
public interface EmpruntService {
    void emprunterCD(Long clientId, Long cdId);
    void retournerCD(Long clientId, Long cdId);
    List<CD> listerCDsDisponibles();
}
