package com.beom.vault.client.service.controller;

import com.beom.vault.client.service.configuration.VaultConfiguration;
import com.beom.vault.client.service.dal.dto.Secret;
import com.beom.vault.client.service.dal.dto.SecretsResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.support.VaultResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@RestController
@RequestMapping(path = "/v1.0/secrets")
public class VaultController {

    private final VaultConfiguration vaultConfiguration;

    public VaultController(VaultConfiguration vaultConfiguration) {
        this.vaultConfiguration = vaultConfiguration;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SecretsResponse> getSecrets() {
        log.debug("GET /secrets/");

        Secret userNameSecret = new Secret("user_name", this.vaultConfiguration.getUsername());
        Secret passwordSecret = new Secret("password", this.vaultConfiguration.getPassword());

        Set<Secret> secrets = new HashSet<>();
        secrets.add(userNameSecret);
        secrets.add(passwordSecret);

        return new ResponseEntity<>(new SecretsResponse(secrets), HttpStatus.OK);
    }

}
