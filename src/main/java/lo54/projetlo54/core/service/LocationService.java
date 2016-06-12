package lo54.projetlo54.core.service;

import java.util.List;
import lo54.projetlo54.core.entity.Location;
import lo54.projetlo54.core.repository.LocationDao;

/**
 * Display Location table
 * @author Jordan, Syntiche, Romina
 */
public class LocationService {
    
    //Blank constructor
    public LocationService() {
    }
    
    /*
     * Display the whole CourseSession table
     * @return table
     */
    public String affichageTableEntiere(){
        
        LocationDao ld = new LocationDao();     
        List<Location> ll = ld.recupererTout(); //CourseSession list
        String s = ""; //Display in servlet
                
        for(Location l : ll){
            s+="<tr><td>"+l.getIdLocation()
             +"</td><td>" + l.getCity()
             +"</td></tr>";
        }

        return s;
    } //End of "affichageTableEntiere"
    
} //End of Class
