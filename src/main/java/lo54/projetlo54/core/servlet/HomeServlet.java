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
 * @author Jordan
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
        
        try (PrintWriter out = response.getWriter()) {
            
            // Récupération des cours
            CourseDao cd = new CourseDao();
            List<Course> listCourse = cd.recupererTout();
            
            // Récupération des lieux
            LocationDao ld = new LocationDao();
            List<Location> listLocation = ld.recupererTout();
            
            // Récupération des session de cours
            CourseSessionDao csd = new CourseSessionDao();
            List<CourseSession> listCourseSession = csd.recupererTout();
            
            // Récupération des étudiants inscrits
            ClientDao cld = new ClientDao();
            List<Client> listClient = cld.recupererTout();
            // =================================================================
            // en-tête HTML
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ListServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<center>");
            out.println("<br><h1><u>Affichage global</u></h1><br><hr>");  
            // =================================================================
            // affichage de la table COURSE
            out.println("<h3><u><i>Cours disponibles :</i></u></h3>");
            out.print("<table border=1>");
            out.print("<tr>");
            out.print("<th>Code UV</th>");
            out.print("<th>Titre</th>");
            out.print("</tr>");
            for(Course c : listCourse){
                out.print("<tr>");
                out.print("<td>"+c.getCode()+"</td>");
                out.print("<td>"+c.getTitle()+"</td>");
                out.print("</tr>");
            }
            out.print("</table><br>");            
            // =================================================================
            // affichage de la table LOCATION
            out.println("<hr><h3><u><i>Lieux de cours :</i></u></h3>");
            out.print("<table border=1>");
            out.print("<tr>");
            out.print("<th>ID Lieu</th>");
            out.print("<th>Ville</th>");
            out.print("</tr>");
            for(Location l : listLocation){
                out.print("<tr>");
                out.print("<td>"+l.getIdLocation()+"</td>");
                out.print("<td>"+l.getCity()+"</td>");
                out.print("</tr>");
            }
            out.print("</table><br>");   
            // =================================================================
            // affichage de la table COURSE_SESSION
            out.println("<hr><h3><u><i>Session de cours :</i></u></h3>");
            out.print("<table border=1>");
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
                out.print("<td>"+ld.nomVille(cs.getLocation().getIdLocation())+"</td>");
                out.print("<td>"+cs.getStartDate()+"</td>");
                out.print("<td>"+cs.getEndDate()+"</td>");
                out.print("</tr>");
            }
            out.print("</table><br>"); 
            // =================================================================
            // affichage de la table CLIENT
            out.println("<hr><h3><u><i>Etudiants inscrits :</i></u></h3>");
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
                out.print("<td>"+csd.codeUV(cl.getCourseSession().getIdCourseSession())+"</td>");
                out.print("</tr>");
            }
            out.print("</table><br>");   
            // =================================================================
            // pieds de page HTML
            out.println("</center>");
            out.println("</body>");
            out.println("</html>");
            
            
            // afficher le fichier.jsp associé
            /*this.getServletContext().getRequestDispatcher( "/jsp/HomeJsp.jsp")
                .forward( request, response );*/
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
