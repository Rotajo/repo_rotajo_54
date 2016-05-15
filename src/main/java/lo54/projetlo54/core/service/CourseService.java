/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lo54.projetlo54.core.service;

import java.util.List;
import lo54.projetlo54.core.entity.Course;
import lo54.projetlo54.core.repository.CourseDao;

/**
 * Affichage de la table Course
 * @author Jordan
 */
public class CourseService {
    
    Course c;
    List<Course> l;

    public CourseService() {
    }
    
    public Course getC() {
        return c;
    }

    public void setC(Course c) {
        this.c = c;
    }

    /**
     * Affichage entière de la table Course
     * @author Jordan
     */
    public void affichageTableEntiere(){
        
        CourseDao cd = new CourseDao();
        
        l = cd.recupererTout();
        
        for(Course cc : l)
            System.out.println(cc.properties());
    
    }
}
