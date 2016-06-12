package lo54.projetlo54.core.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * CourseSession: class used to hold information about a course session
 * - what course is held
 * - where is it held
 * - when does it begin and end
 * @author Jordan, Syntiche, Romina
 */
public class CourseSession  implements java.io.Serializable {

    //ATTRIBUTES
    private Integer idCourseSession;
    private Course course;
    private Location location;
    private Date startDate;
    private Date endDate;
    private Set clients = new HashSet(0);

    //Blank constructor
    public CourseSession() {
    }
    
    /**Constructor initialising the date attributes
     * @param s, startDate
     * @param e, endDate
     */
    public CourseSession(Date s, Date e) {
        startDate = s;
        endDate = e;
    }
	
    /**Constructor initialising all attributes     * 
     * @param c, course
     * @param l, location
     * @param s, startDate
     * @param e, endDate
     * @param cl, clients
     */
    public CourseSession(Course c, Location l, Date s, Date e, Set cl) {
       course = c;
       location = l;
       startDate = s;
       endDate = e;
       clients = cl;
    }
    
    /**Constructor initializing a session without any clients
     * @param c, course
     * @param l, location
     * @param s, startDate
     * @param e, endDate
     */
    public CourseSession(Course c, Location l, Date s, Date e) {
       course = c;
       location = l;
       startDate = s;
       endDate = e;
    }
    
    //Constructor initialising a session from another session (duplication)
    public CourseSession(CourseSession cs){
        idCourseSession = cs.getIdCourseSession();
        course = cs.getCourse();
        location = cs.getLocation();
        startDate = cs.getStartDate();
        endDate = cs.getEndDate();
    }
   
     //SETTERS AND GETTERS
    public Integer getIdCourseSession() {
        return idCourseSession;
    }
    
    public void setIdCourseSession(Integer i) {
        idCourseSession = i;
    }
    public Course getCourse() {
        return course;
    }
    
    public void setCourse(Course c) {
        course = c;
    }
    public Location getLocation() {
        return location;
    }
    
    public void setLocation(Location l) {
        location = l;
    }
    public Date getStartDate() {
        return startDate;
    }
    
    public void setStartDate(Date s) {
        startDate = s;
    }
    public Date getEndDate() {
        return endDate;
    }
    
    public void setEndDate(Date e) {
        endDate = e;
    }
    public Set getClients() {
        return clients;
    }
    
    public void setClients(Set c) {
        clients = c;
    }

    //Overriding of toString function to display info about a session
    @Override
    public String toString() {
        return "CourseSession{" + "idCourseSession=" + idCourseSession + ", course=" + course.getCode() + ", location=" + location.getIdLocation() + ", startDate=" + startDate + ", endDate=" + endDate + '}';
    }

} //End of Class


