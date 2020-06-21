package com.example.francois.service.api;

import com.example.francois.common.SelfValidating;

import javax.validation.constraints.Size;

public interface IEntrepriseEnrollEmployesUsecase {
    void enroolEmployeInEntreprise(EnrollEmployeEntrepriseCmd enrollEmployeEntrepriseCmd) throws ExEntrepriseUnknow;

    class EnrollEmployeEntrepriseCmd extends SelfValidating<EnrollEmployeEntrepriseCmd> {

        @Size(min = 6, max = 64)
        private final String siret;

        @Size(min = 4, max = 64)
        private final String name;

        @Size(min = 1, max = 20)
        private final String poste;

        public EnrollEmployeEntrepriseCmd(
                String siret,
                String name,
                String poste) {
            this.siret = siret;
            this.name = name;
            this.poste = poste;
            this.validateSelf();
        }

        public String getPoste() {
            return poste;
        }

        public String getName() {
            return name;
        }

        public String getSiret() {
            return siret;
        }
    }
}
