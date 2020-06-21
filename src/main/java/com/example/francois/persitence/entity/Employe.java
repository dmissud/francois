package com.example.francois.persitence.entity;

import javax.persistence.*;

@Entity
public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String poste;

    @ManyToOne
    private Entreprise entreprise;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }

    @Override
    public String toString() {
        return "Employe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", poste='" + poste + '\'' +
                ", entreprise=" + entreprise +
                '}';
    }
}
