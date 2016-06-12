package lo54.projetlo54.core.repository;

import java.util.List;
import lo54.projetlo54.core.entity.Client;
import lo54.projetlo54.core.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * DAO class: handling Client table
 * @author Jordan, Syntiche, Romina
 */
public class ClientDao {
    
    //Blank constructor
    public ClientDao() {
    }
    
    /**
     * Add client
     * @param c, client
     */
    public void ajouter(Client c) {
        //Connection to database
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        try {
            session.beginTransaction();         //Begin transaction
            session.persist(c);                 //Add client
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
     * Collect Client table
     * @return list of the whole table
     */
    public List<Client> recupererTout() {
        
        List<Client> l = null; //Client list
        
        //Connection to database
        Session session = HibernateUtil.getSessionFactory().openSession();
               
        try {
            session.beginTransaction(); //Begin transaction
            
            //Collecting request
            Query query = session.createQuery("from Client");
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
    
    /**
     * Collect clients of a courseSession
     * @param idSession, CourseSession ID
     * @return list of clients with good CourseSession ID
     */
    public List<Client> getClientsForSession(int idSession) {
        List<Client> l = null; //Client list
        
        //Connection to database
        Session session = HibernateUtil.getSessionFactory().openSession();
               
        try {
            session.beginTransaction(); //Begin transaction
            
            //Collecting request
            Query query = session.createQuery("from Client where courseSession.idCourseSession = :id");
            query.setParameter("id", idSession);
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
    } //End of "getClientsForSession"
    
} //End of Class
