package ru.spb.push.directions;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.spb.FactoryClass;
import ru.spb.push.Pushdata;
import ru.spb.push.UserDAO;

import java.util.List;

public class DirModifier {

    UserDAO userDAO = new UserDAO();
    FactoryClass factoryClass = new FactoryClass();

    public DirModifier() {

    }

    public Directiondata findDirectiondata(long id) {
        //return userDAO.findById(id);
        return factoryClass.getSessionFactory().openSession().get(Directiondata.class, id);
    }

    public void saveDirectiondata(Directiondata directiondata) {
        userDAO.save(directiondata);
    }

    public void deleteDirectiondata(Directiondata directiondata) {
        userDAO.delete(directiondata);
    }

    public void updateDirectiondata(Directiondata directiondata) {
        userDAO.update(directiondata);
    }

    public List<Directiondata> findAllDirectiondata() {

        Session session = factoryClass.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        List dataList = session.createQuery("from Directiondata").list();
        tx1.commit();
        session.close();
        return dataList;


    }

}
