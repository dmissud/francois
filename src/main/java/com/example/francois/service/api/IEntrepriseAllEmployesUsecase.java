package com.example.francois.service.api;

import java.util.List;

public interface IEntrepriseAllEmployesUsecase {
    List<EmployeDesc> retrieveAllEmployesEntreprise(String siret) throws ExEntrepriseUnknow;
}
