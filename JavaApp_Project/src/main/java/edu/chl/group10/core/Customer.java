package edu.chl.group10.core;

import java.io.Serializable;
import java.util.Random;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Herzog & Lilja
 */
@Entity
public class Customer implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private boolean isAdmin;
    private transient ShoppingCart cart;
    
    @Embedded protected Address address;

    public Customer() {
    }
    
    public Customer(String firstName, String lastName, Address address, 
            String email, String password, boolean admin){
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.password = password;
        this.isAdmin = admin;
        cart = new ShoppingCart();
    }
    
    public Customer(Long id, String firstName, String lastName, Address address, 
            String email, String password, boolean admin){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.password = password;
        this.isAdmin = admin;
    }
        
    public ShoppingCart getCart() {
        return cart;
    }
    
    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public Address getAddress(){
        return address;
    }

    public String getEmail(){
        return email;
    }
    
    public String getPassword(){
        return password;
    }
    
    public boolean getIsAdmin() {
        return isAdmin;
    }

    public Long getID() {
        return id;
    }
    
    
    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", address=" + address.toString() + ", fname=" + 
                firstName + ", lname=" + lastName + ", email=" + getEmail() + '}';
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Customer other = (Customer) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
