package org.gestion.banq.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Collection;

@Data
@NoArgsConstructor
public class Groupe implements Serializable {

    private Long codeGroup;
    private String nomGroupe;
    private Collection<Employe> employes;

    public Groupe(String nomGroupe) {
        this.nomGroupe = nomGroupe;
    }
}
