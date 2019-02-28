package ru.spb;


import com.arjuna.ats.internal.jdbc.drivers.modifiers.list;
import javafx.beans.binding.SetExpression;
import org.hibernate.Session;
import ru.spb.login.Logindata;
import ru.spb.login.QueryDBLoginClass2;

import javax.persistence.Query;
import java.io.*;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws SQLException, IOException {

       // int result;

     //   QueryDBLoginClass2 queryDBLoginClass = new QueryDBLoginClass2("sziuftabkta", "sziuftabkta","spec");
     //   result = queryDBLoginClass.CheckRole();
     //   System.out.println(result);

        final int size = 300 * 300;
        String filePath = "src/main/webapp/Images";
        FileInputStream fileInputStream = new FileInputStream(filePath + "//EGEsoon.jpg" );

        byte[] temporary_data = new byte[size];
        int b, j = 0;
        try {
            BufferedInputStream bf = new BufferedInputStream(fileInputStream, size);

            while ((b = bf.read()) != -1) {
                temporary_data[j] = (byte) b;
                j++;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        FileFactory fileFactory = new FileFactory();

        String name = "Picture" + fileFactory.NameCreator();

        //   new FileOutputStream(filePath + "//imagefile.jpg",false).close();
        FileOutputStream fileOutputStream = new FileOutputStream(filePath + "//"+ name +".jpg",false);
        fileOutputStream.write(temporary_data);
        fileOutputStream.close();

    }

}



