package ru.spb.push;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;


public class ImageProvider {

    public ImageProvider() {
    }

    Image image = null;

    public Image fetchImage(String url) throws IOException {

        File imagefile = new File(url);
        image = ImageIO.read(imagefile);

        return image;
    }

}
