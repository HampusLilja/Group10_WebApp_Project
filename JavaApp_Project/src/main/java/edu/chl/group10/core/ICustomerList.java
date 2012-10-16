package edu.chl.group10.core;

import java.util.List;

public interface ICustomerList extends IDAO<Customer, Long> {

    List<Customer> getByEmail(String name);
    
    List<Customer> getByPassword(String password); 
    
}
