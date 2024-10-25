package org.example.controle1_web;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class CD {
    @Id @GeneratedValue
    private Long id;
    private String titre;
    private String artiste;
    private int annee;
    private boolean disponible;

    public CD() {
    }

    public CD(Long id, String titre, String artiste, int annee, boolean disponible) {
        this.id = id;
        this.titre = titre;
        this.artiste = artiste;
        this.annee = annee;
        this.disponible = disponible;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getArtiste() {
        return artiste;
    }

    public void setArtiste(String artiste) {
        this.artiste = artiste;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}
