package edu.chl.group10.webapp_project;

import edu.chl.group10.core.Wish;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "wish")
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "WishType", propOrder = {
    "anumb",
    "name",
    "size"
})
public class WishProxy {
    
    private Wish wish;
    
    public WishProxy () {
        
    }
    
    public WishProxy (Wish wish) {
        this.wish = wish;
    }
    
    @XmlElement(name="anumb")
    public Long getAnumb(){
        return wish.getID();
    }
    
    @XmlElement(name="name")
    public String getName(){
        return wish.getName();
    }
    
    @XmlElement(name="size")
    public Double getSize(){
        return wish.getSize();
    }
}
