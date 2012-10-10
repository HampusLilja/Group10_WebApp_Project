
package edu.chl.group10.core;

import java.util.ArrayList;
import java.util.List;

public final class OrderBook extends AbstractEntityContainer<PurchaseOrder, Long> implements IOrderBook{

    public static IOrderBook newInstance() {
       return new OrderBook();
    }
  
    private OrderBook(){
    }

   
    @Override
    public List<PurchaseOrder> getByCustomer(Customer c) {
        List<PurchaseOrder> found = new ArrayList<>();
        for (PurchaseOrder po : getAll()) {
            if (po.getCustomer().equals(c)) {
                found.add(po);
            }
        }
        return found;
    }
}
