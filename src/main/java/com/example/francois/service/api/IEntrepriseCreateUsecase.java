package com.example.francois.service.api;

import com.example.francois.common.SelfValidating;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

public interface IEntrepriseCreateUsecase {
    void registerEntreprise(RegisterEntrepriseCmd registerEntrepriseCmd) throws ExEntrepriseAllReadyExist;

    class RegisterEntrepriseCmd extends SelfValidating<RegisterEntrepriseCmd> {

        @Size(min = 4, max = 64)
        private final String name;

        @Size(min = 6, max = 64)
        private final String siret;

        public RegisterEntrepriseCmd(
                String name,
                String siret) {
            this.name = name;
            this.siret = siret;
            this.validateSelf();
        }

        public String getName() {
            return name;
        }

        public String getSiret() {
            return siret;
        }
    }
}
