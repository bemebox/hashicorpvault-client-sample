package com.beom.vault.client.service.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("spring.cloud.vault")
public record VaultConfigurationProperties(
        String token,
        String uri,
        String kvBackend) { }
