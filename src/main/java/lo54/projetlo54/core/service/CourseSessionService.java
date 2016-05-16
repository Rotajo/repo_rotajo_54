/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lo54.projetlo54.core.service;

import java.util.List;
import lo54.projetlo54.core.entity.CourseSession;
import lo54.projetlo54.core.repository.CourseSessionDao;

/**
 * Affichage de la table CourseSession
 * @author Jordan
 */
public class CourseSessionService {
    
    List<CourseSession> l;

    public CourseSessionService() {
    }
    
    /*
     * Affichage entière de la table CourseSession
     * @author Jordan
     */
    public void affichageTableEntiere(){
        
        CourseSessionDao ld = new CourseSessionDao();
        
        l = ld.recupererTout();
        
        for(CourseSession c : l)
            System.out.println(c.toString());
    
    }
}
