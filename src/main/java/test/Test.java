package test;

import org.gestion.banq.entities.Client;
import org.gestion.banq.metier.IBanqueMetier;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext(new String[]{"/applicationContext.xml"});
        IBanqueMetier metier = (IBanqueMetier) context.getBean("metier");
        metier.addClient(new Client("Client1", "adresse1"));
        metier.addClient(new Client("Client2", "adresse2"));
        metier.addClient(new Client("Client3", "adresse3"));
        metier.addClient(new Client("Client4", "adresse4"));
    }
}
