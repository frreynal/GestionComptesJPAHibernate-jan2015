package org.gestion.banq.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Data
@Entity // créé une entitée grace à la dépendendance hibernate-entiy-manager
@Table(name = "CLIENTS")
public class Client implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // identity : "1+1"
    @Column(name = "CODE_CLI") /// par défaut Spring prend le nom de la colonne comme le nom de l'attribut
    private Long codeClient;
    private String nomClient;
    private String adresseClient;
    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    // la "clé étrangère" du Compte est l'attribut client de la classe
    // par défaut le type de fetche est LAZy donc pas obligé de le mettre
    // Compte
    private Collection<Compte> comptes;
    
    public Client(String nomClient, String adresseClient) {
        this.nomClient = nomClient;
        this.adresseClient = adresseClient;
    }
    
    public Client() {
    }
}
