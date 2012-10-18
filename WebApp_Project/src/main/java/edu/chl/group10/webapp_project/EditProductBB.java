package edu.chl.group10.webapp_project;

import edu.chl.group10.core.Product;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Herzog
 */
@Named("editProduct")
@RequestScoped
public class EditProductBB {
    
    public EditProductBB(){
        
    }
    @Inject
    private ProductListBean productList;
    
    
    public void editProduct(long id, String name, int amount, int price,
        int alcoholProof, String type){
        
        //Product product = productList.find(id);
        productList.remove(id);
        
        productList.add(new Product(id, name, amount, price,
        alcoholProof, type));
    }
    
    public void setProductInfo(){
    }

}