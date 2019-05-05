package ru.spb.push;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Logger;

public class StringService {
    String s;

    public static Logger log = Logger.getLogger(StringService.class.getName());

    public StringService() {
    }

    public String getString(InputStream is) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        StringBuilder sb = new StringBuilder();
       try {
            String nextLine;
            int lines = 0;
            while (null != (nextLine = br.readLine())) {
                sb.append(nextLine);
                System.out.println(sb);

                s = sb.toString();
            }
        } catch (IOException ex) {
            log.info("problem with inputting stream to string");
            ex.printStackTrace();
        }
        return s;
    }

}
