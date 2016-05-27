/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lo54.projetlo54.core.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lo54.projetlo54.core.entity.Client;
import lo54.projetlo54.core.entity.Course;
import lo54.projetlo54.core.entity.CourseSession;
import lo54.projetlo54.core.entity.Location;
import lo54.projetlo54.core.repository.ClientDao;
import lo54.projetlo54.core.repository.CourseDao;
import lo54.projetlo54.core.repository.CourseSessionDao;
import lo54.projetlo54.core.repository.LocationDao;

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
        
        // Fetching the course, location, client, and session lists
        List<Course> listCourse = new CourseDao().recupererTout();
        List<Location> listLocation = new LocationDao().recupererTout();
        List<CourseSession> listCourseSession = new CourseSessionDao().recupererTout();
        List<Client> listClient = new ClientDao().recupererTout();
        
        //HTML output and form processing
        try (PrintWriter out = response.getWriter()) {            
            
            //Header HTML 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Inscription aux UV - Catalogue</title>");            
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
            
            // Course table display
            out.println("<h2>Cours disponibles</h2>");
            out.println("<table border=1 class='center' >");
            out.println("<tr>");
            out.println("<th>Code UV</th>");
            out.println("<th>Titre</th>");
            out.println("</tr>");
            for(Course c : listCourse)
                out.print("<tr><td>"+c.getCode()+"</td><td>"+c.getTitle()+"</td></tr>");
            out.print("</table><br>");       
            
            // Location table display
            out.println("<h2>Lieux de cours</h2>");
            out.print("<table border=1 class='center'>");
            out.print("<tr>");
            out.print("<th>ID Lieu</th>");
            out.print("<th>Ville</th>");
            out.print("</tr>");
            for(Location l : listLocation)
                out.print("<tr><td>"+l.getIdLocation()+"</td><td>" + l.getCity() +"</td></tr>");
            out.print("</table><br>");   
            
            // Course session display
            out.println("<h2>Session de cours</h2>");
            out.print("<table border=1 class='center'>");
            out.print("<tr>");
            out.print("<th>ID session</th>");
            out.print("<th>Code UV</th>");
            out.print("<th>Ville</th>");
            out.print("<th>Date Début</th>");
            out.print("<th>Date Fin</th>");
            out.print("</tr>");
            for(CourseSession cs : listCourseSession){
                out.print("<tr>");
                out.print("<td>"+cs.getIdCourseSession()+"</td>");
                out.print("<td>"+cs.getCourse().getCode()+"</td>");
                out.print("<td>"+cs.getLocation().getCity()+"</td>");
                out.print("<td>"+cs.getStartDate()+"</td>");
                out.print("<td>"+cs.getEndDate()+"</td>");
                out.print("</tr>");
            }
            out.print("</table><br>"); 
            
            // Client table display
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
            for(Client cl : listClient){
                out.print("<tr>");
                out.print("<td>"+cl.getIdClient()+"</td>");
                out.print("<td>"+cl.getLastname()+"</td>");
                out.print("<td>"+cl.getFirstname()+"</td>");
                out.print("<td>"+cl.getAddress()+"</td>");
                out.print("<td>"+cl.getPhone()+"</td>");
                out.print("<td>"+cl.getEmail()+"</td>");
                out.print("<td>"+cl.getCourseSession().getCourse().getCode()+"</td>");
                out.print("</tr>");
            }
            out.print("</table><br>");   
            
            // Rest of page HTML
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
