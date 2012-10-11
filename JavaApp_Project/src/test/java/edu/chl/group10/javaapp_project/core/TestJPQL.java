package edu.chl.group10.javaapp_project.core;

import edu.chl.group10.core.Address;
import edu.chl.group10.core.ContactInfo;
import edu.chl.group10.core.Customer;
import edu.chl.group10.core.CustomerList;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *  This is a Junit test using the embedded Derby database
 *  not possible to inspect tables, created and destroyed.
 * @author hajo
 */
public class TestJPQL {

    private static EntityManagerFactory emf;

    @BeforeClass
    public static void setUpClass() throws Exception {
        emf = Persistence.createEntityManagerFactory("group10_pu");
        EntityManager em = emf.createEntityManager();
        List<Customer> customers1 = new ArrayList<>();
        List<Customer> customers2 = new ArrayList<>();
        Customer c1 = new Customer(1L, "Fname1", "Lname1", new Address("street1", 1, 111, "town1"), 
                new ContactInfo("Phonenumber1", "Email1", "Website1", "Comments1"), "Password1");
        Customer c2 = new Customer(2L, "Fname2", "Lname2", new Address("street2", 2, 112, "town2"), 
                new ContactInfo("Phonenumber2", "Email2", "Website2", "Comments2"), "Password2");
        Customer c3 = new Customer(3L, "Fname3", "Lname3", new Address("street3", 3, 113, "town3"), 
                new ContactInfo("Phonenumber3", "Email3", "Website3", "Comments3"), "Password3");
        Customer c4 = new Customer(4L, "Fname4", "Lname4", new Address("street4", 4, 114, "town4"), 
                new ContactInfo("Phonenumber4", "Email4", "Website4", "Comments4"), "Password4");
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
