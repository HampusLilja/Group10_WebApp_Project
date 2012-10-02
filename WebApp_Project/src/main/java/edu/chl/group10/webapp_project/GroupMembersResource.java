package edu.chl.group10.webapp_project;

import edu.chl.group10.core.Group10;
import edu.chl.group10.core.IGroupMembers;
import edu.chl.group10.core.Member;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

@Path("/members")
public class GroupMembersResource {
    
    IGroupMembers gmem;
    private final static Logger log = Logger.getAnonymousLogger();
    
    public GroupMembersResource() {
         gmem = Group10.INSTANCE.getGroupMembers();
         if( gmem.getCount() == 0 ){
             gmem.update(new Member(10l, "Tom"));
             gmem.update(new Member(11l, "Ham"));
         }
    }
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<MemberProxy> getAll(){
        List<MemberProxy> found = new ArrayList<MemberProxy>();
        for (Member m : gmem.getAll()) {
            found.add(new MemberProxy(m));
        }
        log.log(Level.INFO, "getAll");
        return found;
    }
    
    @GET
    @Path("{maxResults}{firstResult}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<MemberProxy> getRange(@QueryParam("maxResults") int maxResults,
    @QueryParam("firstResult") int firstResult){
        List<MemberProxy> found = new ArrayList<MemberProxy>(); 
        for ( int i = firstResult; i <= maxResults; i++) {
            Member m = gmem.getAll().get(i);
            found.add(new MemberProxy(m));
        }
        log.log(Level.INFO, "getRange");
        return found;
    }
    
    @GET
    @Path("count")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String getCount(){
        log.log(Level.INFO, "getCount");
        int t = gmem.getCount();
        String s = "" + t;
        return s;
    }
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{pnumb}")
    public MemberProxy find(@PathParam("pnumb") long pnumb) {
        for (Member m : gmem.getAll()) {
            if (m.getPnumb().equals(pnumb)) {
                log.log(Level.INFO, "selectByPNumb {0}", pnumb);
                return new MemberProxy(m);
            }
        }
        log.log(Level.INFO, "couldNotFindPNumb {0}", pnumb);
        return null;
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
    // Can't return boolean (no message body writer)
    public void add(@FormParam("pnumb") Long pnumb,
            @FormParam("name") String name) {
        log.log(Level.INFO, "add {0}{1}{2}", new Object[]{pnumb, name});
        Member m = new Member(pnumb, name);
        try {
            gmem.update(m);
        } catch (IllegalArgumentException e) {
            throw new WebApplicationException(e);
        }
    }
  
    @DELETE
    @Path("{pnumb}")
    //@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void remove(@PathParam("pnumb") Long pnumb) {
        log.log(Level.INFO, "Delete {0}", pnumb);
        try {
            gmem.remove(pnumb);
        } catch (IllegalArgumentException e) {
            throw new WebApplicationException(e);
        }
    }
    
    @PUT
    @Path("{pnumb}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void update(@PathParam("pnumb") Long pnumb, @FormParam("name") String name) {
        log.log(Level.INFO, "Put {0}", pnumb);
        try {
            gmem.update(new Member(pnumb, name));
        } catch (IllegalArgumentException e) {
            throw new WebApplicationException(e);
        }
    }
    
}
