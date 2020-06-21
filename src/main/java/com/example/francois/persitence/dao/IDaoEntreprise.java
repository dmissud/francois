package com.example.francois.persitence.dao;

import com.example.francois.persitence.entity.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDaoEntreprise extends JpaRepository<Entreprise, Long>  {
    Entreprise findBySiret(String siret);
}
