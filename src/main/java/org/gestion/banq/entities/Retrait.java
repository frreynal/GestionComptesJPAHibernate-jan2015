package org.gestion.banq.entities;

import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@NoArgsConstructor
@Entity
@DiscriminatorValue(value = " R")
public class Retrait extends Operation {
    
    
    public Retrait(Date dateOperation, double montant) {
        super(dateOperation, montant);
    }
}
