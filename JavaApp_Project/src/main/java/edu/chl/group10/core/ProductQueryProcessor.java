package edu.chl.group10.core;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class ProductQueryProcessor {
    
    
    private final EntityManagerFactory emf;

    protected ProductQueryProcessor() {
        emf = Persistence.createEntityManagerFactory("group10_pu");
    }
    
    protected EntityManager getEntityManager() {
        EntityManager em = emf.createEntityManager();
        Logger.getAnonymousLogger().log(Level.INFO, "Createing EM {0}", em);
        return em;
    }
    
    public List<Product> getAll(){
        EntityManager em = null;
        List<Product> pl = null;
        try {
            em = getEntityManager();
            String query = "select p from Product p";
            TypedQuery<Product> q = em.createQuery(query, Product.class);
            
            q.setMaxResults(200);
            pl = q.getResultList();
        } catch (Exception ex) {
            System.out.print(ex);
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return pl;
    }
    
    public void remove(long id){
        EntityManager em = null;
        try {
            em = getEntityManager();
            String query = "delete from Product p where p.id = :id";
            TypedQuery<Product> q = em.createQuery(query, Product.class);
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
