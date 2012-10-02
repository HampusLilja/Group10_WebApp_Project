package edu.chl.group10.webapp_project;

import com.sun.jersey.api.json.JSONConfiguration;
import com.sun.jersey.api.json.JSONJAXBContext;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.JAXBContext;

@Provider
public class ContextResolver implements javax.ws.rs.ext.ContextResolver<JAXBContext>{

    private JAXBContext context;
    private Class[] types = {MemberProxy.class};

    public ContextResolver() throws Exception {
        this.context = new JSONJAXBContext(JSONConfiguration.natural().build(),
                types);
    }

    @Override
    public JAXBContext getContext(Class<?> objectType) {
        return (types[0].equals(objectType)) ? context : null;
    }
}
