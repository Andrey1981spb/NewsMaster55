import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserDAO {

    public UserDAO (){

    }

    FactoryClass factoryClass = new FactoryClass();

    public Pushdata findById(long id) {
        return factoryClass.getSessionFactory().openSession().get(Pushdata.class, id);
    }

    public void save(Pushdata pushdata) {
        Session session = factoryClass.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(pushdata);
        session.flush();
        tx1.commit();
        session.close();
    }

    public void update(Pushdata pushdata) {
        Session session = factoryClass.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(pushdata);
        tx1.commit();
        session.close();
    }

    public void delete(Pushdata pushdata) {
        Session session = factoryClass.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(pushdata);
        tx1.commit();
        session.close();
    }

    public List<Pushdata> getAll() {
        Session session = factoryClass.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        List pushdataList = session.createQuery("from Pushdata").list();
        tx1.commit();
        session.close();
        return pushdataList;
    }

    public List<Pushdata> findAll() {
        List<Pushdata> users = (List<Pushdata>)
                factoryClass.getSessionFactory().openSession().createQuery("select '*' from Pushdata" ).list();
        return users;
    }

}
