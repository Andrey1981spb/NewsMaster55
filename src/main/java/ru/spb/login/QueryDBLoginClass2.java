package ru.spb.login;

import org.hibernate.Session;
import ru.spb.FactoryClass;

import javax.persistence.Query;
import java.util.Iterator;
import java.util.List;

public class QueryDBLoginClass2 {

    String etalonlogin;
    String etalonpassword;
    String login;
    String password;
    FactoryClass factoryClass = new FactoryClass();

    int f;

    public QueryDBLoginClass2(String login, String password) {
        this.login = login;
        this.password = password;
    }

    Session session = factoryClass.getSessionFactory().
            openSession();

    //Query login from base //
    Query queryData = session.createQuery("from Logindata");

    List<Logindata> logindataList = queryData.getResultList();

    final public int CheckLogin() {

        int count1 = 0;

        for (int i=0; i<logindataList.size(); i++) {

            etalonlogin = logindataList.get(count1).getLogin();
            etalonpassword = logindataList.get(count1).getPassword();

            // Check the condition //
            if (etalonlogin.equals(login) && etalonpassword.equals(password)) {

                f = 1;

            } else {
                int count2 = count1 + 1;
                count1 = count2;

                if (count1 > logindataList.size()-1) {

                    f = 0;
                }
            }
        }

        return f;
    }

}


