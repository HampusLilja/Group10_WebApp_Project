/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.group10.core;

import java.util.Random;

/**
 *
 * @author Herzog & Lilja
 */
public class Customer implements IEntity<Long>{
    private final long id;
    private final String firstName;
    private final String lastName;
    private final Address address;
    private final ContactInfo contactInfo;
    private final String password;
    //private final String phoneNumber;
    //private final String email;
    private transient ShoppingCart cart;
    
    public Customer(String firstName, String lastName, Address address, 
            ContactInfo contactInfo, String password){
        // For now. Later database will generate id
        this.id = new Long(new Random().nextInt(100));
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.contactInfo = contactInfo;
        this.password = password;
        cart = new ShoppingCart();
    }
    public ShoppingCart getCart() {
        return cart;
    }
    
    /*public void setFirstName(String firstName){
        this.firstName = firstName;
    }*/
    public String getFirstName(){
        return firstName;
    }
    /*public void setLastName(String lastName){
        this.lastName = lastName;
    }*/
    public String getLastName(){
        return lastName;
    }
    /*public void setAddress(String address){
        this.address = address;
    }*/
    public Address getAddress(){
        return address;
    }
    /*public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }*/
    public ContactInfo getContactInfo(){
        return contactInfo;
    }
    /*public void setEmail(String email){
        this.email = email;
    }*/
    public String getPassword(){
        return password;
    }

    @Override
    public Long getID() {
        return id;
    }
    
    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", address=" + address.toString() + ", fname=" + 
                firstName + ", lname=" + lastName + ", email=" + contactInfo.getEmail() + '}';
    }

}
