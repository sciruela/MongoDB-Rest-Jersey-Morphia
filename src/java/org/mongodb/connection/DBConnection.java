/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mongodb.connection;


import com.mongodb.*;
import java.net.UnknownHostException;

public class DBConnection {

    private static Mongo m;
    private static DB db;
    private static String[] mystrings=new String[100];
    private static DBCursor mycursor;
    private static int i=0;

    public static DBCollection getDBCollection(String collection) {
        try {
            m = new Mongo("localhost", 27017);
        } catch (UnknownHostException ex) {
        } catch (MongoException ex) {
        }
        db = m.getDB("mydb");
        return db.getCollection(collection);
    }
    
}
