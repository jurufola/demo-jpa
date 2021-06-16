package fr.diginamic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnexionJpa {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("recensement");
        EntityManager manager = factory.createEntityManager();

    }
}
