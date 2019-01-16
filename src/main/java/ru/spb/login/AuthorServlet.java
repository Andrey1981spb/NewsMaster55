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
    Allert allert = new Allert();
    
    int check;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF8");
        response.setContentType("text/html; charset=UTF-8");

        if (request.getParameter("postInApp") != null) {

            // input of data

            String login = request.getParameter("login");
            String password = request.getParameter("password");


            QueryDBLoginClass2 queryDBLoginClass = new QueryDBLoginClass2(login, password);

            check = queryDBLoginClass.CheckLogin();
            //compare of data, which being extracted and inputed

            if (check == 1) {
                response.sendRedirect("/newsPage");

            } else if (check == 0) {
                response.sendRedirect("/loginPage.jsp");
            }

        }
    }

}


