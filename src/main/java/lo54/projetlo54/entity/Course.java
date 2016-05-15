package lo54.projetlo54.entity;

public class Course {
    
    private Integer id;
    private String title;
    
    public Course(){
        id = null;
        title = "";
    }
    
    public Course(String c){
        id = null;
        title = c;
    }
    
    public Course(Course c){
        id = c.getId();
        title = c.getCity();
    }
    
    public Integer getId(){
        return id;
    }
    
    public void setCity(String t){
        title = t;
    }
    
    public String getCity(){
        return title;
    }
    
}
