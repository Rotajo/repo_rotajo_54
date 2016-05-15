package lo54.projetlo54.core.entity;
// Generated 15 mai 2016 21:15:59 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Course generated by hbm2java
 * @author Jordan 
 */
public class Course  implements java.io.Serializable {


     private String code;
     private String title;
     private Set courseSessions = new HashSet(0);

    public Course() {
    }

	
    public Course(String code, String title) {
        this.code = code;
        this.title = title;
    }
    public Course(String code, String title, Set courseSessions) {
       this.code = code;
       this.title = title;
       this.courseSessions = courseSessions;
    }
   
    public String getCode() {
        return this.code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    public Set getCourseSessions() {
        return this.courseSessions;
    }
    
    public void setCourseSessions(Set courseSessions) {
        this.courseSessions = courseSessions;
    }




}


