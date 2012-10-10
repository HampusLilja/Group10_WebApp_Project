package edu.chl.group10.webapp_project;

import edu.chl.group10.core.ContactInfo;
import edu.chl.group10.core.Customer;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Hampus
 */
@Named("editContactDetails")
@RequestScoped
public class EditContactDetailsBB {
    
    private long ID;
    private ContactInfo contactInfo;
    private String phoneNumber;
    private String email;
    private String website;
    private String comments;

    public EditContactDetailsBB(){
        
    }
    @Inject
    private CustomerListBean customerList;
    
    
    public void editContactDetails(Long id, String firstName, String lastName, 
            String phoneNumber, String email, String website, String comments){
        Customer customer = customerList.find(id);
        customerList.remove(id);

        this.phoneNumber = phoneNumber;
        this.email = email;
        this.website = website;
        this.comments = comments;
        this.contactInfo = new ContactInfo(
                phoneNumber, email, website, comments);
        
        customerList.add(new Customer(id, firstName, lastName, 
                customer.getAddress(), contactInfo, customer.getPassword()));
    }
    
    public void setContactInfo(String phoneNumber, String email, String website, 
            String comments){
        this.contactInfo = new ContactInfo(
                phoneNumber, email, website, comments);
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
    
    public void setID(long id){
        this.ID = id;
    }
    
    
}

