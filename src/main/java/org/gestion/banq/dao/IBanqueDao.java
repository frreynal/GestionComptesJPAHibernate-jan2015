package org.gestion.banq.dao;

import org.gestion.banq.entities.*;

import java.util.List;

public interface IBanqueDao {
    public Client addClent(Client client);
    
    public Employe addEmploye(Employe e, Long codeSup);
    
    public Groupe addGroupe(Groupe g);
    
    public void addEmployeTogroupe(Long codeEmp, Long codeGr);
    
    public Compte addCompte(Compte cp, Long codeCli, Long codeEmp);
    
    public Operation addOperation(Operation op, String codeCpte, Long CodeEmp);
    
    //public void versement(String codeCpte, double mt, Long codeEmp);
    
    //public void  retrait(String codeCpte, double mt, Long codeEmp);
    
    //public void virement(String codeCpt1, String codeCpte2, double mt, Long CodeEmp);
    
    public Compte consulterCompte(String codeCpte);
    
    public List<Operation> consulterOperations(String codeCpte);
    
    public Client consulterClient(Long codeCli);
    
    public List<Client> consulterClients(String motCle);
    
    public List<Compte> getComptesByClient(Long codeCli);
    
    public List<Compte> getComptesByEmploye(Long codeEmp);
    
    public List<Employe> getEmployes();
    
    public List<Groupe> getGroupes();
    
    public List<Employe> getEmployesByGroupe(Long codeGr);
    
    
}
