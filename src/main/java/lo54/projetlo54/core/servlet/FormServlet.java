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
 * Formulaire d'inscription à une session de cours
 * @author Jordan
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
        int searchID = 0;
        boolean visible;
        //CourseSessionDao csd = new CourseSesson
        try{
            searchID = Integer.parseInt(request.getParameter("sessionID"));
            visible = true;
        } catch (Exception e) {
            e.printStackTrace();
            visible = false;
        }
        CourseSessionDao csd = new CourseSessionDao();
            List<CourseSession> listCourseSession = csd.recupererTout();
        
        try (PrintWriter out = response.getWriter()) {
            
            // =================================================================
            // en-tête HTML
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Inscription UV</title>");  
            out.println("<link rel='stylesheet' href='../ProjetLO54/CSS/style.css' type='text/css' media='screen' />");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='wrapper'>");
            out.println("<div class='title'> <h1>S'inscrire à une UV :</h1></div>");
            // =================================================================
            // Formulaire d'inscription à une session de cours  
            out.println("<table style='width:30%'>");

           // out.println("<input type='hidden' name='type' value='register'/>");
            out.println("<form method='POST' action='../ProjetLO54/session'>");

            out.println("<p><label><b>Nom de famille (*)</b></label> : <input type='text' name='lastname'/></p>");
            out.println("<p><label><b>Prénom (*)</b></label> : <input type='text' name='firstname'/></p>");
            out.println("<p><label><b>Adresse (*)</b></label> : <input type='text' name='address'/></p>");
            out.println("<p><label><b>Numéro de téléphone (*)</b></label> : <input type='tel' name='phone'/></p>");
            out.println("<p><label><b>Email</b></label> : <input type='email' name='email'/></p>");
            
            out.println("<br><input type='submit' value='Valider'/>");
            
            if (visible){
                CourseSession ses = new CourseSession(csd.getSession(searchID));
                out.println("<input type='hidden' name='searchID' value='"+ searchID+"'/>");
                out.println("<p>Vous vous inscrivez a l'UV suivante:</p>");
                out.println(ses.getCourse().getTitle());
                out.println("<p>Commencant:  " + ses.getStartDate() + "</p>");
                out.println("<p>Situe: "+ ses.getLocation().getCity() + "</p>");
            } else {
                for (CourseSession cc : listCourseSession){
                    out.print("<tr><td><input type='radio' name= 'sessionID' value='" + cc.getIdCourseSession() + "'></td><td>" + cc.getCourse().getTitle() + "</td></tr>");
                }
            }
            // sauvegarde de l'id de la session choisie par l'utilisateur
            //out.println("<input type='hidden' name='sessionID' value='"' />");
//>>>>>>> origin/master
            out.println("</form>");
            //request.setAttribute("searchID", searchID);
            //request.getRequestDispatcher("/session").forward(request, response);
            
            // =================================================================
            // pieds de page HTML
//<<<<<<< HEAD
            out.println("</div>"); 
//=======
            out.println("<br><hr><br><i>(*) champs obligatoires</i>"); 
            out.println("</center>"); 
//>>>>>>> origin/master
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
