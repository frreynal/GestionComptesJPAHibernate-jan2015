package org.gestion.banq.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
// par défaut Spring va mettre une DiscriminatorColumn, pour le type d'Opération : Retrait ou Versement
public class Operation implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long numeroOpertaion;
    private Date dateOperation;
    private double montant;
    @ManyToOne
    @JoinColumn(name = "CODE_CPTE")
    private Compte compte;
    @ManyToOne
    @JoinColumn(name = "CODE_EMP") // 2 clés étrangères pour les Operations : n°Compte et n°Employe
    private Employe employe;
    
    public Operation(Date dateOperation, double montant) {
        this.dateOperation = dateOperation;
        this.montant = montant;
    }
}
