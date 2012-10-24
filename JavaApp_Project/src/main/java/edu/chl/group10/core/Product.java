package edu.chl.group10.core;

import java.io.File;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product implements Serializable{
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private long id;
   private String name;
   private int amount;  //amount of liquid in ml
   private int price;
   private int alcoholProof;
   private String type; //eg. rum, vodka
   private String link;
   private boolean pic;

    public Product() {
    }
   
    public Product(String name, int amount,int price, int alcoholProof, String type, boolean pic) {
    this.name = name;
    this.amount = amount;
    this.price = price;
    this.alcoholProof = alcoholProof; 
    this.type = type;
    this.link = "client/img/" + name + ".jpg";
    this.pic = pic;
    }
    
    public Product(long id, String name, int amount,int price, int alcoholProof, String type, boolean pic) {
    this.id = id;
    this.name = name;
    this.amount = amount;
    this.price = price;
    this.alcoholProof = alcoholProof; 
    this.type = type;
    this.link = "client/img/" + name + ".jpg";
    this.pic = pic;
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
    public void setLink(String link){
        this.link = link;
    }
    public String getLink(){
        return link;
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
    
    public void setPic(boolean pic){
        this.pic = pic;
    }
    
    public boolean getPic(){
        return pic;
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