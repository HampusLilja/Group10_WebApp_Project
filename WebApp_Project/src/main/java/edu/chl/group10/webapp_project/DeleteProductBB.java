package edu.chl.group10.webapp_project;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Herzog
 */
@Named("deleteProduct")
@RequestScoped
public class DeleteProductBB {
    
    private long ID;
    
    public DeleteProductBB(){
    }
    
    @Inject
    private ProductListBean productList;
    
    
    public void deleteProduct(long id) {
       productList.remove(id);
    }

    public long getID(){
        return ID;
    }

    public void setID(long id){
        this.ID = id;
    }
    
    
}

