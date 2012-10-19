package edu.chl.group10.javaapp_project.core;

import edu.chl.group10.core.Address;
import edu.chl.group10.core.Customer;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * NOTE: this is run in Java SE environment using an application managed
 * EntityManager
 */
public class Mapper {

    // A heavy operation should be done as seldom as possible
    private final static EntityManagerFactory emf = Persistence.createEntityManagerFactory("group10_pu");

    public void persistCustomer() {
        // Light weight operation,c
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        Customer customer = new Customer("Fname", "Lname", new Address("street", 1, 112, "town"), 
                "Email", "Password");
        tx.begin();
        em.persist(customer);
        tx.commit();
        em.close();
    }
/*
    public void persistBookWithEnum() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        BookWithEnum book = new BookWithEnum("aaaaa", 111F, "wwwww");
        book.setGenre(BookWithEnum.Genre.AAA);
        tx.begin();
        em.persist(book);
        tx.commit();
        em.close();
    }

    public void persistBookWithCollection() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        BookWithCollection book = new BookWithCollection("aaaaa", 111F, "wwwww");
        List<String> list = new ArrayList<>();
        list.add("zzz");
        list.add("xxx");
        list.add("ccc");
        book.setTags(list);

        tx.begin();
        em.persist(book);
        tx.commit();
        em.close();
    }

    public void persistOneToOneUni() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        Product product = new Product("Kabel", 325);
        OrderItem orderItem = new OrderItem(product, 24);
        //orderItem.setBook(book);
        tx.begin();
        em.persist(product);
        em.persist(orderItem);
        em.persist(product);
        tx.commit();

        /*
        // Find statistics
        stat = em.find(SalesStatisticsUni.class, 1L);
        // Get book possible (the revers not possible)
        book = stat.getBook();
         
        em.close();
    }
 /*   
    public void persistGeneric() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        GenericEntity<Integer> gei = new GenericEntity<>();
        UseGenericEntity uge = new UseGenericEntity();
        uge.setI(gei);
        tx.begin();
        em.persist(gei);
        em.persist(uge);
        tx.commit();
        
    }*/
}
