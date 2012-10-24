package edu.chl.group10.javaapp_project.core;

import edu.chl.group10.core.Address;
import edu.chl.group10.core.Customer;
import edu.chl.group10.core.CustomerList;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestJPQL {

    private static EntityManagerFactory emf;

    @BeforeClass
    public static void setUpClass() throws Exception {
        emf = Persistence.createEntityManagerFactory("group10_pu");
        EntityManager em = emf.createEntityManager();
        List<Customer> customers1 = new ArrayList<>();
        List<Customer> customers2 = new ArrayList<>();
        Customer c1 = new Customer(1L, "Fname1", "Lname1", new Address("street1", 1, 111, "town1"), 
                        "Email1", "Password1", false);
        Customer c2 = new Customer(2L, "Fname2", "Lname2", new Address("street2", 2, 112, "town2"), 
                        "Email2", "Password2", false);
        Customer c3 = new Customer(3L, "Fname3", "Lname3", new Address("street3", 3, 113, "town3"), 
                        "Email3", "Password3", false);
        Customer c4 = new Customer(4L, "Fname4", "Lname4", new Address("street4", 4, 114, "town4"), 
                        "Email4", "Password4", false);
        customers1.add(c1);
        customers1.add(c2);
        customers2.add(c3);
        customers2.add(c4);

        em.getTransaction().begin();
        em.persist(c1);
        em.persist(c2);
        em.persist(c3);
        em.persist(c4);
        em.getTransaction().commit();
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        emf.close();
    }
    
    @Test
    public void testGetAllInCustomerList() {
        CustomerList customerList = new CustomerList("group10_pu");
        List<Customer> cl = new ArrayList<>();
        
        cl = customerList.getAll();
        
        Assert.assertNotNull("Can´t get data from database", cl);
        Assert.assertEquals("Wrong number of elements", cl.size(), 4);
    }
   
}
