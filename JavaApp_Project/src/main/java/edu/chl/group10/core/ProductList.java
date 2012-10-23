package edu.chl.group10.core;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Herzog & Lilja
 */
public final class ProductList extends AbstractDAO<Product, Long> implements IProductList{
    private QueryProcessor qProc = new QueryProcessor();
    
    /*public static IProductList newInstance() {
        return new ProductList();
    }*/
    
    public ProductList(String puName) {
        super(Product.class, puName);
    }
    
    @Override
    public List<Product> getAll() {
        List<Product> productList = qProc.getAllProducts();
        return productList;

    }
    
    @Override
    public void remove(Long id) {
            qProc.remove(id);
    }
    

    @Override
    public List<Product> getByName(String name) {
        List<Product> found = new ArrayList<>();
        for (Product p : getAll()) {
            if (p.getName().equals(name)) {
                found.add(p);
            }
        }
        return found;
    }
    
}
