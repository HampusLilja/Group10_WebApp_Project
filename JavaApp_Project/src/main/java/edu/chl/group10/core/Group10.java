package edu.chl.group10.core;

import java.util.logging.Level;
import java.util.logging.Logger;

public enum Group10 {

    INSTANCE;
    private final IGroupMembers groupMembers = GroupMembers.newInstance();

    private Group10() {
        Logger.getAnonymousLogger().log(Level.INFO, "Group alive {0}", this.hashCode());

    }
    
    public IGroupMembers getGroupMembers() {
        return groupMembers;
    }
}
