package com.beom.vault.client.service.controller;

import com.beom.vault.client.service.dal.dto.Secret;
import com.beom.vault.client.service.dal.dto.SecretsResponse;
import com.beom.vault.client.service.service.VaultService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@Slf4j
@RestController
@RequestMapping(path = "/v1.0/secrets")
public class VaultController {

    private final VaultService vaultService;

    public VaultController(VaultService vaultService) {
        this.vaultService = vaultService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SecretsResponse> getSecrets() {
        log.debug("GET /secrets/");
        Set<Secret> secrets = this.vaultService.fetchSecrets();
        return new ResponseEntity<>(new SecretsResponse(secrets), HttpStatus.OK);
    }

}
