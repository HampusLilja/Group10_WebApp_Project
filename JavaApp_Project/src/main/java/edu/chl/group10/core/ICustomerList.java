package edu.chl.group10.core;

import java.util.List;

public interface ICustomerList extends IDAO<Customer, Long> {

    List<Customer> getByName(String name);
    
}
