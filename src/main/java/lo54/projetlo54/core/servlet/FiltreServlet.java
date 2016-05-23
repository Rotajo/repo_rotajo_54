/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lo54.projetlo54.core.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lo54.projetlo54.core.entity.CourseSession;
import lo54.projetlo54.core.repository.FiltresDao;

/**
 *
 * @author Syntiche
 */


public class FiltreServlet extends HttpServlet {

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
        String title = request.getParameter("title");
        /*Calendar date = Calendar.getInstance(); 
        date.set(Calendar.YEAR, Integer.getInteger(request.getParameter("year")));   
        date.set(Calendar.MONTH, Integer.getInteger(request.getParameter("month")));  
        date.set(Calendar.DAY_OF_YEAR, Integer.getInteger(request.getParameter("day")));     
        */
        
        
        String id = request.getParameter("location");
        String year = request.getParameter("year");
        String month = request.getParameter("month");
        String day = request.getParameter("day");
        
        String date = year + "-" + month + "-" + day;
        int location = Integer.parseInt(id);
        //System.out.println("This is what I got: " + title + " " + date);// + " " + location);
        try (PrintWriter out = response.getWriter()) {
            System.out.println("About to check filtres");
            FiltresDao fd = new FiltresDao();
            for (CourseSession cc : fd.filtreSessions(title, date, location)){
                out.print("This is what I got: " +cc.getIdCourseSession());
            }
            //out.print("This is what I got: " + title + " " + date  + " " + location);
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
