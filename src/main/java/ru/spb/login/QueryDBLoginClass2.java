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
    String role;
    FactoryClass factoryClass = new FactoryClass();

    int f;
    int result;

    public QueryDBLoginClass2(String login, String password, String role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    Session session = factoryClass.getSessionFactory().
            openSession();

    final public int CheckLogin(List<Logindata> list) {

            int count1 = 0;

            for (int i = 0; i < list.size(); i++) {

                etalonlogin = list.get(count1).getLogin();
                etalonpassword = list.get(count1).getPassword();

                // Check the condition //
                if (etalonlogin.equals(login) && etalonpassword.equals(password)) {

                    f = 1;

                } else {
                    int count2 = count1 + 1;
                    count1 = count2;

                    if (count1 > list.size() - 1) {

                        f = 0;
                    }
                }
            }

        return f;
    }

    final public int CheckRole() {

        String sendrole = this.getRole();

        if (sendrole == "spec") {

            //Query login from base //
            Query queryData = session.createQuery("from Logindata where role = :nameRole").setParameter("nameRole", "spec");
            List<Logindata> logindataList = queryData.getResultList();

            result = this.CheckLogin(logindataList);
        } else if (sendrole == "manager") {
            Query queryData = session.createQuery("from Logindata where role = :nameRole").setParameter("nameRole", "manager");
            List<Logindata> logindataList = queryData.getResultList();

            result = this.CheckLogin(logindataList);
        }
       return result;

    }


}


