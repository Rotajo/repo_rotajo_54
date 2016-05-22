/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lo54.projetlo54.core.repository;

import java.util.List;
import lo54.projetlo54.core.entity.CourseSession;
import lo54.projetlo54.core.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * Manipulation de la table CourseSession
 * @author Jordan
 */
public class CourseSessionDao {
    
    public CourseSessionDao() {
    }
    
    /**
     * Ajout d'une location
     * @param c session de cours
     */
    public void ajouter(CourseSession c) {
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
     * Récupère toute la table CourseSession
     * @return la liste de récupération de toute la table
     * @author Jordan
     */
    public List<CourseSession> recupererTout() {
        
        List<CourseSession> l = null;     // liste de récupération
        
        // connexion à la base de données
        Session session = HibernateUtil.getSessionFactory().openSession();
               
        try {
            session.beginTransaction();         // début de transaction
            
            // récupère toute la table CourseSession
            Query query = session.createQuery("from CourseSession");
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
     * Récupération d'une session de cours
     * @param idSession ID de la table CourseSession
     * @return la session
     */
    public CourseSession getSession(int idSession)
    {
        CourseSession cs = null;
        
        // connexion à la base de données
        Session session = HibernateUtil.getSessionFactory().openSession();
               
        try {
            session.beginTransaction();         // début de transaction
            
            // récupère la ligne souhaitée de la table Location
            Query query = session.createQuery("from CourseSession where idCourseSession = :id");
            query.setParameter("id", idSession);
            cs = (CourseSession) query.uniqueResult();
            
                        
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
    
} // fin de classe CourseSessionDao
