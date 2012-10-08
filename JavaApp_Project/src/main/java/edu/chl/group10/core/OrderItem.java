
package edu.chl.group10.core;

public class OrderItem {

    private final Product product;
    private final int quantity;

    OrderItem(Product product, int quantity) {
        this.quantity = quantity;
        this.product = product;
    }
   
    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "OrderItem{" + "product=" + product + ", quantity=" + quantity + '}';
    }
    
    
}
