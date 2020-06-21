package com.example.francois.service.api;

public class EmployeDesc {
    private final String nom;
    private final String poste;
    private final String nomEntreprise;

    public EmployeDesc(String nom, String poste, String nomEntreprise) {
        this.nom = nom;
        this.poste = poste;
        this.nomEntreprise = nomEntreprise;
    }

    public String getNom() {
        return nom;
    }

    public String getPoste() {
        return poste;
    }

    public String getNomEntreprise() {
        return nomEntreprise;
    }

    @Override
    public String toString() {
        return "EmployeDesc{" +
                "nom='" + nom + '\'' +
                ", poste='" + poste + '\'' +
                ", nomEntreprise='" + nomEntreprise + '\'' +
                '}';
    }
}
