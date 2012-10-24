package edu.chl.group10.webapp_project.ProductCRUDBB;

import edu.chl.group10.core.Product;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named("addProduct")
@RequestScoped
public class AddProductBB {
    private long id;
    private String name;
    private int amount;  //amount of liquid in cl
    private int price;
    private int alcoholProof;
    private String type; //eg. rum, vodka
    private boolean pic;
   
    @Inject
    private ProductListBean productList;

    public AddProductBB(){
    
    }
    
    public void addProduct(String name, int amount, int price, int alcoholProof, String type, boolean pic) {
        this.name = name;
        this.amount = amount;
        this.price = price;
        this.alcoholProof = alcoholProof; 
        this.type = type;
        this.pic = pic;
        
       productList.add(new Product(id, name, amount, price, alcoholProof, type, pic));
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
    
    public String submit() {
        
        return "addPictureToProduct?faces-redirect=true&name=" + name;
    }
}