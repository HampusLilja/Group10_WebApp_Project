/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductCRUDBB;

import edu.chl.group10.core.Product;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Herzog
 */
@Named("editProduct")
@RequestScoped
public class EditProductBB {
    private long id;
    private String name;
    private int amount;  //amount of liquid in cl
    private int price;
    private int alcoholProof;
    private String type; //eg. rum, vodka
   
    @Inject
    private ProductListBean productList;
    
    public EditProductBB(){
        
    }
    
    public void editProduct(long id, String name, int amount, int price,
                                        int alcoholProof, String type){

        productList.remove(id);
        productList.add(new Product(id, name, amount, price, alcoholProof, type));
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
