package com.beom.vault.client.service.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.vault.annotation.VaultPropertySource;

@Configuration
@Getter
@Setter
@VaultPropertySource(value = "secret/data/demo", propertyNamePrefix = "myapp" )
public class VaultConfiguration {

    @Value("${myapp.username}")
    private String username;

    @Value("${myapp.password}")
    private String password;
}