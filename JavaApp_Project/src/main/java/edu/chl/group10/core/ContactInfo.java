package edu.chl.group10.core;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author Herzog & Hampus
 */
@Embeddable
public class ContactInfo implements Serializable{
    private String phoneNumber;
    private String email;
    private String website;
    private String comments;

    public ContactInfo() {
    }
    
    public ContactInfo(String phoneNumber, 
            String email,String website,String comments){
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.website = website;
        this.comments = comments;
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
    
    @Override
    public String toString() {
        return "Contact{" + "email=" + email + ", Phone=" + phoneNumber + 
                ", website=" + website + ", comments=" + comments + '}';
        
        
    }
    
}
