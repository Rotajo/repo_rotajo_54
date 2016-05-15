package lo54.projetlo54.entity;

import java.sql.Date;

public class CourseSession {
    
    private Integer id;
    private Date startDate;
    private Date endDate;
    private String courseCode;
    private Integer locationId;
    
    public CourseSession(){
        id = null;
        startDate = new Date(0);
        endDate = new Date(10);
        courseCode = "";
        locationId = null;        
    }
    
    public CourseSession(CourseSession c){
        id = c.getId();
        startDate = c.getStartDate();
        endDate = c.getEndDate();
        courseCode = c.getCourseCode();
        locationId = c.getLocationId();
    }

    public Integer getId(){
        return id;
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

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String c) {
        courseCode = c;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer l) {
        locationId = l;
    }
    
    
    
}
