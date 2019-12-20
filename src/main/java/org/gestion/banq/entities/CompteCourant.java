package org.gestion.banq.entities;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Data
@Entity
@DiscriminatorValue("CC") //c'est la colonne discriminante de la classe mère, c'est le type de compte
// CC=CompteCourant
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
