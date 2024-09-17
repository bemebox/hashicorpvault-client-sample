package com.beom.vault.client.service.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.vault.authentication.TokenAuthentication;
import org.springframework.vault.client.VaultEndpoint;
import org.springframework.vault.core.VaultTemplate;

import java.net.URI;

@Slf4j
@Configuration
public class VaultConfiguration {

    private final VaultConfigurationProperties vaultConfigurationProperties;

    public VaultConfiguration(VaultConfigurationProperties vaultConfigurationProperties) {
        this.vaultConfigurationProperties = vaultConfigurationProperties;
    }

    @Bean
    public VaultTemplate vaultTemplate() {

        VaultEndpoint endpoint = VaultEndpoint.from(URI.create(this.vaultConfigurationProperties.uri()));
        TokenAuthentication authentication = new TokenAuthentication(this.vaultConfigurationProperties.token());

        return new VaultTemplate(endpoint, authentication);
    }
}