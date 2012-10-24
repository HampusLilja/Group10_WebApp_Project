package edu.chl.group10.core;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
    
public abstract class AbstractDAO<T, K> implements IDAO<T, K> {
    
    private final EntityManagerFactory emf;
    private final Class<T> clazz;

    protected AbstractDAO(Class<T> clazz, String puName) {
        this.clazz = clazz;
        emf = Persistence.createEntityManagerFactory(puName);
    }
    
    protected EntityManager getEntityManager() {
        EntityManager em = emf.createEntityManager();
        Logger.getAnonymousLogger().log(Level.INFO, "Createing EM {0}", em);
        return em;
    }

    @Override
    public void add(T t) {
        EntityManager em = null;
        
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(t);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void remove(K id) {
        EntityManager em = null;
        
        try {
            em = getEntityManager();
            T t = em.getReference(clazz, id);
            em.getTransaction().begin();
            em.remove(t);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }

    }

    @Override
    public void update(T t) {

    }

    @Override
    public T find(K id) {
        EntityManager em = null;
        T t = null;
        try {
            em = getEntityManager();
            t = em.find(clazz, id);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return t;
    }

    @Override
    public List<T> getAll() {
        List<T> elems = new ArrayList<>();
        EntityManager em = null;
        try {
            em = getEntityManager();
            elems.add(em.find(clazz, 66L));
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return elems;

    }

    @Override
    public List<T> getRange( int firstResult, int maxResults) {
        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }
}
