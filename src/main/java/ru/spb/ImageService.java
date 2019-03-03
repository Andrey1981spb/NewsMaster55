package ru.spb;

import ru.spb.FileFactory;
import ru.spb.login.FilterLogin;

import javax.servlet.ServletInputStream;
import java.io.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.logging.Logger;

public class ImageService {

    private static Logger log = Logger.getLogger(FilterLogin.class.getName());
    byte[] request_data;
    final int size = 300 * 300;

    public ImageService() {}

    public void SaveFile(ServletInputStream servletInputStream) throws IOException {

        byte[] temporary_data = new byte[size];
        int b, j = 0;
        try {
            BufferedInputStream bf = new BufferedInputStream(servletInputStream, size);

            while ((b = bf.read()) != -1) {
                temporary_data[j] = (byte) b;
                j++;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        request_data = new byte[j];
        for (int i = 0; i < j; i++) {
            request_data[i] = temporary_data[j];
            temporary_data = null;
        }

        try {
            FileFactory fileFactory = new FileFactory();
            String filePath = "src/main/webapp/Images";

            String name = "Picture" + fileFactory.NameCreator();


            FileOutputStream fileOutputStream = new FileOutputStream(filePath + "//" + name + ".png");

            fileOutputStream.write(request_data);
            fileOutputStream.close();
        } catch (Exception ex) {
            System.out.println(ex.toString());

        }
    }
}
