package lo54.projetlo54.core.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Location: class used to host the code and name of a campus location
 * @author Jordan, Syntiche, Romina
 */
public class Location  implements java.io.Serializable {

    private Integer idLocation;
    private String city;
    private Set courseSessions = new HashSet(0);

    public Location() {
    }

    public Location(String c) {
        city = c;
    }
    
    public Integer getIdLocation() {
        return idLocation;
    }
    
    public void setIdLocation(Integer i) {
        idLocation = i;
    }
    public String getCity() {
        return city;
    }
    
    public void setCity(String c) {
        city = c;
    }
    public Set getCourseSessions() {
        return courseSessions;
    }
    
    public void setCourseSessions(Set c) {
        courseSessions = c;
    }

    @Override
    public String toString() {
        return "Location{" + "idLocation=" + idLocation + ", city=" + city + '}';
    }

}


