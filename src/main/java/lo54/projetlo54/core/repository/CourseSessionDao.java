package lo54.projetlo54.core.repository;

import java.util.List;
import lo54.projetlo54.core.entity.CourseSession;
import lo54.projetlo54.core.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * DAO class: handling CourseSession table
 * @author Jordan, Syntiche, Romina
 */
public class CourseSessionDao {
    
    //Blank constructor
    public CourseSessionDao() {
    }
    
    /**
     * Add location
     * @param c, course session
     */
    public void ajouter(CourseSession c) {
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
    public List<CourseSession> recupererTout() {
        
        List<CourseSession> l = null; //CourseSession list
        
        //Connection to database
        Session session = HibernateUtil.getSessionFactory().openSession();
               
        try {
            session.beginTransaction(); //Begin transaction
            
            //Collecting request
            Query query = session.createQuery("from CourseSession");
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
     * Collect a session from ID
     * @param idSession, CourseSession ID
     * @return the session
     */
    public CourseSession getSession(int idSession)
    {
        CourseSession cs = null;
        
        //Connection to database
        Session session = HibernateUtil.getSessionFactory().openSession();
               
        try {
            session.beginTransaction(); //Begin transaction
            
            //Collecting request
            Query query = session.createQuery("from CourseSession where idCourseSession = :id");
            query.setParameter("id", idSession);
            cs = (CourseSession) query.uniqueResult();
            
                        
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
        
        return cs;
    } //End of "getSession"
    
} //End of Class
