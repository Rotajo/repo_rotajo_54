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
import lo54.projetlo54.core.entity.Location;
import lo54.projetlo54.core.repository.LocationDao;

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
        try (PrintWriter out = response.getWriter()) {
            //LocationDao locations = LocationDao
            /* TODO output your page here. You may use following sample code. */
            List<Location> location = new LocationDao().recupererTout();
        request.setAttribute("location", location);
        
        
        request.getRequestDispatcher("/WEB-INF/filtre.jsp").forward(request, response);
            /*out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FiltreServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FiltreServlet at " + request.getContextPath() + "</h1>");
            
            
            out.println("<h1>Recherche liste des formations</h1>");
            
            
            out.println("<form method='GET' action='../ProjetLO54/session'>");
            out.println("<p><label>Par titre</label> : <input type='text' name='title'/></p>");
            out.println("<p><label>Par date</label> : <input type='text' name='date'/></p>");
            out.println("<p><label>Par lieu</label> : <input type='text' name='location'/></p>");
            out.println("<input type='submit' value='Valider'/>");
            out.println("</form>");
            
            out.println("</body>");
            out.println("</html>");*/
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
