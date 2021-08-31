package com.home.register.test;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    static {
        // get services registry
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml") // read settings from hibernate.cfg.xml (should be in classpath)
                .build();

        try {
            // lets use metadata of objects mapping
            sessionFactory = new MetadataSources( registry )
                    .buildMetadata()
                    .buildSessionFactory();
            //now sessionFactory have settings, mappings, how to handle all of that
        } catch (Exception e) {
            // if trouble occurs destroy the session
            System.out.println("Exception when building session factory: " + e.getMessage());
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
