package edu.chl.group10.javaapp_project.core;

import org.junit.Test;

/**
 * This will create all the tables (for inspection)
 * 
 * MUST Have Derby running with a "test" database, see persistence.xml
 * 
 * After run: Inspect database tables and fk's 
 */
public class TestMapping {

    @Test
    public void createAllTables() {
        // This will create all tables (from entity classes)
        new Mapper().persistCustomer();
        //new Mapper().persistOneToOneUni();
    }

}
