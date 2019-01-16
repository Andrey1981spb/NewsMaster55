package ru.spb.push;

import org.apache.commons.lang.ObjectUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/newsPage")
public class PushNewsServlet extends HttpServlet {
    private static final long serialVersionUID = 6978504478649856135L;
    private final PushModifier pushModifier = new PushModifier();
    private final NewsModifier newsModifier = new NewsModifier();
    private final List<Pushdata> mockPushdataList = new ArrayList<Pushdata>();
    private final List<Newsdata> mockPushdataList2 = new ArrayList<Newsdata>();

    @Override
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        //Запрос из базы
        //   request.setAttribute("listofpush", pushModifier.findAllPushdata());
        request.setAttribute("listofnews", newsModifier.findAllNewsdata());

        request.setCharacterEncoding("UTF8");
        response.setContentType("text/html");
        response.setContentType("text/html; charset=UTF-8");

        //Передача из заглушки

        //  request.setAttribute("listofpush", mockPushdataList);
        // request.setAttribute("listofnews", mockPushdataList2);

        //Ответ клиенту
        getServletContext().getRequestDispatcher("/newsPage.jsp").forward(request, response);

    }

    @Override
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF8");
        response.setContentType("text/html; charset=UTF-8");

      //  String modalForm = request.getParameter("modalForm");

        if (request.getParameter("modalForm1") != null) {
           // if ("modalFormPush".equals(modalForm)) {
                Pushdata pushdata = new Pushdata();

                pushdata.setTitle(request.getParameter("title"));
                pushdata.setContent(request.getParameter("content"));
                pushModifier.savePushdata(pushdata);

                // mockPushdataList.add(pushdata);
                //  doGet(request, response);
         //   }
        } if (request.getParameter("modalForm2") != null) {
          // if ("modalFormNews".equals(modalForm)) {
                Newsdata newsdata = new Newsdata();

                newsdata.setTitle_news(request.getParameter("title_news"));
                newsdata.setContent_news(request.getParameter("content_news"));
                newsModifier.saveNewsdata(newsdata);

                //  mockPushdataList2.add(newsdata);
                //   doGet(request, response);
           // }
        }
    }
}



















