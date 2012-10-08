
package edu.chl.group10.core;

import java.util.List;

public interface IOrderBook extends IEntityContainer<PurchaseOrder, Long> {

    List<PurchaseOrder> getByCustomer(Customer c);
    
}
