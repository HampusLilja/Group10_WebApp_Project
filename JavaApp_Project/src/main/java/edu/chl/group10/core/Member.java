package edu.chl.group10.core;

public class Member implements IEntity<Long> {

    private final Long pnumb;
    private final String name;

    public Member(Long pnumb, String name) {
        this.pnumb = pnumb;
        this.name = name;
        
    }
    
    public String getName() {
        return name;
    }
    
    @Override
    public Long getPnumb() {
        return pnumb;
    }

    @Override
    public String toString() {
        return "Product{" + "pnumb=" + pnumb + ", name=" + name + '}';
    }

   
}