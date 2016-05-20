/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lo54.projetlo54.core.repository;

import java.util.List;
import lo54.projetlo54.core.entity.Course;
import lo54.projetlo54.core.entity.CourseSession;
import lo54.projetlo54.core.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Syntiche
 */
public class FiltresDao {
    
    public FiltresDao(){
        
    }
    
    public List<Course> filtreTitre(String param){
        List<Course> result = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            result = session.createQuery("FROM Course WHERE title LIKE :titre")
                .setString("titre", "%" + param + "%")
                .list();
        } catch (HibernateException e){
            e.printStackTrace();
            if (session.getTransaction() != null){
                try{
                    session.getTransaction().rollback();
                } catch (HibernateException e1){}
            }
        } finally {
            if (session != null){
                session.close();
            }
        }
        
        return result;
    }
    
    public List<CourseSession> filtreDate(String param){
        List<CourseSession> result = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            result = session.createQuery("FROM CourseSession WHERE startDate < :date AND endDate > :date")
                .setString("date", param)
                .list();
        } catch (HibernateException e){
            e.printStackTrace();
            if (session.getTransaction() != null){
                try{
                    session.getTransaction().rollback();
                } catch (HibernateException e1){}
            }
        } finally {
            if (session != null){
                session.close();
            }
        }
        return result;
    }
    
    /*public List<CourseSession> filtreLieu(String){
        
    }*/
    
    /*String hql = "from Product p inner join p.category";
 
Query query = session.createQuery(hql);
List<Object[]> listResult = query.list();
 
for (Object[] aRow : listResult) {
    Product product = (Product) aRow[0];
    Category category = (Category) aRow[1];
    System.out.println(product.getName() + " - " + category.getName());
}*/
}
    
    
   
