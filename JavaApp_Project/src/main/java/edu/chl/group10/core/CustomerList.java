package edu.chl.group10.core;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Herzog & Lilja
 */
public final class CustomerList extends AbstractDAO<Customer, Long> implements ICustomerList{
    private List<Customer> customerList;
    private QueryProcessor qProc = new QueryProcessor();
    
    /*public static ICustomerList newInstance() {
        return new CustomerList();
    }*/
    
    public CustomerList(String puName) {
        super(Customer.class, puName);
       
    }
    
    @Override
    public List<Customer> getAll() {
        List<Customer> pL = new ArrayList<>();
        
        pL = qProc.getAll();
        return pL;

    }
    
    @Override
    public void remove(Long id) {
        qProc.remove(id);
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
