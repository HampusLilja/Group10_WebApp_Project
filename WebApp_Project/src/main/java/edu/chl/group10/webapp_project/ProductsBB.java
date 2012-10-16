package edu.chl.group10.webapp_project;

import edu.chl.group10.core.Product;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Herzog & Lilja
 */

@Named("products")
@RequestScoped
public class ProductsBB {
    
    @Inject
    private ProductListBean productList;
    
    public List<Product> getAll() {
        //ICustomerList cl = Group10.INSTANCE.getCustomerList();
        //return cl.getAll();
        return productList.getAll();
    }
}
