package br.com.myaki.poc_vault.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.vault.core.VaultTemplate;

import java.util.Objects;

@Slf4j
@Service
@AllArgsConstructor
public class PocService {

    private  VaultTemplate vaultTemplate;
    private  Environment env;


    public String decrypt(final String textEncrypted) {
            try {
                if (Objects.isNull(textEncrypted)) return "";
                return vaultTemplate.opsForTransit(getKeyPath()).decrypt(getKeyName(), textEncrypted);
            } catch (RuntimeException ex) {
                log.error("Error trying to decrypt string");
                return "";
            }
    }


    private String getKeyName() {
        return Objects.requireNonNullElse(env.getProperty("vault.key.name"), "");
    }

    private String getKeyPath() {
        return Objects.requireNonNullElse(env.getProperty("vault.key.path"), "");
    }
}
