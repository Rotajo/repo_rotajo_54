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
public class FiltresDao {
    
    public FiltresDao(){
        
    }
    
    public List<Course> filtreTitre(String param){
        List<Course> result = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            result = session.createQuery("FROM Course WHERE title LIKE :titre")
                .setString("titre", "%" + param + "%")
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
    
    public List<CourseSession> filtreDate(String param){
        List<CourseSession> result = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            result = session.createQuery("FROM CourseSession WHERE startDate < :date AND endDate > :date")
                .setString("date", param)
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
    
    public List<Course> filtreLocation(int param){
        List<Course> result = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            result = session.createQuery("FROM CourseSession WHERE location = :id")
                .setParameter("id", param)
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
    
    public List<CourseSession> filtreSessions(String title, String date, int location){
        List<CourseSession> result = null;

        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            result = session.createQuery("FROM CourseSession p FETCH ALL PROPERTIES WHERE p.course.title LIKE :titre OR p.startDate < :date AND p.endDate > :date OR p.location = :id")
                .setString("titre", "%" + title + "%")
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
        
        /*if(title != null || "".equals(title)){
            filtreTitre(title);
        }
        if(date != null || "".equals(date)){
            filtreDate(date);
        }
        if(location != 0){
            filtreLocation(location);
        }*/
        
        return result;
    }
    
    
}
    
    
   
