package edu.chl.group10.webapp_project;

import edu.chl.group10.core.Address;
import edu.chl.group10.core.ContactInfo;
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
    private String phoneNumber;
    private String email;
    private String website;
    private String comments;
    private ContactInfo contactInfo;
    private String password;

    public void actionListener(Long id, String firstName, String lastName, 
            String street, int number, int zip, String town, String phoneNumber,
            String email, String website, String comments, String password) {
        if (conv.isTransient()) {
            conv.begin();
             Logger.getAnonymousLogger().log(Level.INFO, "SIGNUP CONVERSATION BEGINS: "
                     + "Got id {0}", id);
        }else{
            
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.street = street;
        this.number = number;
        this.zip = zip;
        this.town = town;
        this.address = new Address(street, number, zip, town);
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.website = website;
        this.comments = comments;
        this.contactInfo = new ContactInfo(
                phoneNumber, email, website, comments);
        // Find person from database...
    }
    
    public void contactActionListener(Long id, String firstName, String lastName, 
            String phoneNumber, String email, String website, String comments) {
        if (conv.isTransient()) {
            conv.begin();
             Logger.getAnonymousLogger().log(Level.INFO, "CONTACT CONVERSATION BEGINS: "
                     + "Got id {0}", id);
        }else{
            
        }
        this.ID = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.website = website;
        this.comments = comments;
        this.contactInfo = new ContactInfo(
                phoneNumber, email, website, comments);
        // Find person from database...
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
    
    public ContactInfo getContactInfo(){
        return contactInfo;
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
    
    public void setContactInfo(String phoneNumber, String email, String website,
            String comments){
        this.contactInfo = new ContactInfo(
                phoneNumber, email, website, comments);
    }
    
    public void setID(long id){
        this.ID = id;
    }
}
