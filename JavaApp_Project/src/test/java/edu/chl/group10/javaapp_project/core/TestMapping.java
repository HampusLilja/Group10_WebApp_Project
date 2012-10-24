package edu.chl.group10.javaapp_project.core;

import org.junit.Test;

public class TestMapping {

    @Test
    public void createAllTables() {
        new Mapper().persistCustomer();
    }

}
