/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lo54.projetlo54.core.repository;

import java.util.List;
import lo54.projetlo54.core.entity.Course;
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
        String queryString = "FROM COURSE WHERE TITLE LIKE '%:title%' ORDER BY CODE;";
        try{
            session.beginTransaction();
            result = session.createQuery(queryString)
                .setString("title", param)
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
    
    
   
