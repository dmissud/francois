package com.example.francois.service.api;

public class ExEntrepriseUnknow extends Exception {
    String entrepriseName;

    public ExEntrepriseUnknow(String entrepriseName) {
        super("Entreprise Unknow :"+entrepriseName);
        this.entrepriseName = entrepriseName;
    }
}
