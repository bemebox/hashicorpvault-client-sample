package com.beom.vault.client.service.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("spring.cloud.vault.kv")
public record VaultKvConfigurationProperties (
        String backend,
        String defaultContext) { }
