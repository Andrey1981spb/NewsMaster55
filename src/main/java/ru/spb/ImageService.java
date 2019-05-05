package ru.spb;

import org.apache.commons.fileupload.FileItem;
import ru.spb.login.FilterLogin;

import java.io.*;

import java.util.logging.Logger;

public class ImageService {

    private static Logger log = Logger.getLogger(FilterLogin.class.getName());

    public ImageService() {
    }

    public String SaveFile(FileItem fileItem) {

       // String filePath = "/Applications/apache-tomcat-9.0.12/webapp/ROOT/Images";
       // String filePath = "/Applications/apache-tomcat-9.0.12/bin/Images";
        String filePath = "Images";

        FileFactory fileFactory = new FileFactory();
        String nameFile = File.separator + "Picture" + fileFactory.NameCreator() + ".jpg";
        String namePathFile = filePath + nameFile;
        try {
            File file = new File(namePathFile);
            log.info("save to file: " + file.getAbsolutePath());
            fileItem.write(file);
        } catch (Exception e) {
            log.info("cannot save uploaded file");
            e.printStackTrace();
        }

        return "Images"+nameFile;

    }
}