package lo54.projetlo54.core.repository;

import java.util.List;
import lo54.projetlo54.core.entity.Course;
import lo54.projetlo54.core.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * DAO class: handling Course table
 * @author Jordan, Syntiche, Romina
 */
public class CourseDao {
    
    //Blank constructor
    public CourseDao() {
    }
    
    /**
     * Add course
     * @param c, course
     */
    public void ajouter(Course c) {
        //Connection to database
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        try {
            session.beginTransaction();         //Begin transaction
            session.persist(c);                 //Add course
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
    }
    
    /**
     * Collect Course table
     * @return list of the whole table
     */
    public List<Course> recupererTout() {
        
        List<Course> l = null;     //Course list
        
        //Connection to database
        Session session = HibernateUtil.getSessionFactory().openSession();
               
        try {
            session.beginTransaction();         //Begin transaction
            
            //Collecting request
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
                session.close(); //Close session
        }
        
        return l;
    } //End of "recupererTout"
    
    /**
     * Collect a course from code
     * @param codeCourse, Course code (=ID)
     * @return the course
     */
    public Course getCourse(String codeCourse)
    {
        Course cs = null;
        
        //Connection to database
        Session session = HibernateUtil.getSessionFactory().openSession();
               
        try {
            session.beginTransaction(); //Begin transaction
            
            //Collecting request
            Query query = session.createQuery("from Course where code = :code");
            query.setParameter("code", codeCourse);
            cs = (Course) query.uniqueResult();
            
                        
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
    }
    
} //End of Class
