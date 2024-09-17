package com.beom.vault.client.service;

import com.beom.vault.client.service.configuration.VaultConfigurationProperties;
import com.beom.vault.client.service.configuration.VaultKvConfigurationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({VaultConfigurationProperties.class, VaultKvConfigurationProperties.class})
public class 	VaultClientServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(VaultClientServiceApplication.class, args);
	}
}
