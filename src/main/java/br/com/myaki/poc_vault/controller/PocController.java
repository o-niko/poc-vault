package br.com.myaki.poc_vault.controller;

import br.com.myaki.poc_vault.service.PocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/decrypt") // Mapeia a URL
public class PocController {

    @Autowired
    PocService service;

    @PostMapping
    public ResponseEntity<String> decrypt(@RequestBody String textEncrypted) {
        String decryptedText = service.decrypt(textEncrypted);
        if (decryptedText.equals("error")) {
            return new ResponseEntity<>("Falha na descriptografia", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(decryptedText, HttpStatus.OK);
    }
}