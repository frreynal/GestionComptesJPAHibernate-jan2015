package org.gestion.banq.metier;

import lombok.Setter;
import org.gestion.banq.dao.IBanqueDao;
import org.gestion.banq.entities.*;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Setter
@Transactional // pour dire à Spring que chaque méthode doit être effectuée comme une transaction:
// si la méthode génère une exception il fait un rollback, sinon un commit
public class BanqueMetierImpl implements IBanqueMetier {
    
    private IBanqueDao dao;
    
    @Override
    public Client addClient(Client client) {
        return dao.addClient(client);
    }
    
    @Override
    public Employe addEmploye(Employe e, Long codeSup) {
        return dao.addEmploye(e, codeSup);
    }
    
    @Override
    public Groupe addGroupe(Groupe g) {
        return dao.addGroupe(g);
    }
    
    @Override
    public void addEmployeTogroupe(Long codeEmp, Long codeGr) {
        dao.addEmployeTogroupe(codeEmp, codeGr);
    }
    
    @Override
    public Compte addCompte(Compte cp, Long codeCli, Long codeEmp) {
        return dao.addCompte(cp, codeCli, codeEmp);
    }
    
    @Override
    public void versement(double mt, String codeCpte, Long codeEmp) {
        dao.addOperation(new Versement(new Date(), mt), codeCpte, codeEmp);
        // après un versment il faut mettre à jour le solde
        Compte cp = dao.consulterCompte(codeCpte);
        cp.setSolde(cp.getSolde() + mt);
    }
    
    @Override
    public void retrait(double mt, String codeCpte, Long codeEmp) {
        dao.addOperation(new Retrait(new Date(), mt), codeCpte, codeEmp);
        // après un versment il faut mettre à jour le solde
        Compte cp = dao.consulterCompte(codeCpte);
        cp.setSolde(cp.getSolde() - mt);
    }
    
    @Override
    public void virement(double mt, String codeCpt1, String codeCpte2, Long codeEmp) {
        retrait(mt, codeCpt1, codeEmp);
        versement(mt, codeCpte2, codeEmp);
    }
    
    @Override
    public Compte consulterCompte(String codeCpte) {
        return dao.consulterCompte(codeCpte);
    }
    
    @Override
    public List<Operation> consulterOperations(String codeCpte) {
        return dao.consulterOperations(codeCpte);
    }
    
    @Override
    public Client consulterClient(Long codeCli) {
        return dao.consulterClient(codeCli);
    }
    
    @Override
    public List<Client> consulterClients(String motCle) {
        return dao.consulterClients(motCle);
    }
    
    @Override
    public List<Compte> getComptesByClient(Long codeCli) {
        return dao.getComptesByClient(codeCli);
    }
    
    @Override
    public List<Compte> getComptesByEmploye(Long codeEmp) {
        return dao.getComptesByEmploye(codeEmp);
    }
    
    @Override
    public List<Employe> getEmployes() {
        return dao.getEmployes();
    }
    
    @Override
    public List<Groupe> getGroupes() {
        return dao.getGroupes();
    }
    
    @Override
    public List<Employe> getEmployesByGroupe(Long codeGr) {
        return dao.getEmployesByGroupe(codeGr);
    }
    
}
