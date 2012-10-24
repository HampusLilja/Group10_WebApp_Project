package edu.chl.group10.core;

import java.util.List;

public interface IWishList extends IEntityContainer<Wish, Long> {

    List<Wish> getByName(String name);
    
}
