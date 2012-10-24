package edu.chl.group10.javaapp_project.core;

import edu.chl.group10.core.Address;
import edu.chl.group10.core.Customer;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Mapper {

    private final static EntityManagerFactory emf = Persistence.createEntityManagerFactory("group10_pu");

    public void persistCustomer() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        Customer customer = new Customer("Fname", "Lname", new Address("street", 1, 112, "town"), 
                "Email", "Password", false);
        tx.begin();
        em.persist(customer);
        tx.commit();
        em.close();
    }
}
