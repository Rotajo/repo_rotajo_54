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
import lo54.projetlo54.core.entity.CourseSession;
import lo54.projetlo54.core.entity.Location;
import lo54.projetlo54.core.repository.SearchDao;
import lo54.projetlo54.core.repository.LocationDao;

/**
 * Processes the search paramemter for session and displays the results
 * @author Jordan, Syntiche, Romina
 */
public class SearchServlet extends HttpServlet {

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
        
        //Verifies if the title search parameters is empty 
        //to correctly format it for HQL use
        String title;
        String x = request.getParameter("title");
        //If the parameter is null or empty, not '%' character is added for HQL use
        if (x == null || x.equals("") || x.trim().length() <= 0){
            title = x;
        } else {
            title = "%" + x + "%";
        }

        //Gets all of the date search parameters from the form
        String year = request.getParameter("year");
        String month = request.getParameter("month");
        String day = request.getParameter("day");        
        String date = year + "-" + month + "-" + day;            
            
        //Gets the id of the location search parameter selected
        String id = request.getParameter("location");
        int location = Integer.parseInt(id);
            
        //List that holds the results obtained from the search
        List<CourseSession> courseList = new SearchDao().filtreSessions(title, date, location);

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
            out.println("<h2>Résultats</h2>");
            // Checks if there are any results
            // If no result, user is notify that there are no session corresponding to parameters
            // Otherwise, results are displayed
            if (courseList == null || courseList.isEmpty()){
                out.print("<p>Il n'existe pas de formations qui correspondent a vos criteres");
            } else {
                out.println("<table >");
                out.println("<form method='POST' action='../ProjetLO54/form'>");
                out.println("<th></th><th>UV</th><th>Campus</th><th>Date debut</th><th>Date fin</th>");
                for (CourseSession cc : courseList){
                    out.print("<tr><td><input type='radio' required  name= 'sessionID' value='" + cc.getIdCourseSession() + "'></td><td>" + cc.getCourse().getTitle() + "</td><td>" 
                            + cc.getLocation().getCity()+ "</td><td>"+ cc.getStartDate() + "</td><td>" + cc.getEndDate()+"</td></tr>");
                }
                out.println("</table>");
                out.println("<p style='text-align:center'><input type='submit' value=\"S'incrire\"/></p>");
                out.println("</form>");
                out.println("</div>");
            }
        } catch (Exception e){
            e.printStackTrace();
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
