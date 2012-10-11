    package edu.chl.group10.core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Persistence;

/**
 * A container for entities
 * Base class for OrderBook, ProductCatalogue, CustomerRegistry
 * 
 * K is type of id (primary key)
 * 
 * @author hajo
 */
    
public abstract class AbstractDAO<T, K> implements IDAO<T, K> {

    //private List<T> elems = new ArrayList<>();
    
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
            //DbExceptionHandler.handle(ex);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void remove(K id) {
        T t = find(id);
        if (t != null) {
            //elems.remove(t);
        }
    }

    @Override
    public void update(T t) {
        //T old = find(t.getId());
        //if (t != null) {
          //  elems.remove(old);
           // elems.add(t);
        //}
    }

    @Override
    public T find(K id) {
        EntityManager em = getEntityManager();
        T t = em.find(clazz, id);
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
            //DbExceptionHandler.handle(ex);
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return elems;
        //return elems.subList(elems.indexOf(getEntityManager()), 
          //      elems.lastIndexOf(getEntityManager()));
    }

    @Override
    public List<T> getRange( int firstResult, int maxResults) {
        return null;
        //return elems.subList(firstResult, firstResult + maxResults );
    }

    @Override
    public int getCount() {
        return 0;
        //return elems.size();
    }
}