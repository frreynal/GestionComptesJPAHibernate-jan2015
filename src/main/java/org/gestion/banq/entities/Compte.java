package org.gestion.banq.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
// comme il y a de l'héritage on met cette annotation
//strategy SINGLE_TABLE means que tous les types de comptes seront regroupés ds la même table
// une colonne permettra de distinguer les différents types de compte (courant ou épargne) :
// discrimatorColumn :
@DiscriminatorColumn(name = "TYPE_CPTE", discriminatorType = DiscriminatorType.STRING, length = 4)
public class Compte implements Serializable {
    
    @Id
    private String codecompte;
    private Date dateCreation;
    private double solde;
    @ManyToOne
    @JoinColumn(name = "CODE_CLI") // clé étrangère
    private Client client;
    @ManyToOne
    @JoinColumn(name = "CODE_EMP")
    private Employe employe;
    @OneToMany(mappedBy = "compte") // c'est l'attribut Compte de la classe Operation
    private Collection<Operation> operations;
    
    public Compte(String codecompte, Date dateCreation, double solde) {
        this.codecompte = codecompte;
        this.dateCreation = dateCreation;
        this.solde = solde;
    }
    
    public Compte() {
    }
}
