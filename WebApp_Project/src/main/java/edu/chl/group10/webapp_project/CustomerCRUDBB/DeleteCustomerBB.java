package edu.chl.group10.webapp_project.CustomerCRUDBB;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named("deleteCustomer")
@RequestScoped
public class DeleteCustomerBB {
    
    private long ID;
    
    public DeleteCustomerBB(){
        
    }
    @Inject
    private CustomerListBean customerList;
    
    
    public void deleteCustomer(long id) {
       customerList.remove(id);
    }

    public long getID(){
        return ID;
    }

    public void setID(long id){
        this.ID = id;
    }
    
    
}

