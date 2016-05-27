/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lo54.projetlo54.core.repository;

import java.util.List;
import lo54.projetlo54.core.entity.Client;
import lo54.projetlo54.core.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * DAO class: Manipulation de la table Client
 * @author Jordan, Syntiche, Romina
 */
public class ClientDao {
    
    //Blank constructor
    public ClientDao() {
    }
    
    /**
     * Ajout d'un client
     * @param c client
     */
    public void ajouter(Client c) {
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
     * Récupère toute la table Client
     * @return la liste de récupération de toute la table
     * @author Jordan
     */
    public List<Client> recupererTout() {
        
        List<Client> l = null;     // liste de récupération
        
        // connexion à la base de données
        Session session = HibernateUtil.getSessionFactory().openSession();
               
        try {
            session.beginTransaction();         // début de transaction
            
            // récupère toute la table Client
            Query query = session.createQuery("from Client");
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
    public List<Client> getClientsForSession(int idSession)
    {
        List<Client> l = null;     // liste de récupération
        
        // connexion à la base de données
        Session session = HibernateUtil.getSessionFactory().openSession();
               
        try {
            session.beginTransaction();         // début de transaction
            
            // récupère la ligne souhaitée de la table Location
            Query query = session.createQuery("from Client where courseSession.idCourseSession = :id");
            query.setParameter("id", idSession);
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
    
} // fin de classe ClientDao
