package edu.chl.group10.webapp_project;

import edu.chl.group10.core.Address;
import edu.chl.group10.core.Customer;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Hampus
 */
@Named("editAddressDetails")
@RequestScoped
public class EditAddressDetailsBB {
    
    private long ID;
    private Address address;
    private String street;
    private int number;
    private int zip;
    private String town;
    
    public EditAddressDetailsBB(){
        
    }
    @Inject
    private CustomerListBean customerList;
    
    
    public void editAddressDetails(Long id, String firstName, String lastName, 
            String street, int number, int zip, String town){
        Customer customer = customerList.find(id);
        customerList.remove(id);

        this.street = street;
        this.number = number;
        this.zip = zip;
        this.town = town;
        this.address = new Address(street, number, zip, town);
        
        customerList.add(new Customer(id, firstName, lastName, 
                address, customer.getContactInfo(), customer.getPassword()));
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

