package ru.spb;

import org.apache.commons.fileupload.FileItem;
import ru.spb.login.FilterLogin;

import java.io.File;
import java.util.logging.Logger;

public class ImageService {

    private static Logger log = Logger.getLogger(FilterLogin.class.getName());

    public ImageService() {
    }

    public void SaveFile(FileItem fileItem) {
        String filePath = "/uploads";
        FileFactory fileFactory = new FileFactory();
        String name = filePath + File.separator + "Picture" + fileFactory.NameCreator() + ".jpg";
        try {
            File file = new File(name);
            log.info("save to file: " + file.getAbsolutePath());
            fileItem.write(file);
        } catch (Exception e) {
            log.info("cannot save uploaded file");
            e.printStackTrace();
        }
    }

}
