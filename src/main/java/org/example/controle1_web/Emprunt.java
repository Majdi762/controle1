package org.example.controle1_web;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Emprunt {
    @Id @GeneratedValue
    private Long id;
    private Long clientId;
    private Long itemId; // peut être un CD, DVD ou Livre
    private LocalDate dateEmprunt;
    private LocalDate dateRetour;

    public Emprunt() {
    }

    public Emprunt(Long id, Long clientId, Long itemId, LocalDate dateEmprunt, LocalDate dateRetour) {
        this.id = id;
        this.clientId = clientId;
        this.itemId = itemId;
        this.dateEmprunt = dateEmprunt;
        this.dateRetour = dateRetour;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public LocalDate getDateEmprunt() {
        return dateEmprunt;
    }

    public void setDateEmprunt(LocalDate dateEmprunt) {
        this.dateEmprunt = dateEmprunt;
    }

    public LocalDate getDateRetour() {
        return dateRetour;
    }

    public void setDateRetour(LocalDate dateRetour) {
        this.dateRetour = dateRetour;
    }
}