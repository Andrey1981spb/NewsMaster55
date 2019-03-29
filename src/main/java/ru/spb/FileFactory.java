package ru.spb;

import java.util.Random;

public class FileFactory {

    public FileFactory() {

    }

    String nameOfFile;

    public String NameCreator() {
        Random random = new Random();

        nameOfFile = String.valueOf(random.nextInt(150));

        return nameOfFile;
    }

}
