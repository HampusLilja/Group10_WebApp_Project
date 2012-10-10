package edu.chl.group10.core;

public class Address {

    private final String street;
    private final int number;
    private final int zip;
    private final String town;

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
