package object.General;

import object._SuperObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class GENERAL_CleaningBottle_3 extends _SuperObject {
    public GENERAL_CleaningBottle_3() {
        name = "CleaningBottle_3";
        ObjectWidth = gamePanel.tileSize;
        ObjectHeight = gamePanel.tileSize;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);

        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Objects/General/" + name + ".png")));
            utility.scaleImage(image, ObjectWidth, ObjectHeight);
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
    }
}