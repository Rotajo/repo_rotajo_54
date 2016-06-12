package lo54.projetlo54.core.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

/**
 * Print into PDF the list of clients grouped by session course
 * @author Jordan, Syntiche, Romina
 */
public class PrintingServlet extends HttpServlet {

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
        //Set the content type and the name of the pdf file
        response.setContentType("application/x-pdf");
        response.setHeader("Content-disposition", "inline; filename=Inscrits.pdf");
        
         try{
            String path = getServletContext().getRealPath("/WEB-INF/Inscrits.jrxml"); //Path to the file corresponding to the report shape
            File file = new File(path);
            OutputStream outputStream = response.getOutputStream();
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lo54?zeroDateTimeBehavior=convertToNull", "root", "password");
            InputStream input = new FileInputStream(file);
            JasperReport jasperReport = JasperCompileManager.compileReport(input); //Compile le jrxml file
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, new HashMap(), con); //Connect the report and database
            JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream); //Export in PDF
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("This didn't work");
        }
      
    } //End of "processRequest"

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
