/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lo54.projetlo54.core.repository;

import lo54.projetlo54.core.entity.Client;
import lo54.projetlo54.core.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 * Manipulation de la table Client
 * @author Jordan
 */
public class ClientDao {
    
    public ClientDao() {
    }
    
    /**
     * Ajout d'un client
     * @param c 
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
    
    
} // fin de classe ClientDao
