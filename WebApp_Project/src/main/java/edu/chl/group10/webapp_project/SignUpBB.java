/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.group10.webapp_project;

import edu.chl.group10.core.Customer;
import edu.chl.group10.core.CustomerList;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Herzog
 */

@Named("add")
@RequestScoped
public class SignUpBB {
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
    private String email;
    
    public void actionListener() {
        Customer c = new Customer(firstName, lastName, address, phoneNumber, email);
        //+ password ?
    }
}
