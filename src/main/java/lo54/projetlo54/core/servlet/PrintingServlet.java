/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javax.servlet.http.HttpSession;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

/**
 *
 * @author Syntiche
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
        response.setContentType("application/x-pdf");
        response.setHeader("Content-disposition", "inline; filename=Inscrits.pdf");
         
         //HttpSession session = request.getSession(true);
        
         try{
            
            //String file = session.getServletContext().getRealPath("./src/main/java/lo54/projetlo54/core/Inscrits.jrxml");
            File file = new File("src/main/java/lo54/projetlo54/core/Inscrits.jasper");
            String path = getServletContext().getRealPath("/WEB-INF/classes/lo54/projectlo54/core/Inscrits.jasper");
            System.out.println("This is the path: " + path);
            System.out.println("current path is: " + file.getAbsolutePath());
            OutputStream outputStream = response.getOutputStream();
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lo54?zeroDateTimeBehavior=convertToNull", "root", "password");
            //JasperReport jasperReport = (JasperReport)JRLoader.loadObjectFromFile("C:/Users/Syntiche/Desktop/Utbm/ProjetLO54/src/main/java/lo54/projetlo54/core/Inscrits.jasper");   
            InputStream input = new FileInputStream(new File("C:/Users/Syntiche/Desktop/Utbm/ProjetLO54/src/main/java/lo54/projetlo54/core/Inscrits.jasper"));
            JasperReport jasperReport = JasperCompileManager.compileReport(input);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, new HashMap(), con);
            //JasperExportManager.exportReportToPdfFile(jasperPrint, "InscritsReport.pdf");
            JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
            //JasperExportManager.exportReportToPdfFile(jasperPrint, "C:/Desktop");
            //JRPdfExporter exporter = new JRPdfExporter();
            //exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
            //exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputStream));
            //SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
            //configuration.setPdfaConformance(PdfaConformanceEnum.PDFA_1A);
            //configuration.setMetadataAuthor("ROTAJO_LO54"); //Set your pdf configurations, 
            //exporter.setConfiguration(configuration);
            //exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
          //qexporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputStream));
          //SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
          //configuration.setPermissions(PdfWriter.AllowCopy | PdfWriter.AllowPrinting);
          //exporter.setConfiguration(configuration);
          //JasperExportManager.exportToPdfFile(jasperPrint, "Etudiants inscrits");
          //exporter.exportReport();
            //exporter.exportReport();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("This didn't work");
        }
         

         
        /* try (PrintWriter out = response.getWriter()) {
            TODO output your page here. You may use following sample code. 
            
            
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
            
            response.setContentType("application/x-pdf");
            response.setHeader("Content-disposition", "inline; filename=myReport.pdf");
            //OutputStream outputStream = response.getOutputStream();
            
            
            // Rest of page HTML
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }*/ 
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
