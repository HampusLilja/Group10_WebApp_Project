package edu.chl.group10.core;

public class Wish implements IEntity<Long> {

    private final Long anumb;
    private final String name;
    private final Double size;

    public Wish(Long anumb, String name, Double size) {
        this.anumb = anumb;
        this.name = name;
        this.size = size;
        
    }
    
    public String getName() {
        return name;
    }
    
    public Double getSize() {
        return size;
    }
    
    @Override
    public Long getID() {
        return anumb;
    }

    @Override
    public String toString() {
        return "Wish{" + "anumb=" + anumb + ", name=" + 
                name + ", size=" + size + '}';
    }

   
}