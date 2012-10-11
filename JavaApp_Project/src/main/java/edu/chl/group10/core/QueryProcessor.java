package edu.chl.group10.core;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Hampus
 */
public class QueryProcessor {
    
    
    private final EntityManagerFactory emf;
    private EntityManager em;

    protected QueryProcessor() {
        emf = Persistence.createEntityManagerFactory("group10_pu");
        getEntityManager();
    }
    
    protected EntityManager getEntityManager() {
        em = emf.createEntityManager();
        Logger.getAnonymousLogger().log(Level.INFO, "Createing EM {0}", em);
        return em;
    }
    
    public List<Customer> getAll(){
        List<Customer> cl = null;
        try {
            String query = "select c from Customer c";
            TypedQuery<Customer> q = em.createQuery(query, Customer.class);
            
            q.setMaxResults(200);
            cl = q.getResultList();
        } catch (Exception ex) {
            System.out.print(ex);
        } finally {
            if (em != null) {
                //em.close();
            }
        }
        return cl;
    }
    
    public List<Product> searchByID(Long productID) {
   
        List<Product> pl = null;
        try {
            String query = "select p from Product p where p.id = " + productID;
            TypedQuery<Product> q = em.createQuery(query, Product.class);
            
            q.setMaxResults(200);
            pl = q.getResultList();
            /*em = getEntityManager();
            em.getTransaction().begin();
            em.persist(productID);
            em.getTransaction().commit();*/
        } catch (Exception ex) {
            //DbExceptionHandler.handle(ex);
        } finally {
            if (em != null) {
                //em.close();
            }
        }
        return pl;
    }
    
    public List<Product> searchByName(String productName) {
   
        List<Product> pl = null;
        try {
            String query = "select p from Product p where p.name = '" + productName + "'";
            TypedQuery<Product> q = em.createQuery(query, Product.class);
            
            q.setMaxResults(200);
            pl = q.getResultList();
            
            /*em = getEntityManager();
            em.getTransaction().begin();
            em.persist(productName);
            em.getTransaction().commit();*/
        } catch (Exception ex) {
            //DbExceptionHandler.handle(ex);
        } finally {
            if (em != null) {
                //em.close();
            }
        }
        return pl;
    }
    
    public List<Product> searchByPrice(double productPrice) {
        List<Product> pl = null;
        try {
            String query = "select p from Product p where p.price = " + productPrice;
            TypedQuery<Product> q = em.createQuery(query, Product.class);
            
            q.setMaxResults(200);
            pl = q.getResultList();
            
            /*
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(productPrice);
            em.getTransaction().commit();*/
        } catch (Exception ex) {
            System.out.print(ex);
        } finally {
            if (em != null) {
                //em.close();
            }
        }
        return pl;
    }
    
    public List<Product> searchByNameAndPrice(String productName, double productPrice) {
        List<Product> pl = null;
        try {
            String query = "select p from Product p where p.name = '" + 
                    productName + "' and p.price = " + productPrice;
            TypedQuery<Product> q = em.createQuery(query, Product.class);
            
            q.setMaxResults(200);
            pl = q.getResultList();
            
            /*
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(productPrice);
            em.getTransaction().commit();*/
        } catch (Exception ex) {
            //DbExceptionHandler.handle(ex);
        } finally {
            if (em != null) {
                //em.close();
            }
        }
        return pl;
    }
    
}
