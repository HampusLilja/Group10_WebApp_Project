/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductCRUDBB;

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
    
    private long id;
    
    @Inject
    private ProductListBean productList;
    
    
    public DeleteProductBB(){
        
    }

    public void deleteProduct(long id) {
       productList.remove(id);
    }

    public long getID(){
        return id;
    }

    public void setID(long id){
        this.id = id;
    }
}
