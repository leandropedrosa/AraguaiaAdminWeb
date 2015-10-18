/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

/**
 *
 * @author Leandro
 */
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * @author gabriel
 *
 * Oct 17, 2013
 */
@SuppressWarnings("unchecked")
public class GenericDAO<T> {

    private final static String UNIT_NAME = "AraguaiaPU";

    @PersistenceContext(unitName = UNIT_NAME)
    public EntityManager em;

    private Class<T> entityClass;

    public GenericDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public GenericDAO() {
    }

    public T save(T entity) throws Exception {
        em.persist(entity);
        return em.merge(entity);
    }

    protected void delete(Object id, Class<T> classe) throws Exception {
        T entityToBeRemoved = em.getReference(classe, id);

        em.remove(entityToBeRemoved);
    }

    public T update(T entity) throws Exception {
        return em.merge(entity);
    }

    public T find(int entityID) throws Exception {
        try {
            return em.find(entityClass, entityID);
        } catch (NoResultException nre) {
            return null;
        }
    }

    public List<T> findAll(Class classe) throws Exception {
        try {
            return em.createQuery(("FROM " + classe.getName()))
                    .getResultList();
        } catch (NoResultException nre) {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    protected T findOneResultName(String namedQuery, Map<String, Object> parameters) throws Exception {
        T result = null;
        try {
            Query query = em.createNamedQuery(namedQuery);

            if (parameters != null && !parameters.isEmpty()) {
                populateQueryParameters(query, parameters);
            }

            result = (T) query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    protected List<T> findListResultName(String namedQuery, Map<String, Object> parameters) throws Exception {
        List<T> result = null;
        try {
            Query query = em.createNamedQuery(namedQuery);

            if (parameters != null && !parameters.isEmpty()) {
                populateQueryParameters(query, parameters);
            }

            result = (List<T>) query.getResultList();
        } catch (NoResultException nre) {
            return null;
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    protected List<T> findSQLResult(String sql) throws Exception {
        List<T> result = null;

        try {
            Query query = em.createQuery(sql);

            result = (List<T>) query.getResultList();

        } catch (NoResultException nre) {
            return null;
        }

        return result;
    }

    protected List<T> findNativeSQLResult(String sql) throws Exception {
        List<T> result = null;

        try {
            Query query = em.createNativeQuery(sql);

            result = (List<T>) query.getResultList();

        } catch (NoResultException nre) {
            return null;
        }

        return result;
    }

    private void populateQueryParameters(Query query, Map<String, Object> parameters) throws Exception {
        for (Entry<String, Object> entry : parameters.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
    }
}
