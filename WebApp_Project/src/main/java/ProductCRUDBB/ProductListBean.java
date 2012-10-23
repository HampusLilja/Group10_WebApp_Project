package ProductCRUDBB;

import edu.chl.group10.core.Group10;
import edu.chl.group10.core.IProductList;
import edu.chl.group10.core.Product;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Herzog
 */
@Named("ProductListBean")
@SessionScoped
public class ProductListBean implements Serializable {
    
    private IProductList plist;
    
    public ProductListBean (){
        plist  = Group10.INSTANCE.getProductList();
        
    }
    
    public List<Product> getAll(){
        return plist.getAll();
    }
    
    public Product find(long id){
        return plist.find(id);
    }
    
    public void add(Product p){
        plist.add(p);
    }
    
    public void remove(long id) {
        plist.remove(id);
    }
    
    public String getProductNameByID(long id) {
        Product product = plist.find(id);
        return product.getName();
    }
    
}
