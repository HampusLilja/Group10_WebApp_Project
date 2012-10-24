package edu.chl.group10.core;

import java.util.ArrayList;
import java.util.List;

public final class WishList extends AbstractEntityContainer<Wish, Long> implements IWishList {

    private WishList() {
        
    }
   
    public static IWishList newInstance(){
        return new WishList();
    }
    
    @Override
    public List<Wish> getByName(String name) {
        List<Wish> found = new ArrayList<>();
        for (Wish m : getAll()) {
            if (m.getName().equals(name)) {
                found.add(m);
            }
        }
        return found;
    }
}
