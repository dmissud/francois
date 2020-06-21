package com.example.francois.service.api;

public class ExEntrepriseAllReadyExist extends Exception {
    String entrepriseName;

    public ExEntrepriseAllReadyExist(String entrepriseName) {
        super("Entreprise Allready exist :"+entrepriseName);
        this.entrepriseName = entrepriseName;
    }
}
