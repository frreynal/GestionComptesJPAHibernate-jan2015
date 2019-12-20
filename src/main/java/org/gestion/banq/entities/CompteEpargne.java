package org.gestion.banq.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DiscriminatorValue("CE") //c'est la colonne discriminante de la classe mère, c'est le type de compte
// CC=CompteEpargne
public class CompteEpargne extends Compte {
    
    private double taux;
}
