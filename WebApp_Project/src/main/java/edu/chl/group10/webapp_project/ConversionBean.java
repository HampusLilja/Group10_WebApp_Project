package edu.chl.group10.webapp_project;

import edu.chl.group10.core.Address;
import edu.chl.group10.core.OrderItem;
import edu.chl.group10.core.Product;
import edu.chl.group10.core.ProductList;
import edu.chl.group10.core.ShoppingCart;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PreDestroy;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Very useful to pass data back and forth between pages
 * WILL SURVIVE REDIRECTS, perfect for PRG-pattern
 * @author hampus
 */
@Named("conversation")
@ConversationScoped
public class ConversionBean implements Serializable {

    @Inject // Handled by system, don't need to create class.
    private Conversation conv;
    
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
    private long id;
    private String name;
    private int amount;  //amount of liquid in cl
    private int price;
    private int alcoholProof;
    private String type; //eg. rum, vodka
    
    public void addToCart(long id, int quantity){
 
    }
    
    public void actionListener(Long id, String firstName, String lastName, 
                                        String street, int number, int zip, String town,
                                        String email, String password) {
        if (conv.isTransient()) {
            conv.begin();
             Logger.getAnonymousLogger().log(Level.INFO, "SIGNUP CONVERSATION BEGINS: "
                     + "Got id {0}", id);
        }else{
            
        }
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.street = street;
        this.number = number;
        this.zip = zip;
        this.town = town;
        this.address = new Address(street, number, zip, town);
        this.email = email;
    }
    
    public void deleteActionListener(Long id, String firstName, String lastName, 
            String email) {
                if (conv.isTransient()) {
            conv.begin();
             Logger.getAnonymousLogger().log(Level.INFO, "DELETE CONVERSATION BEGINS: "
                     + "Got id {0}", id);
        }else{
            
        }
        this.ID = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
    
        public String action() {
        if (!conv.isTransient()) {
            conv.end();
             Logger.getAnonymousLogger().log(Level.INFO, "CONVERSATION ENDS");
        }
        try {
            return "customers?faces-redirect=true"; // Go back
        } catch (Exception e) {
            // Not implemented
            //return "error?faces-redirect=true&amp;cause=" + e.getMessage();
            return null;
        }
    }
        
    public void addressActionListener(Long id, String firstName, String lastName, 
            String street, int number, int zip, String town) {
        if (conv.isTransient()) {
            conv.begin();
             Logger.getAnonymousLogger().log(Level.INFO, "ADDRESS CONVERSATION BEGINS: "
                     + "Got id {0}", id);
        }else{
            
        }
        this.ID = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.number = number;
        this.zip = zip;
        this.town = town;
        this.address = new Address(street, number, zip, town);
        // Find person from database...
    }
    
    public String customerAction() {
        if (!conv.isTransient()) {
            conv.end();
             Logger.getAnonymousLogger().log(Level.INFO, "CONVERSATION ENDS");
        }
        try {
            return "customers?faces-redirect=true"; // Go back
        } catch (Exception e) {
            // Not implemented
            //return "error?faces-redirect=true&amp;cause=" + e.getMessage();
            return null;
        }
    }
    
        public void productActionListener(String name, int amount, int price, int alcoholProof, String type) {
        if (conv.isTransient()) {
            conv.begin();
             Logger.getAnonymousLogger().log(Level.INFO, "ADDPRODUCT CONVERSATION BEGINS: "
                     + "Got id {0}", id);
        }else{
            
        }
        this.name = name;
        this.amount = amount;
        this.price = price;
        this.alcoholProof = alcoholProof; 
        this.type = type;
    }
    
     public String productAction() {
        if (!conv.isTransient()) {
            conv.end();
             Logger.getAnonymousLogger().log(Level.INFO, "CONVERSATION ENDS");
        }
        try {
            return "products?faces-redirect=true"; // Go back
        } catch (Exception e) {
            // Not implemented
            //return "error?faces-redirect=true&amp;cause=" + e.getMessage();
            return null;
        }
    }

    @PreDestroy  // MUST HAVE back button etc.
    public void destroy() {
        if (conv != null) {
            if (!conv.isTransient()) {
                conv.end();
            }
        }
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
    
    public String getPassword(){
        return password;
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
    
    public String getEmail(){
        return email;
    }
    
    public void setEmail(String email){
        this.email = email;
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
    
    public void setID(long id){
        this.ID = id;
    }
    public long getId(){
        return id;
    }
    
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setAmount(int amount){
         this.amount = amount;
    }
    public int getAmount(){
        return amount;
    }
    public void setPrice(int price){
        this.price = price;
    }
    public int getPrice(){
        return price;
    }
    public void setAlcoholProof(int alcoholProof){ 
    this.alcoholProof = alcoholProof; 
    }
    public int getAlcoholProof(){
        return alcoholProof;
    }
    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return type;
    }
}
