package lo54.projetlo54.core.entity;
// Generated 15 mai 2016 21:15:59 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * CourseSession generated by hbm2java
 * @author Jordan 
 */
public class CourseSession  implements java.io.Serializable {


     private Integer idCourseSession;
     private Course course;
     private Location location;
     private Date startDate;
     private Date endDate;
     private Set clients = new HashSet(0);

    public CourseSession() {
    }

	
    public CourseSession(Date startDate, Date endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }
    public CourseSession(Course course, Location location, Date startDate, Date endDate, Set clients) {
       this.course = course;
       this.location = location;
       this.startDate = startDate;
       this.endDate = endDate;
       this.clients = clients;
    }
   
    public Integer getIdCourseSession() {
        return this.idCourseSession;
    }
    
    public void setIdCourseSession(Integer idCourseSession) {
        this.idCourseSession = idCourseSession;
    }
    public Course getCourse() {
        return this.course;
    }
    
    public void setCourse(Course course) {
        this.course = course;
    }
    public Location getLocation() {
        return this.location;
    }
    
    public void setLocation(Location location) {
        this.location = location;
    }
    public Date getStartDate() {
        return this.startDate;
    }
    
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public Date getEndDate() {
        return this.endDate;
    }
    
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    public Set getClients() {
        return this.clients;
    }
    
    public void setClients(Set clients) {
        this.clients = clients;
    }




}

