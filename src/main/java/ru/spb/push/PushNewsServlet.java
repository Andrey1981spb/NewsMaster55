package ru.spb.push;

import ru.spb.ImageService;
import ru.spb.push.directions.DirModifier;
import ru.spb.push.directions.Directiondata;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
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
    private static Logger log = Logger.getLogger(PushNewsServlet.class.getName());

    @Override
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF8");
        response.setContentType("text/html; text/plain; image/jpg; charset=UTF-8");


        if ("manager".equals(request.getParameter("role"))) {
            request.setAttribute("listofpush", pushModifier.findAllPushdata());
            request.setAttribute("listofnews", newsModifier.findAllNewsdata());
            request.setAttribute("role", "manager");

            getServletContext().getRequestDispatcher("/newsPage.jsp").forward(request, response);

        }

        if ("spec".equals(request.getParameter("role"))) {
            request.setAttribute("listofpush", pushModifier.findAllPushdata());
            request.setAttribute("listofnews", newsModifier.findAllNewsdata());
            request.setAttribute("role", "spec");

            getServletContext().getRequestDispatcher("/newsPage.jsp").forward(request, response);
        }

        if ("manager_attribute".equals(request.getAttribute("role"))) {

            request.setAttribute("listofpush", pushModifier.findAllPushdata());
            request.setAttribute("listofnews", newsModifier.findAllNewsdata());
            request.setAttribute("role", "manager");

            getServletContext().getRequestDispatcher("/newsPage.jsp").forward(request, response);

        }


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

            doGet(request, response);
        }

        if (request.getParameter("modalForm2") != null) {

            Newsdata newsdata = new Newsdata();
            newsdata.setTitle_news(request.getParameter("title_news"));
            newsdata.setContent_news(request.getParameter("content_news"));
            newsModifier.saveNewsdata(newsdata);


                if (request.getParameter("image_on_server") != null) {
                    log.info("get a picture successfully");

                    ServletInputStream servletInputStream = request.getInputStream();
                    ImageService imageService = new ImageService();

                    try {

                        if (servletInputStream != null) {
                            log.info("stream to servlet without problem");
                            imageService.SaveFile(servletInputStream);
                            doGet(request, response);
                        } else {
                            log.info("stream to servlet is null");

                        }
                    } catch (Exception e) {
                        System.out.println("Problem inputing stream to servlet");
                        e.printStackTrace();
                    }
                } else {
                    log.info("problem with getting a picture ");
                }


            if ("manager".equals(request.getParameter("role"))) {
                request.setAttribute("role", "manager_attribute");
                doGet(request, response);
            }
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




















