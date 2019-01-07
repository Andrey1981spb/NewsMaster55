package ru.spb;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class FactoryClass {

    SessionFactory sessionFactory;

    public FactoryClass() {
    }

    public SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                configuration.configure();
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().configure();

                sessionFactory = configuration.buildSessionFactory(builder.build());

            } catch (HibernateException exception) {
                System.out.println("Problem creating session factory");
                exception.printStackTrace();
            }
        }
        return sessionFactory;
    }
}