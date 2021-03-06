package edu.chl.group10.webapp_project.ProductCRUDBB;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named("deleteProduct")
@RequestScoped
public class DeleteProductBB {
    
    private long ID;
    
    @Inject
    private ProductListBean productList;
    
    
    public DeleteProductBB(){
        
    }

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
