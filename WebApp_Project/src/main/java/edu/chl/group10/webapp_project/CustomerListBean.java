package edu.chl.group10.webapp_project;

import edu.chl.group10.core.Customer;
import edu.chl.group10.core.Group10;
import edu.chl.group10.core.ICustomerList;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Hampus
 */
@Named("CustomerListBean")
@SessionScoped
public class CustomerListBean implements Serializable {
    
    private ICustomerList clist;
    public CustomerListBean (){
        clist  = Group10.INSTANCE.getCustomerList();
        
    }
    
    public List<Customer> getAll(){
        return clist.getAll();
    }
    
    public Customer find(long id){
        return clist.find(id);
    }
    
    public void add(Customer c){
        clist.add(c);
    }
    
    public void remove(long id) {
        clist.remove(id);
    }
    
    public String getCustomerNameByID(long id) {
        Customer customer = clist.find(id);
        return customer.getFirstName() + customer.getLastName();
    }
    
}
