package org.gestion.banq.dao;

import org.gestion.banq.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

// https://www.youtube.com/watch?v=5W3jsEcZgnc

public class BanqueDaoImpl implements IBanqueDao {
    
    @PersistenceContext // pour la configuration de JPA avec Spring
    // Pour gérer la persistence on utilise JPA avec l'Entitymanager :
    private EntityManager entityManager;
    
    @Override
    public Client addClient(Client client) {
        //c'est Spring qui gère les transactions
        entityManager.persist(client); // on enregistre le client et on le retourne
        return client;
    }
    
    @Override
    public Employe addEmploye(Employe e, Long codeSup) {
        if (codeSup != null) {
            Employe sup = entityManager.find(Employe.class, codeSup);
            e.setEmployeSup(sup);
        }
        entityManager.persist(e);
        return e;
    }
    
    @Override
    public Groupe addGroupe(Groupe g) {
        entityManager.persist(g);
        return g;
    }
    
    @Override
    public void addEmployeTogroupe(Long codeEmp, Long codeGr) {
        Employe emp = entityManager.find(Employe.class, codeEmp);
        Groupe gp = entityManager.find(Groupe.class, codeGr);
        // association bidirectionnelle donc on ajoute emp à gp et gp à emp
        gp.getEmployes().add(emp);
    }
    
    @Override
    public Compte addCompte(Compte cp, Long codeCli, Long codeEmp) {
        Client cli = entityManager.find(Client.class, codeCli);
        Employe emp = entityManager.find(Employe.class, codeEmp);
        cp.setClient(cli);
        cp.setEmploye(emp);
        entityManager.persist(cp);
        
        return cp;
    }
    
    @Override
    public Operation addOperation(Operation op, String codeCpte, Long codeEmp) {
        Compte cp = consulterCompte(codeCpte);
        Employe emp = entityManager.find(Employe.class, codeEmp);
        op.setCompte(cp);
        op.setEmploye(emp);
        entityManager.persist(op);
        return op;
    }
    
    @Override
    public Compte consulterCompte(String codeCpte) {
        Compte cp = entityManager.find(Compte.class, codeCpte);
        if (cp == null) {
            throw new RuntimeException("Compte introuvable");
        }
        return cp;
    }
    
    @Override
    public List<Operation> consulterOperations(String codeCpte) {
        //Non pas comme ça !! :
        //Compte cp = entityManager.find(Compte.class, codeCpte);
        //return (List<Operation>) cp.getOperations();
        //On utilise une query :
        Query req = entityManager.createQuery("select o from Operation o where o.compte.codeCompte=:x");
        req.setParameter("x", codeCpte); // ondéfinit le param x de la requête
        return req.getResultList();
        
    }
    
    @Override
    public Client consulterClient(Long codeCli) {
        Client c = entityManager.find(Client.class, codeCli);
        if (c == null) {
            throw new RuntimeException("Client introuvable");
        }
        return c;
    }
    
    @Override
    public List<Client> consulterClients(String motCle) {
        Query req = entityManager.createQuery("select c from Client c where c.nomClient like  :x");
        req.setParameter("x", "%" + motCle + "% "); // ondéfinit le param x de la requête
        return req.getResultList();
    }
    
    @Override
    public List<Compte> getComptesByClient(Long codeCli) {
        Query req = entityManager.createQuery("select c from Compte c where c.client. codeClient=:x");
        req.setParameter("x", codeCli);
        return req.getResultList();
    }
    
    @Override
    public List<Compte> getComptesByEmploye(Long codeEmp) {
        Query req = entityManager.createQuery("select c from Compte c where c.employe.codeEmploye=:x");
        req.setParameter("x", codeEmp);
        return req.getResultList();
    }
    
    @Override
    public List<Employe> getEmployes() {
        Query req = entityManager.createQuery("select e from Employe e");
        return req.getResultList();
    }
    
    @Override
    public List<Groupe> getGroupes() {
        Query req = entityManager.createQuery("select g from Groupe g");
        return req.getResultList();
    }
    
    @Override
    public List<Employe> getEmployesByGroupe(Long codeGr) {
        Query req = entityManager.createQuery("select e from Employe e where e.groupe.codeGroupe=:x");
        req.setParameter("x", codeGr);
        return req.getResultList();
    }
}
