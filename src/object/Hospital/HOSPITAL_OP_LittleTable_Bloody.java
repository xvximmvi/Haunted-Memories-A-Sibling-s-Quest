package object.Hospital;

import object._SuperObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class HOSPITAL_OP_LittleTable_Bloody extends _SuperObject {
    public HOSPITAL_OP_LittleTable_Bloody() {
        name = "OP_LittleTable_Bloody";
        ObjectWidth = 32*2+16;
        ObjectHeight = 40*2+20;

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