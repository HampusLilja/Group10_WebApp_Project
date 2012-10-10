package edu.chl.group10.webapp_project;

import edu.chl.group10.core.Member;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "member")
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "MemberType", propOrder = {
    "pnumb",
    "name"
})
public class MemberProxy {
    
    private Member member;
    
    public MemberProxy () {
        
    }
    
    public MemberProxy (Member member) {
        this.member = member;
    }
    
    @XmlElement(name="pnumb")
    public long getPnumb(){
        return member.getID();
    }
    
    @XmlElement(name="name")
    public String getName(){
        return member.getName();
    }
}
