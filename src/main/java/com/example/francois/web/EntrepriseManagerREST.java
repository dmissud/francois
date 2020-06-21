package com.example.francois.web;

import com.example.francois.service.api.*;
import com.example.francois.service.api.IEntrepriseCreateUsecase.RegisterEntrepriseCmd;
import com.example.francois.service.api.IEntrepriseEnrollEmployesUsecase.EnrollEmployeEntrepriseCmd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/Entreprise")
public class EntrepriseManagerREST {

    @Autowired
    private IEntrepriseCreateUsecase entrepriseCreateUsecase;

    @Autowired
    private IEntrepriseEnrollEmployesUsecase entrepriseEnrollEmployesUsecase;

    @Autowired
    private IEntrepriseAllEmployesUsecase entrepriseAllEmployesUsecase;

    @PostMapping("/Create")
    public ResponseEntity<Void> createEntrerise(@RequestBody RegisterEntrepriseCmd registerEntrepriseCmd) {
        try {
            entrepriseCreateUsecase.registerEntreprise(registerEntrepriseCmd);
            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{userName}")
                    .buildAndExpand(registerEntrepriseCmd.getName())
                    .toUri();

            return ResponseEntity.created(location).build();
        } catch (ExEntrepriseAllReadyExist exEntrepriseAllReadyExist) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @PostMapping("/Enroll")
    public ResponseEntity<Void> enrollEmployeInEntrerise(@RequestBody EnrollEmployeEntrepriseCmd enrollEmployeEntrepriseCmd) {
        try {
            entrepriseEnrollEmployesUsecase.enroolEmployeInEntreprise(enrollEmployeEntrepriseCmd);
            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{userName}")
                    .buildAndExpand(enrollEmployeEntrepriseCmd.getName())
                    .toUri();

            return ResponseEntity.created(location).build();
        } catch (ExEntrepriseUnknow exEntrepriseUnknow) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @GetMapping("/AllEmploye/{siret}")
    public ResponseEntity<List<EmployeDesc>> retrieveAllEmployeInEntrerise(@PathVariable("siret") String siret) {
        try {
            List<EmployeDesc> lstDesc = entrepriseAllEmployesUsecase.retrieveAllEmployesEntreprise(siret);
            return new ResponseEntity<>(lstDesc, HttpStatus.OK);
        } catch (ExEntrepriseUnknow exEntrepriseUnknow) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}
