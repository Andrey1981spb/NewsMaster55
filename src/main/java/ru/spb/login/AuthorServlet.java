package ru.spb.login;

import ru.spb.FactoryClass;

import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@WebServlet("/loginPage")
public class AuthorServlet extends HttpServlet {

    String etalonlogin;
    String etalonpassword;
    String returnPage;
    Allert allert = new Allert();
    QueryDBLoginClass queryDBLoginClass = new QueryDBLoginClass();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getParameter("postInApp") != null) {

            // input of data

            String login = request.getParameter("login");
            String password = request.getParameter("password");

            etalonlogin = queryDBLoginClass.GetLogin();
            etalonpassword = queryDBLoginClass.GetPassword();

            //compare of data, which being extracted and inputed

            if (etalonlogin.equals(login) & etalonpassword.equals(password)) {
                returnPage = "/newsPage";
                request.getRequestDispatcher(returnPage).forward(request, response);

            } else {
               // returnPage = "/loginPage.jsp";
               // doGet(request, response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
