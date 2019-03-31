package com.nitesh.data;

import com.nitesh.data.entities.TimeTest;
import com.nitesh.data.entities.User;
import org.hibernate.Session;

import java.util.Date;

public class Application {
    public static void main(String [] args){
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
           session.beginTransaction();
            TimeTest test = new TimeTest(new Date());
            session.save(test);
            session.getTransaction().commit();
            session.refresh(test);
            System.out.println(test.toString());
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
