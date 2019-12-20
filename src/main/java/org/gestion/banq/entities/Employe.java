package org.gestion.banq.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Data
@NoArgsConstructor
@Entity
public class Employe implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codeEmploye;
    private String nomEmploye;
    // un employé appartient à un supérieur hiérarcique donc on a la relation manyToOne , càd il y a
    // plusieurs employés qui ont le même supérieur:
    @ManyToOne
    @JoinColumn(name = "CODE_EMP_SUP") // c'est la clé étrangère
    private Employe employeSup;
    // un Employe appartient à plusieurs Groupes donc on a la relation ManyToMany
    @ManyToMany
    @JoinTable(name = "EMPL_GRP") // table de jointure qui contient 2 clés étrangères : CODE_EMP et CODE_GP
    // On peut expliciter le nom des colonnes de cette table si on veut :
    //@JoinTable(name="EMP_GR", joinColumns = @JoinColumn(name="CODE_EMP"), inverseJoinColumns =
    //@JoinColumn (name="CODE_GR"))
    private Collection<Groupe> groupes;
    
    public Employe(String nomEmploye) {
        this.nomEmploye = nomEmploye;
    }
}
