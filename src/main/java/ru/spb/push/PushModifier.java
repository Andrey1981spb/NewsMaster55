package ru.spb.push;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.spb.FactoryClass;

import java.util.List;

public class PushModifier {

    UserDAO userDAO = new UserDAO();
    FactoryClass factoryClass = new FactoryClass();

    public PushModifier() {

    }

    public Pushdata findPushdata(long id) {
        //return userDAO.findById(id);
        return factoryClass.getSessionFactory().openSession().get(Pushdata.class, id);
    }

    public void savePushdata(Pushdata pushdata) {
        userDAO.save(pushdata);
    }

    public void deletePushdata(Pushdata pushdata) {
        userDAO.delete(pushdata);
    }

    public void updatePushdata(Pushdata pushdata) {
        userDAO.update(pushdata);
    }

    public List<Pushdata> findAllPushdata() {

        Session session = factoryClass.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        List dataList = session.createQuery("from Pushdata").list();
        tx1.commit();
        session.close();
        return dataList;

          //  return userDAO.getAll();

    }

}
