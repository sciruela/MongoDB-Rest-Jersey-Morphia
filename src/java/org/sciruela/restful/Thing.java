/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sciruela.restful;

/**
 *
 * @author sciruela
 */
import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import javax.xml.bind.annotation.XmlRootElement;
import org.bson.types.ObjectId;



@Entity("things")
@XmlRootElement 
public class Thing {
    
    @Id private ObjectId id;
    private String x;
    private String j;
    
    

    public String getId() {
        return id.toString();
    }
    

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getJ() {
        return j;
    }

    public void setJ(String j) {
        this.j = j;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }
    
}
