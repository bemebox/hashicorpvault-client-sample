package com.beom.vault.client.service.dal.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Set;

public record SecretsResponse(
        @JsonProperty("addresses")
        Set<Secret> secrets) {
}
