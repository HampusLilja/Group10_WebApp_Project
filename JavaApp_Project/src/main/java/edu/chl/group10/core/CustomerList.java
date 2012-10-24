package edu.chl.group10.core;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Group10
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
        List<Customer> pL = qProc.getAll();
        return pL;
    }
    
    @Override
    public void remove(Long id) {
        qProc.remove(id);
    }
    
    @Override
    public List<Customer> getByEmail(String name) {
        List<Customer> found = new ArrayList<>();
        try {
            for (Customer c : this.getAll()) {
                if (c.getEmail().equals(name)) {
                    found.add(c);
                }
            }
            return found;
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public List<Customer> getByPassword(String password) {
        List<Customer> found = new ArrayList<>();
        try {
            for (Customer c : this.getAll()) {
                if (c.getPassword().equals(password)) {
                    found.add(c);
                }
            }
            return found;
        } catch (Exception ex) {
            return null;
        }
    }
    
    @Override
    public Customer getByEmailAndPassword(String email, String password) {
        Customer found = null;
        try {
            for (Customer c : qProc.getAll()) {
                if (c.getPassword().equals(password) && 
                        c.getEmail().equals(email)) {
                    found = c;
                }
            }
            return found;
        } catch (Exception ex) {
            return null;
        }
    }
    
}
