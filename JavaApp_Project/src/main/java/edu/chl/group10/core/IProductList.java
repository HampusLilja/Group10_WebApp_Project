package edu.chl.group10.core;

import java.util.List;

public interface IProductList extends IDAO<Product, Long> {

    List<Product> getByName(String name);
    
    List<Product> getAllByType(String type);
    
}
