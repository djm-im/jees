package rs.djm.jees.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author djm.rs
 */
public class EntityManagerWrapper {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("JEES_PU");

    public static EntityManager createEntityManager() {
        return emf.createEntityManager();
    }
}
