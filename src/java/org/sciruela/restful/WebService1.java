/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sciruela.restful;

/**
 *
 * @author sciruela
 */
import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.mongodb.*;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.GET;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/webservice1")
public class WebService1 {
 
    private static Map<String, Thing> things = new HashMap<String, Thing>();
    private static Mongo m;
    private static DB db;
    private static Datastore ds;

    public static DBCollection getDBCollection(String collection) {
        try {
            m = new Mongo("localhost",27017);
        } catch (UnknownHostException ex) {
        } catch (MongoException ex) {
        }
        db = m.getDB("mydb");
        return db.getCollection(collection);
    }
    
    static{
        DBCollection mydb=getDBCollection("things");
      
        Morphia morphia=new Morphia();
        morphia.map(Thing.class);
        
        DBCursor mycursor=mydb.find();
        List<Thing> listthings=new ArrayList<Thing>();
        while(mycursor.hasNext()){
            BasicDBObject mythings=(BasicDBObject)((DBObject)mycursor.next());
            Thing mything=morphia.fromDBObject(Thing.class, mythings);
            things.put(mything.getId().toString(), mything);
          
        }
                        
     
       
    }
    
    @GET
    @Path("/json/things/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Thing> listEmployeesJSON(){
        return new ArrayList<Thing>(things.values());
    }

    @GET
    @Path("/json/things/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Thing getEmployeeJSON(@PathParam("id")String Id){
        return things.get(Id);        
    }
    
    
}
