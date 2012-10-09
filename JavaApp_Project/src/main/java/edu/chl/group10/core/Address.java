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
    /*
    public void setStreet(String street){
        this.street = street;
    }
    public void setNumber(int number){
        this.number = number;
    }
    public void setZip(int zip){
        this.zip = zip;
    }
    public void setTown(String town) {
        this.town = town;
    }*/

    @Override
    public String toString() {
        return "Address{" + "street=" + street + ", number=" + number + 
                ", zip=" + zip + ", town=" + town + '}';
        
        
    }
    
    
}
