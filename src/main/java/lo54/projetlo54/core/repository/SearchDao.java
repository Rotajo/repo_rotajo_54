/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lo54.projetlo54.core.repository;

import java.util.List;
import lo54.projetlo54.core.entity.Course;
import lo54.projetlo54.core.entity.CourseSession;
import lo54.projetlo54.core.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Syntiche
 */
public class SearchDao {
    
    //Blank constructor
    public SearchDao(){        
    }
    
    /**
     * Selection d'une session basé sur les paramètres donnés
     * @param title String
     * @param date String
     * @param location int
     */
    public List<CourseSession> filtreSessions(String title, String date, int location){
        List<CourseSession> result = null;

        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            result = session.createQuery("FROM CourseSession p WHERE p.course.title LIKE :titre OR (p.startDate < :date AND p.endDate > :date) OR p.location = :id")
                .setString("titre", title)
                .setString("date", date)
                .setInteger("id", location)
                .list();
        } catch (HibernateException e){
            e.printStackTrace();
            if (session.getTransaction() != null){
                try{
                    session.getTransaction().rollback();
                } catch (HibernateException e1){}
            }
        } finally {
            if (session != null){
                session.close();
            }
        }
        return result;
    }
    
    
}
    
    
   
