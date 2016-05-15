package lo54.projetlo54.entity;

// test

public class Client {
    
    private Integer id;
    private String lastName;
    private String firstName;
    private String address;
    private String phone;
    private String email;
    private Integer courseSessionId;
    
    public Client(){
        id = null;
        lastName = "";
        firstName = "";
        address = "";
        phone = "";
        email = null;
        courseSessionId = null;
    }
    
    public Client(String l, String f, String a, String p, String e, Integer c){
        id = null;
        lastName = l;
        firstName = f;
        address = a;
        phone = p;
        email = e;
        courseSessionId = c;    
    }
    
    public Client(Client c){
        id = c.getId();
        lastName = c.getLastName();
        firstName = c.getFirstName();
        address = c.getAddress();
        phone = c.getPhone();
        email = c.getEmail();
        courseSessionId = getCourseSessionId();
    }

    public Integer getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String l) {
        lastName = l;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String f) {
        firstName = f;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String a) {
        address = a;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String p) {
        phone = p;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String e) {
        email = e;
    }

    public Integer getCourseSessionId() {
        return courseSessionId;
    }

    public void setCourseSessionId(Integer c) {
        courseSessionId = c;
    }
    
    
    
}
