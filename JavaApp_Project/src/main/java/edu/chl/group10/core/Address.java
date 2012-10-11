package edu.chl.group10.core;

import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable
public class Address implements Serializable {

    private String street;
    private int number;
    private int zip;
    private String town;

    public Address() {
    }

    public Address(String street, int number, int zip, String town){
        this.street = street;
        this.zip = zip;
        this.number = number;
        this.town = town;
    }
    public String getStreet(){
        return street;
    }
    public int getNumber() {
        return number;
    }
    public int getZip(){
        return zip;
    }
    public String getTown() {
        return town;
    }

    @Override
    public String toString() {
        return "Address{" + "street=" + street + ", number=" + number + 
                ", zip=" + zip + ", town=" + town + '}';
        
        
    }
    
    
}
