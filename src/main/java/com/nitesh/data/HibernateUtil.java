package com.nitesh.data;

import com.nitesh.data.entities.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration();
            StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder();
            configuration.addAnnotatedClass(User.class);
            configuration.addAnnotatedClass(Credential.class);
            configuration.addAnnotatedClass(Account.class);
            configuration.addAnnotatedClass(Transaction.class);
            configuration.addAnnotatedClass(Budget.class);
            configuration.addAnnotatedClass(Bank.class);
            //remove configure for .properties file
            configuration.configure("hibernate.cfg.xml");
            return configuration
                    .buildSessionFactory(standardServiceRegistryBuilder
                    .applySettings(configuration.getProperties())
                    .build());
          /*  return new Configuration().configure()
                    .buildSessionFactory();*/


        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("There was an error building the factory");
        }
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
