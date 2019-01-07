package ru.spb;

import org.hibernate.testing.junit4.BaseCoreFunctionalTestCase;
import ru.spb.login.AuthorServlet;

public class ORMUnitTestCase extends BaseCoreFunctionalTestCase {

    protected Class[] getAnnotatedClasses() {
        return new Class[]{
                AuthorServlet.class
        };
    }
}

