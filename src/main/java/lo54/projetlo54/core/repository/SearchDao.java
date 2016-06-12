package lo54.projetlo54.core.repository;

import java.util.List;
import lo54.projetlo54.core.entity.CourseSession;
import lo54.projetlo54.core.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 * DAO class: search course session from data forms
 * @author Jordan, Syntiche, Romina
 */
public class SearchDao {
    
    //Blank constructor
    public SearchDao(){        
    }
    
    /**
     * Filter sessions from data parameters (come from forms)
     * @param title String
     * @param date String
     * @param location int
     */
    public List<CourseSession> filtreSessions(String title, String date, int location){
        List<CourseSession> result = null; //result of the filter

        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction(); // Begin transaction
            
            //Collecting request
            result = session.createQuery("FROM CourseSession p WHERE p.course.title LIKE :titre OR (p.startDate < :date AND p.endDate > :date) OR p.location = :id")
                .setString("titre", title)
                .setString("date", date)
                .setInteger("id", location)
                .list();
        } catch (HibernateException e){
            e.printStackTrace();
            if (session.getTransaction() != null){
                try{
                    session.getTransaction().rollback(); //Undo
                } catch (HibernateException e1){}
            }
        } finally {
            if (session != null){
                session.close(); //Close session
            }
        }
        return result;
    } //End of "filtreSessions"
        
} //End of Class
    
    
   
