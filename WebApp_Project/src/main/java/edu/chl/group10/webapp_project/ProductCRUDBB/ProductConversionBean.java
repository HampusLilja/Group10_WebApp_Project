package edu.chl.group10.webapp_project.ProductCRUDBB;

import edu.chl.group10.core.Address;
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
@Named("productConversation")
@ConversationScoped
public class ProductConversionBean implements Serializable {

    @Inject // Handled by system, don't need to create class.
    private Conversation conv;

    private long id;
    private String name;
    private int amount;  //amount of liquid in cl
    private int price;
    private int alcoholProof;
    private String type; //eg. rum, vodka
    private boolean pic;


    
    
        public void actionListener(long id, String name, 
                int amount, int price, int alcoholProof, String type, boolean pic) {
        if (conv.isTransient()) {
            conv.begin();
             Logger.getAnonymousLogger().log(Level.INFO, "ADDPRODUCT CONVERSATION BEGINS: "
                     + "Got id {0}", id);
        }else{
            
        }
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.price = price;
        this.alcoholProof = alcoholProof; 
        this.type = type;
        this.pic = pic;
    }
    public void deleteActionListener(long id,String name, 
                int amount, int price, int alcoholProof, String type){
         if (conv.isTransient()) {
            conv.begin();
             Logger.getAnonymousLogger().log(Level.INFO, "DELETE CONVERSATION BEGINS: "
                     + "Got id {0}", id);
        }else{
            
        }
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.price = price;
        this.alcoholProof = alcoholProof; 
        this.type = type;
    }
     public String action() {
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

    public void setID(long id){
        this.id = id;
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
    
    public void setPic(boolean pic){
        this.pic = pic;
    }
    public boolean getPic(){
        return pic;
    }
}
