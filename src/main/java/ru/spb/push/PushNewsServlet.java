package ru.spb.push;

import org.apache.commons.lang.ObjectUtils;
import ru.spb.login.Allert;
import ru.spb.push.directions.DirModifier;
import ru.spb.push.directions.Directiondata;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet("/newsPage")
public class PushNewsServlet extends HttpServlet {
    private static final long serialVersionUID = 6978504478649856135L;
    private final PushModifier pushModifier = new PushModifier();
    private final NewsModifier newsModifier = new NewsModifier();
    private final DirModifier dirModifier = new DirModifier();
    final Logger log = (Logger) Logger.getLogger(String.valueOf((PushNewsServlet.class)));
    Allert allert = new Allert();

    @Override
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF8");
        response.setContentType("text/html; text/plain; image/jpg; charset=UTF-8");

        if ("manager".equals(request.getParameter("role"))){

            request.setAttribute("listofpush", pushModifier.findAllPushdata());
            request.setAttribute("listofnews", newsModifier.findAllNewsdata());


            request.setAttribute("role", "manager");

            getServletContext().getRequestDispatcher("/newsPage.jsp").forward(request, response);
        }

        if ("spec".equals(request.getParameter("role"))){
            request.setAttribute("listofpush", pushModifier.findAllPushdata());
            request.setAttribute("listofnews", newsModifier.findAllNewsdata());


            request.setAttribute("role", "spec");

            getServletContext().getRequestDispatcher("/newsPage.jsp").forward(request, response); }


           if (request.getParameter("forDirection") != null) {
                if (!response.isCommitted()) {
                    request.setAttribute("listofdirs", dirModifier.findAllDirectiondata());
                   getServletContext().getRequestDispatcher("/directionPage.jsp").forward(request, response);
                }
            }
           if (request.getParameter("modalDirection") != null) {
              if (!response.isCommitted()) {
                   request.setAttribute("listofdirs", dirModifier.findAllDirectiondata());
                   getServletContext().getRequestDispatcher("/directionPage.jsp").forward(request, response);
               }
           }


    }

    @Override
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF8");
        response.setContentType("text/html; image/jpg; charset=UTF-8");

        if (request.getParameter("modalForm1") != null) {

            Pushdata pushdata = new Pushdata();
            pushdata.setTitle(request.getParameter("title"));
            pushdata.setContent(request.getParameter("content"));
            pushModifier.savePushdata(pushdata);
            log.info("WELL DONE!!!!");
            doGet(request, response);

        }
        if (request.getParameter("modalForm2") != null) {

            Newsdata newsdata = new Newsdata();
            newsdata.setTitle_news(request.getParameter("title_news"));
            newsdata.setContent_news(request.getParameter("content_news"));
            newsModifier.saveNewsdata(newsdata);
            doGet(request, response);
        }

        if (request.getParameter("forDirection") != null) {

            doGet(request, response);

        }

        if (request.getParameter("modalDirection") != null) {
            Directiondata directiondata = new Directiondata();
            directiondata.setJob(request.getParameter("job"));
            directiondata.setAdmission(request.getParameter("admission"));
            dirModifier.saveDirectiondata(directiondata);
            doGet(request, response);
        }
    }
}




















