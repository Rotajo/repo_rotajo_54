package lo54.projetlo54.core.repository;

import java.util.List;
import lo54.projetlo54.core.entity.Location;
import lo54.projetlo54.core.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * DAO class: handling Location table
 * @author Jordan, Syntiche, Romina
 */
public class LocationDao {
    
    public LocationDao() {
    }
    
    /**
     * Add location
     * @param l location
     */
    public void ajouter(Location l) {
        //Connection to database
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        try {
            session.beginTransaction();         //Begin transaction
            session.persist(l);                 //Add Location
            session.getTransaction().commit();  //Validation
            
        } catch (HibernateException he) {
            he.printStackTrace();
            if(session.getTransaction() != null) { 
                try {
                    session.getTransaction().rollback(); //Undo
                }catch(HibernateException he2) {he2.printStackTrace(); }
            }
            
        } finally {
            if(session != null) 
                session.close(); //Close session
        }
    } //End of "ajouter"
    
    /**
     * Collect Location table
     * @return list of the whole table
     */
    public List<Location> recupererTout() {
        
        List<Location> l = null; //Location list
        
        //Connection to database
        Session session = HibernateUtil.getSessionFactory().openSession();
               
        try {
            session.beginTransaction(); //Begin transaction
            
            //Collecting request
            Query query = session.createQuery("from Location");
            l = query.list();
                        
        } catch (HibernateException he) {
            he.printStackTrace();
            if(session.getTransaction() != null) { 
                try {
                    session.getTransaction().rollback(); //Undo	
                }catch(HibernateException he2) {he2.printStackTrace(); }
            }
            
        } finally {
            if(session != null) 
                session.close(); //Close session
        }
        
        return l;
    } //End of "recupererTout"
    
} //End of Class
