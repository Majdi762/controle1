package org.example.controle1_web;

import jakarta.persistence.*;

@Entity
public class DVD {
    @Id @GeneratedValue
    private Long id;
    private String titre;
    private String realisateur;
    private int annee;

    public DVD() {
    }

    public DVD(Long id, String titre, String realisateur, int annee) {
        this.id = id;
        this.titre = titre;
        this.realisateur = realisateur;
        this.annee = annee;
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

    public String getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(String realisateur) {
        this.realisateur = realisateur;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }
}