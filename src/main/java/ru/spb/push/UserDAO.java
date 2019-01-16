package ru.spb.push;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.spb.FactoryClass;
import ru.spb.push.Pushdata;

import java.util.List;

public class UserDAO {

    public UserDAO() {

    }

    FactoryClass factoryClass = new FactoryClass();

    public void save(Object object) {
        Session session = factoryClass.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(object);
        session.flush();
        tx1.commit();
        session.close();
    }

    public void update(Object object) {
        Session session = factoryClass.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(object);
        tx1.commit();
        session.close();
    }

    public void delete(Object object) {
        Session session = factoryClass.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(object);
        tx1.commit();
        session.close();
    }

    public List<Newsdata> getAll () {
        Session session = factoryClass.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        List dataList = session.createQuery("from Newsdata").list();
        tx1.commit();
        session.close();
        return dataList;
    }

}
