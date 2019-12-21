package org.gestion.banq.metier;

import org.gestion.banq.entities.*;

import java.util.List;

public interface IBanqueMetier {
    
    public Client addClient(Client client);
    
    public Employe addEmploye(Employe e, Long codeSup);
    
    public Groupe addGroupe(Groupe g);
    
    public void addEmployeTogroupe(Long codeEmp, Long codeGr);
    
    public Compte addCompte(Compte cp, Long codeCli, Long codeEmp);
    
    public void versement(double mt, String codeCpte, Long codeEmp);
    
    public void retrait(double mt, String codeCpte, Long codeEmp);
    
    public void virement(double mt, String codeCpt1, String codeCpte2, Long CodeEmp);
    
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
