package edu.chl.group10.core;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Herzog
 */
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

    public Product() {
    }
   
    public Product(String name, int amount,int price, int alcoholProof, String type) {
    this.name = name;
    this.amount = amount;
    this.price = price;
    this.alcoholProof = alcoholProof; 
    this.type = type;
    }
    
    public Product(long id, String name, int amount,int price, int alcoholProof, String type) {
    this.id = id;
    this.name = name;
    this.amount = amount;
    this.price = price;
    this.alcoholProof = alcoholProof; 
    this.type = type;
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