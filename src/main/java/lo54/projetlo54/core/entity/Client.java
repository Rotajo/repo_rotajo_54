package lo54.projetlo54.core.entity;

/**
 * Client class: used to host the student information
 * @author Jordan, Syntiche, Romina 
 * 
 */
public class Client implements java.io.Serializable {

    //ATTRIBUTES
    private Integer idClient;
    private CourseSession courseSession;
    private String lastname;
    private String firstname;
    private String address;
    private String phone;
    private String email;

    //Blank constructor
    public Client() {
    }
	
    /**Constructor initializing attributes with the exception of the student's selected class session
     * @param l
     * @param f
     * @param a
     * @param p 
     */
    public Client(String l, String f, String a, String p) {
        lastname = l;
        firstname = f;
        address = a;
        phone = p;
    }
    
    /**Constructor initliazing all necessary attributes
     * @param c
     * @param l
     * @param f
     * @param a
     * @param p
     * @param e 
     */
    public Client(CourseSession c, String l, String f, String a, String p, String e) {
       courseSession = c;
       lastname = l;
       firstname = f;
       address = a;
       phone = p;
       email = e;
    }
   
    //SETTERS AND GETTERS
    public Integer getIdClient() {
        return idClient;
    }
    
    public void setIdClient(Integer i) {
        idClient = i;
    }
    public CourseSession getCourseSession() {
        return courseSession;
    }
    
    public void setCourseSession(CourseSession c) {
        courseSession = c;
    }
    public String getLastname() {
        return lastname;
    }
    
    public void setLastname(String l) {
        lastname = l;
    }
    public String getFirstname() {
        return firstname;
    }
    
    public void setFirstname(String f) {
        firstname = f;
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

    //Overriding of toString function to display info about a client
    @Override
    public String toString() {
        return "Client{" + "idClient=" + idClient + ", lastname=" + lastname + ", firstname=" + firstname + ", address=" + address + ", phone=" + phone + ", email=" + email + ", courseSession=" + courseSession.getIdCourseSession() + '}';
    }

}


