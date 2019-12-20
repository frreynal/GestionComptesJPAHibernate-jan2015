package org.gestion.banq.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Collection;

@Data
@NoArgsConstructor
public class Employe implements Serializable {

    private Long codeEmploye;
    private String nomEmploye;
    private Employe employeSup;
    private Collection<Groupe> groupes;

    public Employe(String nomEmploye) {
        this.nomEmploye = nomEmploye;
    }
}
