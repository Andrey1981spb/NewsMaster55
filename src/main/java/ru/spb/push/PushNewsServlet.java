package ru.spb.push;

import ru.spb.ImageService;
import ru.spb.push.directions.DirModifier;
import ru.spb.push.directions.Directiondata;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.HTMLDocument;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/newsPage")
public class PushNewsServlet extends HttpServlet {
    private static final long serialVersionUID = 6978504478649856135L;
    private final PushModifier pushModifier = new PushModifier();
    private final NewsModifier newsModifier = new NewsModifier();
    private final DirModifier dirModifier = new DirModifier();
    private static Logger log = Logger.getLogger(PushNewsServlet.class.getName());
    StringService stringService = new StringService();

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
        Newsdata newsdata = new Newsdata();

        if (request.getParameter("modalForm1") != null) {

            Pushdata pushdata = new Pushdata();
            pushdata.setTitle(request.getParameter("title"));
            pushdata.setContent(request.getParameter("content"));
            pushModifier.savePushdata(pushdata);

            doGet(request, response);
        }


        if (ServletFileUpload.isMultipartContent(request)) {

            try {
                List<FileItem> fileItems = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
                Iterator<FileItem> iterator = fileItems.iterator();

                while (iterator.hasNext()) {

                    FileItem fileItem = iterator.next();

                    if (!fileItem.getFieldName().equals("modalForm2")
                            & !fileItem.getFieldName().equals("Сохранить")
                            & !fileItem.getFieldName().equals("forDirection")) {

                        System.out.println(fileItem.getFieldName());
                        InputStream inputStream = fileItem.getInputStream();
                        String title_news = stringService.getString(inputStream);
                        newsdata.setTitle_news(title_news);
                        fileItem = iterator.next();

                        System.out.println(fileItem.getFieldName());
                        inputStream = fileItem.getInputStream();
                        String content_news = stringService.getString(inputStream);
                        newsdata.setContent_news(content_news);
                        fileItem = iterator.next();

                        if (fileItem.getFieldName().equals("image_on_server")) {
                            System.out.println(fileItem.getFieldName());
                            ImageService imageService = new ImageService();
                            String urlimage = imageService.SaveFile(fileItem);
                            System.out.println(urlimage);
                            newsdata.setUrlimage(urlimage);
                        }

                        newsModifier.saveNewsdata(newsdata);
                        doGet(request, response);
                   }
                }

            } catch (FileUploadException e) {
                log.info("problem with getting fields");
                e.printStackTrace();
            }
        } else {
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




















