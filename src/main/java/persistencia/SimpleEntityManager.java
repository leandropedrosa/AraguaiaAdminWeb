/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author gabriel
 *
 * Oct 17, 2013
 *
 * This class encapsulates some work of EntityManager and EntityManagerFactory,
 * doing only the essential
 *
 */
public class SimpleEntityManager {

    private EntityManager entityManager;
    private EntityManagerFactory factory;

    public SimpleEntityManager(EntityManagerFactory factory) throws Exception {
        this.factory = factory;
        this.entityManager = factory.createEntityManager();
    }

    public SimpleEntityManager(String persistenceUnitName) throws Exception {
        factory = Persistence.createEntityManagerFactory(persistenceUnitName);
        this.entityManager = factory.createEntityManager();
    }

    public void beginTransaction() throws Exception {
        entityManager.getTransaction().begin();
    }

    public void commit() throws Exception {
        entityManager.getTransaction().commit();
    }

    /**
     * THIS METHOD NEEDS TO BE ALWAYS CALLED
     */
    public void close() throws Exception {
        entityManager.close();
        factory.close();
    }

    public void rollBack() throws Exception {
        entityManager.getTransaction().rollback();
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
