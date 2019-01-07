package ru.spb.login;

import org.hibernate.Session;
import ru.spb.FactoryClass;

import javax.persistence.Query;
import java.util.Iterator;
import java.util.List;

public class QueryDBLoginClass {

    String etalonlogin;
    String etalonpassword;
    FactoryClass factoryClass = new FactoryClass();

    QueryDBLoginClass() {
    }

    int count = 1;

    Session session = factoryClass.getSessionFactory().
            openSession();

    Query query = factoryClass.getSessionFactory().
            openSession().createQuery("select count (*) from Logindata");
    Iterator iterator = ((org.hibernate.query.Query) query).iterate();

    Query etalonlogin2 = session.createQuery("from Logindata where id=:counter").
            setParameter("counter", count);

    Query etalonpassword2 = session.createQuery("from Logindata where id=:counter").
            setParameter("counter", count);

    public String GetLogin() {
        List<Logindata> logindataList = etalonlogin2.getResultList();

        for (Logindata logindata : logindataList) {
            etalonlogin = logindata.getLogin();
        }
        return etalonlogin;
    }

    public String GetPassword() {
        List<Logindata> passworddataList = etalonpassword2.getResultList();


        for (Logindata logindata : passworddataList) {
            etalonpassword = logindata.getPassword();
        }
        return etalonpassword;
    }




}


