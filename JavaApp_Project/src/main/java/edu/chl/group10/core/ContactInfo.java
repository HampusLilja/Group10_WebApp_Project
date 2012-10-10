package edu.chl.group10.core;

/**
 *
 * @author Herzog & Hampus
 */
public class ContactInfo {
    private final String phoneNumber;
    private final String email;
    private final String website;
    private final String comments;
    
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
