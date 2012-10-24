package edu.chl.group10.core;

import java.util.ArrayList;
import java.util.List;

public final class ProductList extends AbstractDAO<Product, Long> implements IProductList{
    private ProductQueryProcessor pQProc = new ProductQueryProcessor();
    
    public ProductList(String puName) {
        super(Product.class, puName);
    }
    
    @Override
    public List<Product> getAll() {
        List<Product> productList = pQProc.getAll();
        return productList;
    }
    
    @Override
    public void remove(Long id) {
            pQProc.remove(id);
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
    @Override
    public List<Product> getAllByType(String type) {
        List<Product> found = new ArrayList<>();
        for (Product p : getAll()) {
            if (p.getType().equals(type)) {
                found.add(p);
            }
        }
        return found;
    }
}
