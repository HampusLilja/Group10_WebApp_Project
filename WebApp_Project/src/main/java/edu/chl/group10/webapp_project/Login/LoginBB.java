/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.group10.webapp_project.Login;

import edu.chl.group10.core.Customer;
import edu.chl.group10.webapp_project.CustomerCRUDBB.CustomerListBean;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author epinefrema
 */
@Named("accountLogin")
@SessionScoped
public class LoginBB implements Serializable {
    
    private Customer customer;
    private boolean loggedIn = false;
    private Long ID;
    private String email ="Email";
    private String password = "Password";
    
    
    @Inject
    private CustomerListBean customerList;
    
    public LoginBB() {
        
    }
    
    public String login() {
        try {
            this.customer = customerList.find(ID);
            loggedIn = true;
            return "index?faces-redirect=true"; // Go back
        } catch (Exception e) {
            // Not implemented
            //return "error?faces-redirect=true&amp;cause=" + e.getMessage();
            return null;
        }

    }
    
    public void logout() {
        loggedIn = false;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getFirstName() {
        return customer.getFirstName();
    }
    
    public String getLastName() {
        return customer.getLastName();
    }
    
    public String getName() {
        return getFirstName() + " " + getLastName();
    }

    public String getPassword() {
        return password;
    }
    
    public Long getID(){
        try{
            return customer.getID();
        }catch(Exception e){
            System.out.print(e);
        }
        return null;
    }
    
    public boolean isAdmin() {
        return (customer.getIsAdmin());
    }
    
    public boolean isLoggedIn() {
        return loggedIn;
    }
    
    public void setID(Long id) {
            this.ID = id;

    }

}
