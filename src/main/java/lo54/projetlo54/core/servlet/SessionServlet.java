package lo54.projetlo54.core.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lo54.projetlo54.core.entity.Client;
import lo54.projetlo54.core.entity.CourseSession;
import lo54.projetlo54.core.repository.ClientDao;
import lo54.projetlo54.core.repository.CourseSessionDao;
import lo54.projetlo54.core.service.DisplayService;

/**
 * Process registration form, adds student to session, and display changes made
 * @author Jordan, Syntiche, Romina
 */
public class SessionServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        
        //Display class
        DisplayService display = new DisplayService();
        
        // Variable used to hold the id of course selected 
        Integer id = null;
        //DAO object used to connect to the Client table in the DB
        ClientDao cld = new ClientDao();        
        
        //Gets the hidden parameters (from search or just registration) from the form
        String sessionID = request.getParameter("sessionID");
        String searchID = request.getParameter("searchID");
            
        // Assigns the id value from whichever parameter was initialized with a value
        if (sessionID != null){
            id = Integer.parseInt(sessionID);
        } else if (searchID != null){
            id = Integer.parseInt(searchID);
        } 
        
        //Gets the session that was selected based on its id
        CourseSession cs = new CourseSession(new CourseSessionDao().getSession(id));
        //Gets list of students registered in the same session selected during registration
        List<Client> listClient = cld.getClientsForSession(id);
        
        // Adds a client object based on values entered in the form (including the session selected)
        // Note: no checking so done on the parameters because of measures put on the form
        cld.ajouter(new Client(cs, 
                                request.getParameter("lastname"),
                                request.getParameter("firstname"),
                                request.getParameter("address"),
                                request.getParameter("phone"), 
                                request.getParameter("email")));

        //HTML output and form processing
        try (PrintWriter out = response.getWriter()) {
            
            //Header HTML 
            out.print(display.header());
            
            //Navigation pane HTML 
            out.print(display.navigation());
            
            // Page HTML
            out.println("<div class='main_content'>");
            out.println("<h2>Session de cours et étudiants inscrits</h2>");  
            
            // Displays registration information entered in the DB          
            out.println("<h3><u>Vos coordonnées :</u></h3>"); 
            out.println("<table>");
            out.println("<tr><td><b>Nom de famille </b><br></td> <td>"+request.getParameter("firstname")+"</td></tr>");
            out.println("<tr><td><b>Prénom </b><br></td> <td>"+request.getParameter("lastname")+"</td></tr>");
            out.println("<tr><td><b>Adresse </b><br></td> <td>"+request.getParameter("address")+"</td></tr>");
            out.println("<tr><td><b>Numéro </b><br></td> <td>"+request.getParameter("phone")+"</td></tr>");
            out.println("<tr><td><b>Email </b><br></td> <td>"+request.getParameter("email")+"</td></tr>"); 
            out.println("</table>");
            
            //Displays the session selected by the user
            out.println("<h3><u>Vous avez choisi la session :</u></h3>");
            out.print("<table border=1 class='center'>");
            out.print("<tr>");
            out.print("<th>ID session</th><th>Code UV</th><th>Titre</th><th>Ville</th><th>Date Début</th><th>Date Fin</th></tr>");
            out.print("<td>"+cs.getIdCourseSession()+"</td>");
            out.print("<td>"+cs.getCourse().getCode()+"</td>");
            out.print("<td>"+cs.getCourse().getTitle()+"</td>");
            out.print("<td>"+cs.getLocation().getCity()+"</td>");
            out.print("<td>"+cs.getStartDate()+"</td>");
            out.print("<td>"+cs.getEndDate()+"</td>");
            out.print("</tr>");
            out.print("</table><br>"); 

            //Displays the student registered in the same session as the one selected by the user
            out.println("<h2>Les étudiants inscrits</h2>");
            out.print("<table border=1 class='center'>");
            out.print("<tr>");
            out.print("<th>ID Etudiant</th><th>Nom de famille</th><th>Prénom</th><th>Adresse</th><th>Numéro de téléphone</th><th>Email</th></tr>");
            for(Client cl : listClient){
                out.print("<tr>");
                out.print("<td>"+cl.getIdClient()+"</td>");
                out.print("<td>"+cl.getLastname()+"</td>");
                out.print("<td>"+cl.getFirstname()+"</td>");
                out.print("<td>"+cl.getAddress()+"</td>");
                out.print("<td>"+cl.getPhone()+"</td>");
                out.print("<td>"+cl.getEmail()+"</td>");
                out.print("</tr>");
            }
            out.print("</table><br>"); 
            
            // Rest of page HTML
            out.print(display.restPage());
        }
    } //End of "processRequest"

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

} //End of Class