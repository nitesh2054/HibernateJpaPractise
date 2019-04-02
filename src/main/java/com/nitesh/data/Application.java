package com.nitesh.data;

import com.nitesh.data.entities.Address;
import com.nitesh.data.entities.Bank;
import com.nitesh.data.entities.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;

public class Application {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            Transaction transaction = session.beginTransaction();

            User user = new User();
            Address address = new Address();
            user.setBirthDate(new Date());
            user.setCreatedDate(new Date());
            user.setCreatedBy("Kevin");
            user.setEmailAddress("kmb3");
            user.setFirstName("Kevin");
            user.setLastName("bowersox");
            user.setLastUpdatedDate(new Date());
            user.setLastUpdatedBy("kmb");
            address.setAddressLine1("Line 1");
            address.setAddressLine2("Line 2");
            address.setCity("Philadelphia");
            address.setState("PA");
            address.setZipCode("12345");
            user.setAddress(address);

            session.save(user);

            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            HibernateUtil.getSessionFactory().close();
        }
    }
}

