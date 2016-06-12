package lo54.projetlo54.core.service;

import java.util.List;
import lo54.projetlo54.core.entity.CourseSession;
import lo54.projetlo54.core.repository.CourseSessionDao;

/**
 * Display CourseSession table
 * @author Jordan, Syntiche, Romina
 */
public class CourseSessionService {
    
    //Blank constructor
    public CourseSessionService() {
    }
    
    /*
     * Display the whole CourseSession table
     * @return table
     */
    public String affichageTableEntiere(){
        
        CourseSessionDao cd = new CourseSessionDao();     
        List<CourseSession> l = cd.recupererTout(); //CourseSession list
        String s = ""; //Display in servlet
        
        for(CourseSession cs : l){
            s+="<tr>"
             +"<td>"+cs.getIdCourseSession()+"</td>"
             +"<td>"+cs.getCourse().getCode()+"</td>"
             +"<td>"+cs.getLocation().getCity()+"</td>"
             +"<td>"+cs.getStartDate()+"</td>"
             +"<td>"+cs.getEndDate()+"</td>"
             +"</tr>";
        }
        
        return s;
    } //End of "affichageTableEntiere"
    
} //End of Class
