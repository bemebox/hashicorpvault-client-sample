package com.beom.vault.client.service.service;

import com.beom.vault.client.service.configuration.VaultKvConfigurationProperties;
import com.beom.vault.client.service.dal.dto.Secret;
import com.beom.vault.client.service.exception.NoDataFoundException;
import com.beom.vault.client.service.exception.NoDataKeyFoundException;
import com.beom.vault.client.service.exception.NoSecretsFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.support.VaultResponse;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Slf4j
@Service
public class VaultService {

    private final VaultTemplate vaultTemplate;
    private final VaultKvConfigurationProperties vaultKvConfigurationProperties;

    public VaultService(VaultTemplate vaultTemplate, VaultKvConfigurationProperties vaultKvConfigurationProperties) {
        this.vaultTemplate = vaultTemplate;
        this.vaultKvConfigurationProperties = vaultKvConfigurationProperties;
    }

    public Set<Secret> fetchSecrets() {

        String secretsPath = String.format("%s/data/%s",
                this.vaultKvConfigurationProperties.backend(),
                this.vaultKvConfigurationProperties.defaultContext());

        VaultResponse response = this.vaultTemplate.read(secretsPath);
        if (response != null && response.getData() != null) {
            Map<String, Object> data = response.getData();
            if(data == null){
                throw new NoDataFoundException("No data found in secrets response.");
            }

            // Access 'data' map
            Map<String, Object> secretData = (Map<String, Object>) data.get("data");

            if (secretData != null) {
                Set<Secret> secretDataList = new HashSet<>();
                for (Map.Entry<String, Object> entry : secretData.entrySet()) {
                    secretDataList.add(new Secret(entry.getKey(), entry.getValue().toString()));
                }
                return secretDataList;
            } else {
                throw new NoDataKeyFoundException("No 'data' key found in secrets response.");
            }
        } else {
            throw new NoSecretsFoundException("No secrets found!");
        }
    }
}

