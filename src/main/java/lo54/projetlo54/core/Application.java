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
import lo54.projetlo54.core.repository.CourseDao;
import lo54.projetlo54.core.service.CourseService;

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
        
        System.out.println("Classe Application : OK !");
                
        // ajout simple d'un cours
        //co = new Course("LO54", "Java Enterprise Applications Architectures and Development Frameworks");
        //co = new Course("LO43", "Bases fondamentales de la programmation orientée objet");
        
        //CourseDao courseDao = new CourseDao();
        //courseDao.ajouter(co);
     
        
        // affichage de toute la table Course
        CourseService courseService = new CourseService();
        courseService.affichageTableEntiere();

    }
} // fin de classe Application
