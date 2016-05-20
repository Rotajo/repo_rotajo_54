/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lo54.projetlo54.core;

import lo54.projetlo54.core.entity.Client;
import lo54.projetlo54.core.entity.Course;
import lo54.projetlo54.core.entity.CourseSession;
import lo54.projetlo54.core.entity.Location;
import lo54.projetlo54.core.repository.FiltresDao;
import lo54.projetlo54.core.repository.LocationDao;
import lo54.projetlo54.core.service.LocationService;

/**
 * Actions sur la base de données (tests)
 * @author Jordan
 */
public class Application {
        
    public static void main(String[] args) {
       
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
     
        // affichage de toute la table Location
        LocationService locationService = new LocationService();
        locationService.affichageTableEntiere();        
        System.out.println("\n");        
        
        LocationDao ld = new LocationDao();
        System.out.println("Nom de la ville de code 1 = " + ld.nomVille(1));
        
        FiltresDao fd = new FiltresDao();
        for (CourseSession cc : fd.filtreDate("2015-11-01")){
            System.out.println(cc.getIdCourseSession());
        }
        
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
        System.out.println();
*/
    }
} // fin de classe Application
