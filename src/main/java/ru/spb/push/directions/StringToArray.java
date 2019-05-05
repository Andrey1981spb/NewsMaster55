package ru.spb.push.directions;

import ru.spb.push.StringService;

import java.io.*;
import java.util.logging.Logger;

public class StringToArray {

    public static Logger log = Logger.getLogger(StringToArray.class.getName());

    public StringToArray() {

    }

    public InputStream getArray(String string) {

        InputStream is = new ByteArrayInputStream(string.getBytes());

        return is;

    }

}
