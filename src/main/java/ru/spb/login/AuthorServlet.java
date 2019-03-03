package ru.spb.login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/loginPage")
public class AuthorServlet extends HttpServlet {
    Allert allert = new Allert();
    int check;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF8");
        response.setContentType("text/html; charset=UTF-8");

        if (request.getParameter("postInApp1") != null) {

            String login = request.getParameter("login");
            String password = request.getParameter("password");

            QueryDBLoginClass2 queryDBLoginClass = new QueryDBLoginClass2(login, password, "spec");

            check = queryDBLoginClass.CheckRole();
            check = 1;

            if (check == 1) {

               // request.getSession().setAttribute("role", "spec");
               // response.sendRedirect("/newsPage");

                response.sendRedirect("/newsPage?role=spec");

            } else if (check == 0) {
                response.sendRedirect("/loginPage.jsp");
            }
        }

        else if (request.getParameter("postInApp2") != null) {

            String login = request.getParameter("login");
            String password = request.getParameter("password");

            QueryDBLoginClass2 queryDBLoginClass = new QueryDBLoginClass2(login, password, "manager");

            check = queryDBLoginClass.CheckRole();
            check =1;

            if (check == 1) {

              //  request.getSession().setAttribute("role", "manager");
              //  response.sendRedirect("/newsPage");

                response.sendRedirect("/newsPage?role=manager");
                
            } else if (check == 0) {
                response.sendRedirect("/loginPage.jsp");
            }
        }
    }
}


