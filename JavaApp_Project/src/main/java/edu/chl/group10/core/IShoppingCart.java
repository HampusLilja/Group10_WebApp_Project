/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.group10.core;

import java.util.List;

/**
 *
 * @author Herzog
 */
public interface IShoppingCart extends IDAO<Product, Integer>{
        List<ShoppingCart> getByCustomer(Customer c);
}


