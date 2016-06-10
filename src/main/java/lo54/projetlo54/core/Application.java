/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lo54.projetlo54.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.text.ParseException;
import lo54.projetlo54.core.entity.Client;
import lo54.projetlo54.core.entity.Course;
import lo54.projetlo54.core.entity.CourseSession;
import lo54.projetlo54.core.entity.Location;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
/**
 * Actions sur la base de données (tests)
 * @author Jordan
 */
public class Application {
        
    public static void main(String[] args) throws ParseException {
       
        Client cl;          // client
        Course co;          // cours
        CourseSession cs;   // session de cours
        Location lo;        // localisation
        
        System.out.println("Classe Application : OK !\n");
                
        // ajout simple d'un cours
        /*co = new Course("LO54", "Java Enterprise Applications Architectures and Development Frameworks");
        CourseDao courseDao = new CourseDao();
        courseDao.ajouter(co);*/
        
        
        // ajout simple d'une localisation
 /*       lo = new Location("Troyes");
        LocationDao locationDao = new LocationDao();
        locationDao.ajouter(lo);
  */              
        // ajout simple d'une session de coursDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        
        // format de date : AAAA-1900 et MM-1
 /*       Date sqlDate1 = new Date(2016-1900, 01-1, 01);
        Date sqlDate2 = new Date(2016-1900, 12-1, 31);
        
        Course ccc = new Course();      ccc.setCode("SM57");
        Location lll = new Location();  lll.setIdLocation(1);
        
        cs = new CourseSession(ccc, lll, sqlDate1, sqlDate2);
        CourseSessionDao csd = new CourseSessionDao();
        csd.ajouter(cs);
        
        System.out.println("\ndone !");
*/        
        // affichage de toute la table Location
 /*       LocationService locationService = new LocationService();
        locationService.affichageTableEntiere();        
        System.out.println("\n");        
        
        LocationDao ld = new LocationDao();
        System.out.println("Nom de la ville de code 1 = " + ld.nomVille(1));
        
        CourseSession cc : fd.filtreSessions("de", "2015-11-01", 1
 
        System.out.println("About to check filtres");
        SearchDao fd = new SearchDao();
        for (CourseSession cc : fd.filtreSessions("de", "2015-11-01", 1)){
            System.out.println(cc.getIdCourseSession());
        }*/
        
        //CourseSessionDao csd = new CourseSessionDao();
        
       /* File file = new File("src/main/java/lo54/projetlo54/core/Inscrits.jasper");
        //C:\Users\Syntiche\Desktop\Utbm\ProjetLO/54\src\main\java\lo54\projetlo54\core\Inscrits.jasper
        System.out.println("This is the location of the file: " + file.getAbsolutePath());
        if (file.exists()){
            System.out.println("This file exists and nothing makes sense, I should choose another career choice");
        } else {
            System.out.println("The file doesn't exists, which still sucks cause idk why the error but at least, yay consistency");
        }
        
        File testFile = new File("");
        String currentPath = testFile.getAbsolutePath();
        System.out.println("current path is: " + currentPath);
     
        
        
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lo54?zeroDateTimeBehavior=convertToNull", "root", "password");
            JasperReport jasperReport = (JasperReport)JRLoader.loadObjectFromFile("src/main/java/lo54/projetlo54/core/Inscrits.jasper");   
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null ,con );
            //JasperExportManager.exportReportToPdfFile("Inscrits.jrprint");
            JRPdfExporter exporter = new JRPdfExporter();
            exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
            exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(System.out));
            SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
            configuration.setMetadataAuthor("Petter"); //Set your pdf configurations, 
            exporter.setConfiguration(configuration);
            exporter.exportReport();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("This didn't work");
        }
        
        */
        
        

       
        // affichage de toute la table Course
/*        CourseService courseService = new CourseService();
        courseService.affichageTableEntiere();
        System.out.println();
        
        // affichage de toute la table CourseSession
        CourseSessionService courseSessionService = new CourseSessionService();
        courseSessionService.affichageTableEntiere();        
        System.out.println();
        
        // affichage de toute la table Client
        ClientService clientService = new ClientService();
        clientService.affichageTableEntiere();
 */
    }
} // fin de classe Application
