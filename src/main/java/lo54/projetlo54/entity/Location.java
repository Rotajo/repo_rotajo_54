package lo54.projetlo54.entity;

public class Location {
    
    private Integer id;
    private String city;
    
    public Location(){
        id = null;
        city = "";
    }
    
    public Location(String c){
        id = null;
        city = c;
    }
    
    public Location(Location l){
        id = l.getId();
        city = l.getCity();
    }
    
    public Integer getId(){
        return id;
    }
    
    public void setCity(String c){
        city = c;
    }
    
    public String getCity(){
        return city;
    }
    
}
