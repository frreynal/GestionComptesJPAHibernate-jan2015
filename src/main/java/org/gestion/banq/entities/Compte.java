package org.gestion.banq.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

public class Compte implements Serializable {

    private String codecompte;
    private Date dateCreation;
    private double solde;
    private Client client;
    private Employe employe;
    private Collection<Operation> operations;

    public Compte(String codecompte, Date dateCreation, double solde) {
        this.codecompte = codecompte;
        this.dateCreation = dateCreation;
        this.solde = solde;
    }

    public Compte() {
    }
}
