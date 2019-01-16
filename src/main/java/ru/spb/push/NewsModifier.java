package ru.spb.push;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.spb.FactoryClass;

import java.util.List;

public class NewsModifier {

    UserDAO userDAO = new UserDAO();
    FactoryClass factoryClass = new FactoryClass();

    public NewsModifier() {

    }

    public Newsdata findNewsdata(long id) {
        return factoryClass.getSessionFactory().openSession().get(Newsdata.class, id);
    }

    public void saveNewsdata(Newsdata newsdata) {
        userDAO.save(newsdata);
    }

    public void deleteNewsdata(Newsdata newsdata) {
        userDAO.delete(newsdata);
    }

    public void updateNewsdata(Newsdata newsdata) {
        userDAO.update(newsdata);
    }

    public List<Newsdata> findAllNewsdata() {
        return userDAO.getAll();

    }

}
