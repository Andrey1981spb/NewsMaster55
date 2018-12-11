import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")
public class PushNewsServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PushModifier pushModifier = new PushModifier();

        //Запись в базу
        if (request.getParameter("putInApp") != null) {

            Pushdata pushdata = new Pushdata();

            //Передача параметров в базу с запросом
            pushdata.setTitle(request.getParameter("title"));
            pushdata.setContent(request.getParameter("content"));

            pushModifier.savePushdata(pushdata);

            //Запрос из базы
            request.setAttribute("listofpush", pushModifier.findAllPushdata());

            //Ответ клиенту
            RequestDispatcher requestDispatcher = request.
                    getRequestDispatcher("/newsPage.jsp");
            requestDispatcher.forward(request, response);

        }

    }
}
