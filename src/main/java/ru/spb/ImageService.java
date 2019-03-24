package ru.spb;

import ru.spb.FileFactory;
import ru.spb.login.FilterLogin;

import javax.servlet.ServletInputStream;
import java.io.*;

import java.util.logging.Logger;

public class ImageService {

    private static Logger log = Logger.getLogger(FilterLogin.class.getName());
    byte[] request_data;
    final int size = 256 * 256;

    public ImageService() {
    }

    public void SaveFile(ServletInputStream servletInputStream) throws IOException {

        byte[] temporary_data = new byte[size];
        int b, j = 0;

        BufferedInputStream bf = new BufferedInputStream(servletInputStream, size);

        if (bf != null) {

            System.out.print("Buffer is not null");
        } else System.out.print("Buffer is  null!!! ");

        while ((b = bf.read()) != -1) {
            temporary_data[j] = (byte) b;
            j++;

        }

        if (temporary_data != null) {

            System.out.print("Temporary is not null");
        } else System.out.print("Temporary is  null!!!");

        request_data = new byte[j];
        for (int i = 0; i < j; i++) {
            request_data[i] = temporary_data[j];
            temporary_data = null;
        }

        if (request_data != null) {
            System.out.print("request is not null");
        } else System.out.print("request is  null!!!");


            FileFactory fileFactory = new FileFactory();
            String filePath = "newimage";

        System.out.println("current path: " + new File(filePath).getAbsolutePath());

            String name = "Picture" + fileFactory.NameCreator();


            FileOutputStream fileOutputStream = new FileOutputStream(filePath + "//" + name + ".jpg");

            fileOutputStream.write(request_data);
            fileOutputStream.close();

        if (fileOutputStream != null) {
            System.out.print("fileOutputStream is not null");
        } else System.out.print("fileOutputStream is  null!!!");

    }
}