/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lo54.projetlo54.core.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lo54.projetlo54.core.entity.CourseSession;
import lo54.projetlo54.core.repository.CourseSessionDao;

/**
 * Course session registration form
 * @author Jordan, Syntiche, Romina
 */
public class FormServlet extends HttpServlet {

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
        
        //Initialises the session DAO and populates a list with all of the session currently available
        CourseSessionDao csd = new CourseSessionDao();
        List<CourseSession> listCourseSession = csd.recupererTout();
        
        //Variables
        int searchID = 0;       //integer used to hold id of session selected if a search was done
        boolean search;        //boolean determining if a search was made prior to registering
        
        //Checks if a search was made prior to registering
        //and makes visible true if it was
        try{
            searchID = Integer.parseInt(request.getParameter("sessionID"));
            search = true;
        } catch (Exception e) {
            e.printStackTrace();
            search = false;
        }
        
        //HTML output and form processing
        try (PrintWriter out = response.getWriter()) {
            
            //Header HTML 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Inscription aux UV - Inscription</title>");  
            out.println("<link rel='stylesheet' href='../ProjetLO54/CSS/style.css' type='text/css' media='screen' />");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='title'>");
            out.println("<a href='../ProjetLO54/index.html'>");
            out.println("<img class='image' id='head_logo' src='UTBM_Logo.jpg' alt='UTBM Logo'/></a>");
            out.println("<h1>Inscription aux UV en ligne</h1>");
            out.println("<h3>PROJET LO54 </h3>");
            out.println("</div>");
            // Navigation pane HTML 
            out.println("<div class='navigation'>");
            out.println("<ul class='navigation'>");
            out.println("<li class='navigation'><a href='../ProjetLO54/home'>Accéder aux tables</a></li>");
            out.println("<li class='navigation'><a href='../ProjetLO54/form'>Inscription</a></li>");
            out.println("<li class='navigation'><a href='search.jsp'>Rechercher</a></li>");
            out.println("</ul>");
            out.println("</div>");
            
            // Page HTML
            out.println("<div class='main_content'>");
            out.println("<h2>Inscription</h2>");
            // Class registration form  
            out.println("<form method='POST' action='../ProjetLO54/session'>");
            out.println("<table >");
            out.println("<tr><td>Nom de famille (*)</td> <td><input type='text' name='lastname'maxlength='30' placeholder='ex : ROBERT' autofocus required/></td></tr>");
            out.println("<tr><td>Prénom (*)</td> <td> <input type='text' name='firstname' maxlength='30' placeholder='ex : Julien' required/></td></tr>");
            out.println("<tr><td>Adresse (*)</td><td><input type='text' name='address' maxlength='100' placeholder='22 Rue Cler PARIS' required/></td></tr>");
            out.println("<tr><td>Numéro de téléphone (*)</td> <td> <input type='tel' name='phone' maxlength='15' placeholder='ex : 06 12 34 56 78' required/></td></tr>");
            out.println("<tr><td>Email</td> <td><input type='email' name='email' maxlength='50' placeholder='ex : xxx@yyy.zz'/></td></tr>");
            out.println("</table>");
            
            // Second half of page
            // Checks if a search was made prior to registration             
            // If a search was made, the selected session will be displayed
            // otherwise, the list of session will be displayed
            if (search){
                CourseSession ses = new CourseSession(csd.getSession(searchID));
                out.println("<input type='hidden' name='searchID' value='"+ searchID+"'/>");
                out.println("<p>Vous vous inscrivez a l'UV suivante:</p>");
                out.println(ses.getCourse().getTitle());
                out.println("<p>Commencant:  " + ses.getStartDate() + "</p>");
                out.println("<p>Situe: "+ ses.getLocation().getCity() + "</p>");
            } else {
                out.println("<h3><Cours disponibles></h3>");
                out.println("<table >");
                out.println("<th></th><th>UV</th><th>Campus</th><th>Date debut</th><th>Date fin</th>");
                for (CourseSession cc : listCourseSession){
                    out.print("<tr><td><input type='radio' required  name= 'sessionID' value='" + cc.getIdCourseSession() + "'></td><td>" + cc.getCourse().getTitle() + "</td><td>" 
                            + cc.getLocation().getCity()+ "</td><td>"+ cc.getStartDate() + "</td><td>" + cc.getEndDate()+"</td></tr>");
                }
                out.println("</table>");
            }
            
            // Rest of form HTML
            out.println("<p style='text-align:center'><input type='submit' value='Valider'/></p>");
            out.println("</form>");
            out.println("</div>"); 
            out.println("</body>");
            out.println("</html>");
        }
    }

    

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
