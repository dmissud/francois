package com.example.francois.persitence.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Entreprise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String siret;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Employe> employeSet;

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

    public String getSiret() {
        return siret;
    }

    public void setSiret(String siret) {
        this.siret = siret;
    }

    public Set<Employe> getEmployeSet() {
        return employeSet;
    }

    public void setEmployeSet(Set<Employe> employeSet) {
        this.employeSet = employeSet;
    }

    @Override
    public String toString() {
        return "Entreprise{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", employeSet=" + employeSet +
                '}';
    }
}
