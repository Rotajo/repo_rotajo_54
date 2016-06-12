package lo54.projetlo54.core.service;

import java.util.List;
import lo54.projetlo54.core.entity.Course;
import lo54.projetlo54.core.repository.CourseDao;

/**
 * Display CourseSession table
 * @author Jordan, Syntiche, Romina
 */
public class CourseService {
    
    //Blank constructor
    public CourseService() {
    }

    /**
     * Display the whole Client table
     * @return table
     */
    public String affichageTableEntiere(){
        
        CourseDao cd = new CourseDao();     
        List<Course> l = cd.recupererTout(); //Course list
        String s = ""; //Display in servlet
        
        for(Course c : l){
            s+="<tr><td>"+c.getCode()
             +"</td><td>"+c.getTitle()
             +"</td></tr>";
        }
    
        return s;
    } //End of "affichageTableEntiere"
    
} //End of Class
