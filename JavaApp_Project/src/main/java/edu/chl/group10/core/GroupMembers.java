package edu.chl.group10.core;

import java.util.ArrayList;
import java.util.List;

public final class GroupMembers extends AbstractEntityContainer<Member, Long> implements IGroupMembers {

    private GroupMembers() {
        
    }
   
    public static IGroupMembers newInstance(){
        return new GroupMembers();
    }
    
    @Override
    public List<Member> getByName(String name) {
        List<Member> found = new ArrayList<>();
        for (Member m : getAll()) {
            if (m.getName().equals(name)) {
                found.add(m);
            }
        }
        return found;
    }
}
