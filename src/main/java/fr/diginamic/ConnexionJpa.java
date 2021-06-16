package fr.diginamic;

import fr.diginamic.entites.Livre;
import fr.diginamic.entites.Region;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

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
        Livre livre = managerBiblio.find(Livre.class, 1);
        System.out.println(livre.getId());
        //Insertion nouveau livre
        Livre livreNv = new Livre("La tête à toto", "toto");
        managerBiblio.persist(livreNv);
        etBiblio.commit();
        managerBiblio.close();
        factoryBiblio.close();

    }
}
