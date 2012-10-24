package edu.chl.group10.core;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class QueryProcessor {
    
    
    private final EntityManagerFactory emf;

    protected QueryProcessor() {
        emf = Persistence.createEntityManagerFactory("group10_pu");
    }
    
    protected EntityManager getEntityManager() {
        EntityManager em = emf.createEntityManager();
        Logger.getAnonymousLogger().log(Level.INFO, "Createing EM {0}", em);
        return em;
    }
    
    public List<Customer> getAll(){
        EntityManager em = null;
        List<Customer> cl = null;
        try {
            em = getEntityManager();
            String query = "select c from Customer c";
            TypedQuery<Customer> q = em.createQuery(query, Customer.class);
            
            q.setMaxResults(200);
            cl = q.getResultList();
        } catch (Exception ex) {
            System.out.print(ex);
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return cl;
    }
    
    public void remove(long id){
        EntityManager em = null;
        try {
            em = getEntityManager();
            String query = "delete from Customer c where c.id = :id";
            TypedQuery<Customer> q = em.createQuery(query, Customer.class);
            q.setParameter("id", id);
            em.getTransaction().begin();
            int i = q.executeUpdate();
            em.getTransaction().commit();
            
        } catch (Exception ex) {
            System.out.print(ex);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
     
}
