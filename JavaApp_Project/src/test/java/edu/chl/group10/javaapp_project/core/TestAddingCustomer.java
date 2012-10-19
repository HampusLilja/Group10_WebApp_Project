package edu.chl.group10.javaapp_project.core;

import edu.chl.group10.core.Address;
import edu.chl.group10.core.Customer;
import edu.chl.group10.core.Group10;
import edu.chl.group10.core.ICustomerList;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Using the database facade
 */
public class TestAddingCustomer {

    @BeforeClass
    public static void setUpClass() throws Exception {
        
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        
    }

    @Test
    public void testAddingCustomer(){
        ICustomerList cl = Group10.INSTANCE.getCustomerList();
        Customer c1 = new Customer("Fname", "Lname", new Address("street", 1, 112, "town"), 
                "Email", "Password");
        Customer c2;

        cl.add(c1);
        
        c2 = cl.find(c1.getID());

        Assert.assertFalse( c1 == c2 ); 

        Assert.assertTrue( c1.equals(c2)); 
        
        Assert.assertTrue( c2.getFirstName().equals(c1.getFirstName()) );
        
        cl = null;
    }

}