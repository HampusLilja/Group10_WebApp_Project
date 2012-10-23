package edu.chl.group10.webapp_project.CustomerCRUDBB;

import edu.chl.group10.core.Address;
import edu.chl.group10.core.Customer;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Group10
 */

@Named("addCustomer")
@RequestScoped
public class AddCustomerBB {
    private long ID;
    private String firstName;
    private String lastName;
    private String street;
    private int number;
    private int zip;
    private String town;
    private Address address;

    private String email;
    private String password;
    private boolean isAdmin;
    
    @Inject
    private CustomerListBean customerList;
    
    public AddCustomerBB(){
        
    }

    public void addCustomer(String firstName, String lastName, String street, 
            int number, int zip, String town, String email, String password, 
            boolean admin) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.street = street;
        this.number = number;
        this.zip = zip;
        this.town = town;
        this.address = new Address(street, number, zip, town);
        this.email = email;
        this.isAdmin = admin;
        
       customerList.add(new Customer(firstName, lastName, address, email, 
               password, isAdmin));

    }
    
    public String getFirstName(){
        return firstName;
    }
    
    public String getLastName(){
        return lastName;
    }
    
    public String getPassword(){
        return password;
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
    
    public boolean getIsAdmin(){
        return isAdmin;
    }
    
    public long getID(){
        return ID;
    }
    
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public void setAddress(String street, int number, int zip, String town){
        this.address = new Address(street, number, zip, town);
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
    
    public String getEmail(){
        return email;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public void setIsAdmin(boolean admin){
        this.isAdmin = admin;
    }
    
    public void setID(long id){
        this.ID = id;
    }
}
