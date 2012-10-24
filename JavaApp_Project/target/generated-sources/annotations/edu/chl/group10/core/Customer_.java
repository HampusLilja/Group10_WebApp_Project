package edu.chl.group10.core;

import edu.chl.group10.core.Address;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2012-10-24T14:58:51")
=======
@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2012-10-24T16:22:13")
>>>>>>> imageupload
@StaticMetamodel(Customer.class)
public class Customer_ { 

    public static volatile SingularAttribute<Customer, Long> id;
    public static volatile SingularAttribute<Customer, String> lastName;
    public static volatile SingularAttribute<Customer, String> email;
    public static volatile SingularAttribute<Customer, Address> address;
    public static volatile SingularAttribute<Customer, Boolean> isAdmin;
    public static volatile SingularAttribute<Customer, String> firstName;
    public static volatile SingularAttribute<Customer, String> password;

}