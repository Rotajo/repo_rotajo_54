package lo54.projetlo54.core.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lo54.projetlo54.core.service.ClientService;
import lo54.projetlo54.core.service.CourseService;
import lo54.projetlo54.core.service.CourseSessionService;
import lo54.projetlo54.core.service.DisplayService;
import lo54.projetlo54.core.service.LocationService;

/**
 * Affichage de toutes les tables de la base de données
 * @author Jordan, Syntiche, Romina
 */
public class HomeServlet extends HttpServlet {

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
        
        // Display classes
        DisplayService display = new DisplayService();
        ClientService clientService = new ClientService();
        CourseService courseService = new CourseService();
        CourseSessionService courseSessionService = new CourseSessionService();
        LocationService locationService = new LocationService();
        
        //HTML output and form processing
        try (PrintWriter out = response.getWriter()) {            
            
            //Header HTML 
            out.print(display.header());
            
            //Navigation pane HTML 
            out.print(display.navigation());
                        
            //Page HTML
            out.println("<div class='main_content'>");
            
            //Course table display
            out.println("<h2>Cours disponibles</h2>");
            out.println("<table border=1 class='center' >");
            out.println("<tr>");
            out.println("<th>Code UV</th>");
            out.println("<th>Titre</th>");
            out.println("</tr>");
            out.print(courseService.affichageTableEntiere()); //The whole table
            out.print("</table><br>");       
            
            //Location table display
            out.println("<h2>Lieux de cours</h2>");
            out.print("<table border=1 class='center'>");
            out.print("<tr>");
            out.print("<th>ID Lieu</th>");
            out.print("<th>Ville</th>");
            out.print("</tr>");
            out.print(locationService.affichageTableEntiere()); //The whole table
            out.print("</table><br>");   
            
            //Course session display
            out.println("<h2>Session de cours</h2>");
            out.print("<table border=1 class='center'>");
            out.print("<tr>");
            out.print("<th>ID session</th>");
            out.print("<th>Code UV</th>");
            out.print("<th>Ville</th>");
            out.print("<th>Date Début</th>");
            out.print("<th>Date Fin</th>");
            out.print("</tr>");
            out.print(courseSessionService.affichageTableEntiere()); //The whole table
            out.print("</table><br>"); 
            
            //Client table display
            out.println("<h2>Etudiants inscrits</h2>");
            out.print("<table border=1>");
            out.print("<tr>");
            out.print("<th>ID Etudiant</th>");
            out.print("<th>Nom de famille</th>");
            out.print("<th>Prénom</th>");
            out.print("<th>Adresse</th>");
            out.print("<th>Numéro de téléphone</th>");
            out.print("<th>Email</th>");
            out.print("<th>Code UV</th>");
            out.print("</tr>");
            out.print(clientService.affichageTableEntiere()); //The whole table
            out.print("</table><br>");   
            
            // Rest of page HTML
            out.print("</div>");
            out.print(display.restPage());
        } //End of try
        
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

}
