package main;

import java.awt.*;
import java.awt.image.BufferedImage;

// This Class was meant to get bigger, but I completely forgot this class existed.

public class Utility {

    // For rendering Performance: scale buffered images before the game loop starts and improve the total draw time
    public BufferedImage scaleImage(BufferedImage original, int width, int height) {
        BufferedImage scaledImage = new BufferedImage(width, height, original.getType());     //instantiate BufferedImage
        Graphics2D graphics2D = scaledImage.createGraphics();       //create a Graphics2D, which can be used to draw into this BufferedImage
        graphics2D.drawImage(original, 0, 0, width, height, null);    //Draw tile[80].image into the scaledImage (BufferedImage) that this Graphics2D is linked to

        graphics2D.dispose();

        return scaledImage;
    }
}