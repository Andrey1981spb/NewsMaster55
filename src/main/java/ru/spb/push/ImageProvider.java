package ru.spb.push;

import ru.spb.login.FilterLogin;

import javax.imageio.ImageIO;
import javax.servlet.ServletInputStream;
import java.awt.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Logger;


public class ImageProvider {

    private static Logger log = Logger.getLogger(FilterLogin.class.getName());
    byte[] request_data;
    final int size = 1300 * 600;

    public ImageProvider() {
    }

    public void SaveFile(ServletInputStream servletInputStream) {

        String filePath = "Applications\\apache-tomcat-9.0.12\\bin\\newimage";

        System.out.println(getClass().getClassLoader().getResource("Log4.xml"));
        String name = "Picture";

        byte[] temporary_data = new byte[size];
        int b, j = 0;
        try (BufferedInputStream bf = new BufferedInputStream(servletInputStream, size);
             FileOutputStream fileOutputStream = new FileOutputStream(filePath + "\\" + name + ".png")) {

            while ((b = bf.read()) != -1) {
                temporary_data[j] = (byte) b;
                j++;
            }

            request_data = new byte[j];
            for (int i = 0; i < j; i++) {
                request_data[i] = temporary_data[j];
                temporary_data = null;
            }

            fileOutputStream.write(request_data);
        } catch (Exception ex) {
            System.out.println(ex.toString());

        }
//            FileFactory fileFactory = new FileFactory();
//            String name = "Picture" + fileFactory.NameCreator();
    }


}
