package object.Hospital;

import object._SuperObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class HOSPITAL_3F extends _SuperObject {
    public HOSPITAL_3F() {
        name = "3F";
        ObjectWidth = 18*2+9;
        ObjectHeight = 20*2+10;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);

        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Objects/Hospital/" + name + ".png")));
            utility.scaleImage(image, ObjectWidth, ObjectHeight);
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
    }
}