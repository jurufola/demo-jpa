package fr.diginamic;

import fr.diginamic.entites.Region;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ConnexionJpa {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("recensement");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction et = manager.getTransaction();
        et.begin();
        Region region = manager.find(Region.class, 58);
        System.out.println(region);
        //Creation nouvelle region
        Region regionNv = new Region("223", "Ségou");
        manager.persist(regionNv);
        et.commit();
        manager.close();
        factory.close();

    }
}
