package org.gestion.banq.entities;

import lombok.Data;

import java.io.Serializable;
import java.util.Collection;

@Data
public class Client implements Serializable {

    private Long codeClient;
    private String nomClient;
    private String adresseClient;
    private Collection<Compte> comptes;

    public Client(String nomClient, String adresseClient) {
        this.nomClient = nomClient;
        this.adresseClient = adresseClient;
    }

    public Client() {
    }
}
