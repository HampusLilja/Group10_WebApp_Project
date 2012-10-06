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
    private String firstName;
    private String lastName;
    private String email;
    private String website;
    private String comments;
    
    public ContactInfo(String firstName,String lastName,String email,String website,String comments){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.website = website;
        this.comments = comments;
    }
    
    public String getFirstName(){
        return firstName;
    }
    
    public String getLastName(){
        return lastName;
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
    
}
