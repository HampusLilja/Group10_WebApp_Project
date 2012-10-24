package edu.chl.group10.core;

import java.util.logging.Level;
import java.util.logging.Logger;

public enum Group10 {

    INSTANCE;
    private final IWishList wishList = WishList.newInstance();
    private final ICustomerList customerList = new CustomerList("group10_pu");
    private final IProductList productList = new ProductList("group10_pu");

    private Group10() {
        Logger.getAnonymousLogger().log(Level.INFO, "Group alive {0}", this.hashCode());

    }
    
    public IWishList getWishList() {
        return wishList;
    }
    
    public ICustomerList getCustomerList() {
        return customerList;
    }

    public IProductList getProductList() {
        return productList;
    }
}
