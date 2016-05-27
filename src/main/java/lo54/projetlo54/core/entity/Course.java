package lo54.projetlo54.core.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Course class: used to contain information for a course
 * @author Jordan, Syntiche, Romina
 */
public class Course  implements java.io.Serializable {
    //Attributes
    private String code;
    private String title;
    private Set courseSessions = new HashSet(0);

    //Blank constructor
    public Course() {
    }
	
    /**Constructor initializing code and title attributes
     * @param c
     * @param t 
     */
    public Course(String c, String t) {
        code = c;
        title = t;
    }
    
    /**Constructor initializing all attributes 
     * @param c
     * @param t
     * @param cs 
     */
    public Course(String c, String t, Set cs) {
       code = c;
       title = t;
       courseSessions = cs;
    }
    
    //SETTERS AND GETTERS
    public String getCode() {
        return code;
    }
    
    public void setCode(String c) {
        code = c;
    }
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String t) {
        title = t;
    }
    public Set getCourseSessions() {
        return courseSessions;
    }
    
    public void setCourseSessions(Set c) {
        courseSessions = c;
    }

    //Overriding of toString function to display info about a course
    @Override
    public String toString() {
        return "Course{" + "code=" + code + ", title=" + title + '}';
    }

}


