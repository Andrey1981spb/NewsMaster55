import com.fasterxml.classmate.AnnotationConfiguration;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.io.File;
import java.net.URISyntaxException;


public class FactoryClass {

    SessionFactory sessionFactory;

    public FactoryClass() {
    }

    public SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {

                Configuration configuration = new Configuration();
                // configuration.configure("hibernate.cfg.xml");
                configuration.configure(new File(getClass().getClassLoader().getResource("hibernate.cfg.xml").toURI()));
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
                        applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());

            } catch (HibernateException exception) {
                System.out.println("Problem creating session factory");
                exception.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}