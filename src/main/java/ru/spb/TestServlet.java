package ru.spb;

import org.hibernate.Session;
import ru.spb.login.Allert;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {

    Allert allert = new Allert();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getParameter("putInApp") != null) {
            request.getParameter("title");

            doGet(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        allert.setMessage("Unknown log");
        request.setAttribute("new_message", allert);

        getServletContext().getRequestDispatcher("/testPage.jsp").forward(request,response);
       // response.sendRedirect("/testPage.jsp");
    }
}
