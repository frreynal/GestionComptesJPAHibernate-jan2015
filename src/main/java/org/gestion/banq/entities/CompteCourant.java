package org.gestion.banq.entities;

import java.util.Date;

public class CompteCourant extends Compte {

    private double decouvert;

    public CompteCourant(String codecompte, Date dateCreation, double solde, double decouvert) {
        super(codecompte, dateCreation, solde);
        this.decouvert = decouvert;
    }

    public CompteCourant() {
        super();
    }
}
