package ru.spb;

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
    private final List<Pushdata> mockPushdataList = new ArrayList<Pushdata>();
    @Override
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        //Запрос из базы
        request.setAttribute("listofpush", mockPushdataList);
//        request.setAttribute("listofpush", pushModifier.findAllPushdata());
        //Ответ клиенту
        getServletContext().getRequestDispatcher("/newsPage.jsp").forward(request, response);
    }
    @Override
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response)
            throws ServletException, IOException {
        //Запись в базу
        if (request.getParameter("putInApp") != null) {
            final Pushdata pushdata = new Pushdata();
            //Передача параметров в базу с запросом
            pushdata.setTitle(request.getParameter("title"));
            pushdata.setContent(request.getParameter("content"));
            //            pushModifier.savePushdata(pushdata);
            mockPushdataList.add(pushdata);
            doGet(request, response);
        }
    }
}















