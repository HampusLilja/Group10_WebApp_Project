package edu.chl.group10.webapp_project.CustomerCRUDBB;


import edu.chl.group10.core.Customer;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Hampus
 */
@Named("customers")
@RequestScoped
public class CustomersBB {
    
    @Inject
    private CustomerListBean customerList;
    
    public List<Customer> getAll() {
        //ICustomerList cl = Group10.INSTANCE.getCustomerList();
        //return cl.getAll();
        return customerList.getAll();
    }
    
}