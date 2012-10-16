package edu.chl.group10.webapp_project;

import edu.chl.group10.core.Group10;
import edu.chl.group10.core.IProductList;
import edu.chl.group10.core.IShoppingCart;
import edu.chl.group10.core.Product;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Herzog
 */
@Named("ShoppingCartBean")
@SessionScoped
public class ShoppingCartBean implements Serializable {
    
    private IShoppingCart sclist;
    public ShoppingCartBean (){

    }    
}

