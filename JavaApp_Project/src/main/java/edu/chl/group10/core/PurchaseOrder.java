package edu.chl.group10.core;

import java.util.Map.Entry;
import java.util.*;


public class PurchaseOrder implements IEntity<Long>{

    @Override
    public Long getID() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public enum State {  
        ACCEPTED,
        CANCELLED,
        INVOICED,
        UNINVOIDED,
        SHIPPED,}
    
    // For now. Later database will generate id
    private Long id = new Long(new Random().nextInt(100));
    private final Date date = new Date();
    private final List<OrderItem> items;
    private final Customer customer;
    private State state = State.ACCEPTED;

    // Can't create order with no Customer
    public PurchaseOrder(Customer customer) {
        this.customer = customer;
        items = new ArrayList<>();
        Map<Product, Integer> pf = customer.getCart().getPurchaseOrder();
        for (Entry<Product, Integer> e : pf.entrySet()) {
            items.add(new OrderItem(e.getKey(), e.getValue()));
        }
    }

    public Date getDate() {
        return date;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public Customer getCustomer() {
        return customer;
    }

    public State getState() {
        return state;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "PurchaseOrder{" + "id=" + id + ", date=" + date + 
                ", items=" + items + ", customer=" + customer + 
                ", state=" + state + '}';
    }
}
