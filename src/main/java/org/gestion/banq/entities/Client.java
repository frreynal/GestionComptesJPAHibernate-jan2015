package org.gestion.banq.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Collection;

@Data
@Entity // créé une entitée grace à la dépendendance hibernate-entiy-manager
@Table(name = "CLIENTS")
public class Client implements Serializable {

    @Id
    //    @GeneratedValue(strategy=GE)
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
