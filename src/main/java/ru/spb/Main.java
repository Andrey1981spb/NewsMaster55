package ru.spb;


import com.arjuna.ats.internal.jdbc.drivers.modifiers.list;
import javafx.beans.binding.SetExpression;
import org.hibernate.Session;
import ru.spb.login.Logindata;
import ru.spb.login.QueryDBLoginClass2;
import ru.spb.push.StringService;
import ru.spb.push.directions.StringToArray;

import javax.persistence.Query;
import java.io.*;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws SQLException, IOException {

        final String STRING = "test string";
        StringToArray stringToArray = new StringToArray();
        StringService stringService = new StringService();

        InputStream is = stringToArray.getArray(STRING);
        String title_news = stringService.getString(is);

        System.out.println(title_news);

    }

}



