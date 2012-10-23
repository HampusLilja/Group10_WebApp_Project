/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.group10.webapp_project.CustomerCRUDBB;


import edu.chl.group10.core.Address;
import edu.chl.group10.core.Customer;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Hampus
 */
@Named("editCustomer")
@RequestScoped
public class EditCustomerBB {
    
    private long ID;
    private Address address;
    private String street;
    private int number;
    private int zip;
    private String town;
    private String email;
    
    public EditCustomerBB(){
        
    }
    @Inject
    private CustomerListBean customerList;
    
    
    public void editCustomerDetails(Long id, String firstName, String lastName, 
            String street, int number, int zip, String town, String email){
        Customer customer = customerList.find(id);
        customerList.remove(id);

        this.street = street;
        this.number = number;
        this.zip = zip;
        this.town = town;
        this.address = new Address(street, number, zip, town);
        this.email = email;
        
        customerList.add(new Customer(id, firstName, lastName, 
                address, email, customer.getPassword()));
    }
       
    public Address getAddress(){
        return address;
    }
    
    public String getStreet(){
        return street;
    }
    
    public int getNumber(){
        return number;
    }
    
    public int getZip(){
        return zip;
    }
    
    public String getTown(){
        return town;
    }
    
    public void setStreet(String street){
        this.street = street;
    }
    
    public void setNumber(int number){
        this.number = number;
    }
    
    public void setZip(int zip){
        this.zip = zip;
    }
    
    public void setTown(String town){
        this.town = town;
    }
    
    public void setAddress(String street, int number, int zip, String town){
        this.address = new Address(street, number, zip, town);
    }
    
    public long getID(){
        return ID;
    }
    
    public void setID(long id){
        this.ID = id;
    }
    
    
}