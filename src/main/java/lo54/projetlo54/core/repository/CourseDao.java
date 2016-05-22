/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lo54.projetlo54.core.repository;

import java.util.List;
import lo54.projetlo54.core.entity.Course;
import lo54.projetlo54.core.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * Manipulation de la table Course
 * @author Jordan
 */
public class CourseDao {
    
    public CourseDao() {
    }
    
    /**
     * Ajout d'un cours
     * @param c 
     * @author Jordan
     */
    public void ajouter(Course c) {
        // connexion à la base de données
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        try {
            session.beginTransaction();         // début de transaction
            session.persist(c);                 // ajout
            session.getTransaction().commit();  // validation
            
        } catch (HibernateException he) {
            he.printStackTrace();
            if(session.getTransaction() != null) { 
                try {
                    session.getTransaction().rollback();    // retour
                }catch(HibernateException he2) {he2.printStackTrace(); }
            }
            
        } finally {
            if(session != null) 
                session.close();    // fermeture de session
        }
    }
    
    /**
     * Récupère toute la table Course
     * @return la liste de récupération de toute la table
     * @author Jordan
     */
    public List<Course> recupererTout() {
        
        List<Course> l = null;     // liste de récupération
        
        // connexion à la base de données
        Session session = HibernateUtil.getSessionFactory().openSession();
               
        try {
            session.beginTransaction();         // début de transaction
            
            // récupère toute la table Course
            Query query = session.createQuery("from Course");
            l = query.list();
                        
        } catch (HibernateException he) {
            he.printStackTrace();
            if(session.getTransaction() != null) { 
                try {
                    session.getTransaction().rollback();	
                }catch(HibernateException he2) {he2.printStackTrace(); }
            }
            
        } finally {
            if(session != null) 
                session.close();
        }
        
        return l;
    }
    
    /**
     * Récupération d'un cours
     * @param codeCourse  CODE de la table Course
     * @return le cours
     */
    public Course getCourse(String codeCourse)
    {
        Course cs = null;
        
        // connexion à la base de données
        Session session = HibernateUtil.getSessionFactory().openSession();
               
        try {
            session.beginTransaction();         // début de transaction
            
            // récupère la ligne souhaitée de la table Location
            Query query = session.createQuery("from Course where code = :code");
            query.setParameter("code", codeCourse);
            cs = (Course) query.uniqueResult();
            
                        
        } catch (HibernateException he) {
            he.printStackTrace();
            if(session.getTransaction() != null) { 
                try {
                    session.getTransaction().rollback();	
                }catch(HibernateException he2) {he2.printStackTrace(); }
            }
            
        } finally {
            if(session != null) 
                session.close();
        }
        
        return cs;
    }
    
} // fin de classe ClientDao
