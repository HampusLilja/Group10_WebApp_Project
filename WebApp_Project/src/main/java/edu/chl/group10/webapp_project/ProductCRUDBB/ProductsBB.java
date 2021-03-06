package edu.chl.group10.webapp_project.ProductCRUDBB;

import edu.chl.group10.core.Product;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named("products")
@RequestScoped
public class ProductsBB {
   
    @Inject
    private ProductListBean productList;
    
    public List<Product> getAll() {
        return productList.getAll();
    }
    public List<Product> getAllByType(String type){
        return productList.getAllByType(type);
    }
}
