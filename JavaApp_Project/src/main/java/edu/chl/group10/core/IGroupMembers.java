package edu.chl.group10.core;

import java.util.List;

public interface IGroupMembers extends IEntityContainer<Member, Long> {

    List<Member> getByName(String name);
    
}
