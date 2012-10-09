/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.group10.core;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Herzog & Lilja
 */
public final class CustomerList extends AbstractEntityContainer<Customer, Long> implements ICustomerList{
    private List<Customer> customerList;
    
    public static ICustomerList newInstance() {
        return new CustomerList();
    }
    
    private CustomerList() {
       
    }
    
    @Override
    public List<Customer> getByName(String name) {
        List<Customer> found = new ArrayList<>();
        for (Customer c : getAll()) {
            if (c.getFirstName().equals(name) || c.getLastName().equals(name)) {
                found.add(c);
            }
        }
        return found;
    }
    
}
