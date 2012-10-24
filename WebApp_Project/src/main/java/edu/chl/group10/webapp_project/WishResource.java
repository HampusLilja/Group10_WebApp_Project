package edu.chl.group10.webapp_project;

import edu.chl.group10.core.Group10;
import edu.chl.group10.core.IWishList;
import edu.chl.group10.core.Wish;
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

@Path("/wish")
public class WishResource {
    
    IWishList wList;
    private final static Logger log = Logger.getAnonymousLogger();
    
    public WishResource() {
         wList = Group10.INSTANCE.getWishList();
    }
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<WishProxy> getAll(){
        List<WishProxy> found = new ArrayList<>();
        for (Wish w : wList.getAll()) {
            found.add(new WishProxy(w));
        }
        log.log(Level.INFO, "getAll");
        return found;
    }
    
    @GET
    @Path("{maxResults}{firstResult}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<WishProxy> getRange(@QueryParam("maxResults") int maxResults,
    @QueryParam("firstResult") int firstResult){
        List<WishProxy> found = new ArrayList<>(); 
        for ( int i = firstResult; i <= maxResults; i++) {
            Wish w = wList.getAll().get(i);
            found.add(new WishProxy(w));
        }
        log.log(Level.INFO, "getRange");
        return found;
    }
    
    @GET
    @Path("count")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String getCount(){
        log.log(Level.INFO, "getCount");
        int t = wList.getCount();
        String s = "" + t;
        return s;
    }
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{anumb}")
    public WishProxy find(@PathParam("anumb") Long anumb) {
        for (Wish w : wList.getAll()) {
            if (w.getID().equals(anumb)) {
                log.log(Level.INFO, "selectByANumb {0}", anumb);
                return new WishProxy(w);
            }
        }
        log.log(Level.INFO, "couldNotFindPNumb {0}", anumb);
        return null;
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
    // Can't return boolean (no message body writer)
    public void add(@FormParam("anumb") Long anumb,
            @FormParam("name") String name,
            @FormParam("size") Double size) {
        log.log(Level.INFO, "add {0}{1}{2}", new Object[]{anumb, name, size});
        Wish w = new Wish(anumb, name, size);
        try {
            wList.update(w);
        } catch (IllegalArgumentException e) {
            throw new WebApplicationException(e);
        }
    }    
  
    @DELETE
    @Path("{anumb}")
    //@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void remove(@PathParam("anumb") Long anumb) {
        log.log(Level.INFO, "Delete {0}", anumb);
        try {
            wList.remove(anumb);
        } catch (IllegalArgumentException e) {
            throw new WebApplicationException(e);
        }
    }
    
    @PUT
    @Path("{anumb}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void update(@PathParam("anumb") Long anumb, @FormParam("name") String name, 
    @FormParam("size") Double size) {
        log.log(Level.INFO, "Put {0}", anumb);
        try {
            wList.update(new Wish(anumb, name, size));
        } catch (IllegalArgumentException e) {
            throw new WebApplicationException(e);
        }
    }
    
}
