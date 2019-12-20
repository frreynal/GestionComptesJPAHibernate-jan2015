package org.gestion.banq.entities;

import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@NoArgsConstructor
@Entity
@DiscriminatorValue("V")
public class Versement extends Operation {
    
    public Versement(Date dateOperation, double montant) {
        super(dateOperation, montant);
    }
}
