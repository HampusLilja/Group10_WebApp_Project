/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.group10.core;

/**
 *
 * @author Herzog
 */
public class ContactInfo {
    //private final String firstName;
    //private final String lastName;
    private final String phoneNumber;
    private final String email;
    private final String website;
    private final String comments;
    
    public ContactInfo(String phoneNumber, 
            String email,String website,String comments){
        //this.firstName = firstName;
        //this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.website = website;
        this.comments = comments;
    }
    /*
    public String getFirstName(){
        return firstName;
    }
    
    public String getLastName(){
        return lastName;
    }*/
    
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
    /*
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public void setWebsite(String website){
        this.website = website;
    }
    
    public void setComment(String comments){
        this.comments = comments;
    }*/
    
    @Override
    public String toString() {
        return "Contact{" + "email=" + email + ", Phone=" + phoneNumber + 
                ", website=" + website + ", comments=" + comments + '}';
        
        
    }
    
}
