package com.nitesh.data;

import com.nitesh.data.entities.Address;
import com.nitesh.data.entities.Bank;
import com.nitesh.data.entities.Credential;
import com.nitesh.data.entities.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;

public class Application {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            //session.beginTransaction();
            // session.beginTransaction();
            session.getTransaction().begin();

            User user = new User();
            user.setBirthDate(new Date());
            user.setCreatedBy("Nitesh");
            user.setCreatedDate(new Date());
            user.setEmailAddress("lognitesh97@gmail.com");
            user.setFirstName("Nitesh");
            user.setLastName("Paudel");
            user.setLastUpdatedBy("Nitesh");
            user.setLastUpdatedDate(new Date());

            Credential credential = new Credential();
            credential.setPassword("password1");
            credential.setUsername("kmb385");

            user.setCredential(credential);
            credential.setUser(user);

            session.save(user);
            session.getTransaction().commit();
            session.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            HibernateUtil.getSessionFactory().close();
        }
    }


}

