/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.group10.core;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Herzog
 */
public class CustomerList {
    private List<Customer> customerList;
    public CustomerList(){
        customerList = new ArrayList<>();
    }
     
    public boolean add(Customer c) {
        return customerList.add(c);
    }
    public List<Customer> getCustomerList(){
        return customerList;
    }
    
}
