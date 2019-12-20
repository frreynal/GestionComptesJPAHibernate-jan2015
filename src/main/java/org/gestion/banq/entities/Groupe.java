package org.gestion.banq.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.Collection;

@Data
@NoArgsConstructor
public class Groupe implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codeGroup;
    private String nomGroupe;
    @ManyToMany(mappedBy = "groupes")
    private Collection<Employe> employes;
    
    public Groupe(String nomGroupe) {
        this.nomGroupe = nomGroupe;
    }
}
