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
            Address address2 = new Address();
            setAddressFields(address);
            setAddressFields2(address2);
            user.getAddress().add(address);
            user.getAddress().add(address2);
            setUserFields(user);
            session.save(user);

            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            HibernateUtil.getSessionFactory().close();
        }
    }

    private static void setUserFields(User user) {
        user.setBirthDate(new Date());
        user.setCreatedBy("kmb");
        user.setCreatedDate(new Date());
        user.setEmailAddress("kmb385");
        user.setFirstName("Kevin");
        user.setLastName("bowersox");
        user.setLastUpdatedBy("kevin");
        user.setLastUpdatedDate(new Date());
    }

    private static void setAddressFields(Address address) {
        address.setAddressLine1("Line 1");
        address.setAddressLine2("Line 2");
        address.setCity("New York");
        address.setState("NY");
        address.setZipCode("12345");
    }
    private static void setAddressFields2(Address address) {
        address.setAddressLine1("Line 3");
        address.setAddressLine2("Line 4");
        address.setCity("Corning");
        address.setState("NY");
        address.setZipCode("12345");
    }
}

