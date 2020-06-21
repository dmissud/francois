package com.example.francois.service.impl;

import com.example.francois.persitence.dao.IDaoEntreprise;
import com.example.francois.persitence.entity.Employe;
import com.example.francois.persitence.entity.Entreprise;
import com.example.francois.service.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class EntrepriseManageService implements
        IEntrepriseAllEmployesUsecase,
        IEntrepriseCreateUsecase,
        IEntrepriseEnrollEmployesUsecase {

    @Autowired
    IDaoEntreprise daoEntreprise;

    @Override
    @Transactional(rollbackOn = {ExEntrepriseAllReadyExist.class})
    public void registerEntreprise(RegisterEntrepriseCmd registerEntrepriseCmd) throws ExEntrepriseAllReadyExist {
        Entreprise entreprise = new Entreprise();
        entreprise.setName(registerEntrepriseCmd.getName());
        entreprise.setSiret(registerEntrepriseCmd.getSiret());

        try {
            daoEntreprise.save(entreprise);
        } catch (RuntimeException ex) {
            throw new ExEntrepriseAllReadyExist(registerEntrepriseCmd.getName());
        }
    }

    @Override
    public void enroolEmployeInEntreprise(EnrollEmployeEntrepriseCmd enrollEmployeEntrepriseCmd) throws ExEntrepriseUnknow {
        Entreprise entreprise = daoEntreprise.findBySiret(enrollEmployeEntrepriseCmd.getSiret());
        if (entreprise == null) {
            throw new ExEntrepriseUnknow(enrollEmployeEntrepriseCmd.getSiret());
        }
        Employe employe = new Employe();
        employe.setName(enrollEmployeEntrepriseCmd.getName());
        employe.setPoste(enrollEmployeEntrepriseCmd.getPoste());
        employe.setEntreprise(entreprise);

        entreprise.getEmployeSet().add(employe);

        daoEntreprise.save(entreprise);
    }

    @Override
    public List<EmployeDesc> retrieveAllEmployesEntreprise(String siret) throws ExEntrepriseUnknow {
        Entreprise entreprise = daoEntreprise.findBySiret(siret);
        if (entreprise == null) {
            throw new ExEntrepriseUnknow(siret);
        }
        List <EmployeDesc> employeDescs = new ArrayList<>();
        for(Employe employe:entreprise.getEmployeSet()) {
            employeDescs.add(new EmployeDesc(employe.getName(), employe.getPoste(), entreprise.getName()));
        }

        return employeDescs;
    }
}
