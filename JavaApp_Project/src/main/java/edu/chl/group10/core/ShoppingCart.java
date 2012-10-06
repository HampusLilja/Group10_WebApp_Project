/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.group10.core;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Herzog
 */
public class ShoppingCart {
    private List<Product> purchaseOrder;
    
    public ShoppingCart(){
        purchaseOrder = new ArrayList<>();
    }
    
    public void addProduct(Product product){
        purchaseOrder.add(product);
    }
    public void removeProduct(Product product){
        purchaseOrder.remove(product);
    }
    public List<Product> getPurchaseOrder(){
        return purchaseOrder;
    }
    
    
}
