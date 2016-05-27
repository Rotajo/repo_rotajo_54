/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lo54.projetlo54.core.repository;

import java.util.List;
import lo54.projetlo54.core.entity.Location;
import lo54.projetlo54.core.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * Manipulation de la table Localisation
 * @author Jordan
 */
public class LocationDao {
    
    public LocationDao() {
    }
    
    /**
     * Ajout d'un lieu
     * @param l location
     */
    public void ajouter(Location l) {
        // connexion à la base de données
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        try {
            session.beginTransaction();         // début de transaction
            session.persist(l);                 // ajout
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
     * Récupère toute la table Location
     * @return la liste de récupération de toute la table
     */
    public List<Location> recupererTout() {
        
        List<Location> l = null;     // liste de récupération
        
        // connexion à la base de données
        Session session = HibernateUtil.getSessionFactory().openSession();
               
        try {
            session.beginTransaction();         // début de transaction
            
            // récupère toute la table Location
            Query query = session.createQuery("from Location");
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
    
    
    
} // fin de classe LocationDao
