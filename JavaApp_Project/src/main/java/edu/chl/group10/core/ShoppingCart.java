/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.group10.core;

import java.util.HashMap;

/**
 *
 * @author Herzog
 */
public class ShoppingCart {
    private HashMap<Product, Integer> purchaseOrder;
    
    public ShoppingCart(){
        purchaseOrder = new HashMap<>();
    }
    
    public void addProduct(Product product, int quantity){
        if(purchaseOrder.containsKey(product)){
            setQuantity(product, quantity);
        }
        else{
            purchaseOrder.put(product, quantity);
        }
    }
    public void removeProduct(Product product){
        purchaseOrder.remove(product);
    }
    public HashMap<Product, Integer> getPurchaseOrder(){
        return purchaseOrder;
    }
    public void setQuantity(Product product, int quantity){
        purchaseOrder.put(product, getQuantity(product)+quantity);
    }
    public int getQuantity(Product product){
        return purchaseOrder.get(product);
    }
    
}
