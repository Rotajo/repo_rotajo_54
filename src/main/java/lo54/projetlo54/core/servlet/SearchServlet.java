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
import lo54.projetlo54.core.repository.FiltresDao;
import lo54.projetlo54.core.repository.LocationDao;

/**
 *
 * @author Syntiche
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
        try (PrintWriter out = response.getWriter()) {
            
        String title;
        String x = request.getParameter("title");
        if (x == null || x.equals("") || x.trim().length() <= 0){
            title = x;
        } else {
            title = "%" + x + "%";
        }
        System.out.println("This is the x: " + x);
        System.out.println("This is the length of x: " + x.trim().length());
        System.out.println("This is the title: " + title);
        
        String year = request.getParameter("year");
        String month = request.getParameter("month");
        String day = request.getParameter("day");        
        String date = year + "-" + month + "-" + day;
        
        String id = request.getParameter("location");
        
        int location = Integer.parseInt(id);
        FiltresDao fd = new FiltresDao();
        List<CourseSession> courseList = fd.filtreSessions(title, date, location);
        
            if (courseList == null || courseList.isEmpty()){
                out.print("<p>Il n'existe pas de formations qui correspondent a vos criteres");
            } else {
                out.println("<table style='width:75%'>");
                out.println("<form method='POST' action='../ProjetLO54/form'>");
                //out.println("<input type='hidden' name='type' value='search'/>");
                for (CourseSession cc : courseList){
                    out.print("<tr><td><input type='radio' name= 'sessionID' value='" + cc.getIdCourseSession() + "'></td><td>" + cc.getCourse().getTitle() + "</td></tr>");
                }
                
                out.println("</table>");
                out.println("<p><input type='submit' value='S'incrire'/></p>");
                out.println("</form>");
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
