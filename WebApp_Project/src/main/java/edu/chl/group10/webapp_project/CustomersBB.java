package edu.chl.group10.webapp_project;

import edu.chl.group10.core.Address;
import edu.chl.group10.core.Customer;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Hampus
 */
@Named("customer")
@RequestScoped
public class CustomersBB {
    private long ID;
    private String firstName;
    private String lastName;
    private String street;
    private int number;
    private int zip;
    private String town;
    private Address address;
    private String phoneNumber;
    private String email;
    private String website;
    private String comments;
    private String password;
    
    @Inject
    private CustomerListBean customerList;
    
    public List<Customer> getAll() {
        return customerList.getAll();
    }
    public void addCustomer(String firstName, String lastName, String street, 
            int number, int zip, String town, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.street = street;
        this.number = number;
        this.zip = zip;
        this.town = town;
        this.address = new Address(street, number, zip, town);
        this.email = email;
        
       customerList.add(new Customer(firstName, lastName, address, email,
               password));

    }
    public void editCustomer(Long id, String firstName, String lastName, 
            String street, int number, int zip, String town, String email){

        customerList.remove(id);

        this.street = street;
        this.number = number;
        this.zip = zip;
        this.town = town;
        this.address = new Address(street, number, zip, town);
        this.email = email;
        
        customerList.add(new Customer(id, firstName, lastName, 
                address, email, getPassword()));
    }
    
    public void deleteCustomer(long id) {
       customerList.remove(id);
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
    
    public String getPhoneNumber(){
        return phoneNumber;
    }
    
    public String getEmail(){
        return email;
    }
    
    public String getWebsite(){
        return website;
    }
    
    public String getComments(){
        return comments;
    }
    
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public void setWebsite(String website){
        this.website = website;
    }
    
    public void setComments(String comments){
        this.comments = comments;
    }
    
    public void setID(long id){
        this.ID = id;
    }
}
