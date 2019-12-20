package org.gestion.banq.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
public class Operation implements Serializable {

    private Long numeroOpertaion;
    private Date dateOperation;
    private double montant;
    private Compte compte;
    private Employe employe;

    public Operation(Date dateOperation, double montant) {
        this.dateOperation = dateOperation;
        this.montant = montant;
    }
}
