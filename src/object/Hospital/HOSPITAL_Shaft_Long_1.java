package object.Hospital;

import object._SuperObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class HOSPITAL_Shaft_Long_1 extends _SuperObject {
    public HOSPITAL_Shaft_Long_1() {
        name = "Shaft_Long_1";
        ObjectWidth = 32*2+16;
        ObjectHeight = 19*2+10;

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