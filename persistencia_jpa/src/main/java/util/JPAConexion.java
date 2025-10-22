package util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceUtil;

import javax.swing.text.html.parser.Entity;

public class JPAConexion {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_db");

    public static EntityManager getEntityManager(){ return emf.createEntityManager(); }

    public static void close(){ emf.close();}
}
