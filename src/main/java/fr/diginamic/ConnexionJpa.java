package fr.diginamic;

import fr.diginamic.entites.Client;
import fr.diginamic.entites.Emprunt;
import fr.diginamic.entites.Livre;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class ConnexionJpa {
    public static void main(String[] args) {
        //Tp1
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("recensement");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction et = manager.getTransaction();
        et.begin();
        //Region region = manager.find(Region.class, 58);
       //System.out.println(region);
        //Creation nouvelle region
        //Region regionNv = new Region("226", "Koulikoro");
        //System.out.println(" id nouvelle region avant la persistence " + regionNv.getId());
        //manager.persist(regionNv);
        //System.out.println(" id nouvelle region après la persistence " + regionNv.getId());
        et.commit();
        manager.close();
        factory.close();

        //Tp2
        EntityManagerFactory factoryBiblio = Persistence.createEntityManagerFactory("bibliotheque");
        EntityManager managerBiblio = factoryBiblio.createEntityManager();
        EntityTransaction etBiblio = managerBiblio.getTransaction();
        etBiblio.begin();
        //Livre livre = managerBiblio.find(Livre.class, 1);
        //System.out.println(livre.getId());
        //Insertion nouveau livre
        //Livre livreNv = new Livre("La tête à toto", "toto", new ArrayList<>());
        //managerBiblio.persist(livreNv);

        //Tp3
        Emprunt emprunt = managerBiblio.find(Emprunt.class, 1);
        System.out.println(emprunt);
        List<Livre> livres = emprunt.getLivres();

        //Listes de tous les livres assocés à l'emperunt d'id 1
        for (Livre livre : livres) {
            System.out.println(livre);
        }

        // Tous les emprunts du client d'id 1
        TypedQuery<Emprunt> queryEmp = managerBiblio.createQuery("select emp from Emprunt emp where emp.client.id = 1", Emprunt.class);

        List<Emprunt> emprunts = queryEmp.getResultList();
        Client client = managerBiblio.find(Client.class, 1);
        //List<Emprunt> emprunts = client.getEmprunts();
        for (Emprunt emp : emprunts) {
            System.out.println(emp);
        }
        etBiblio.commit();
        managerBiblio.close();
        factoryBiblio.close();

    }
}
