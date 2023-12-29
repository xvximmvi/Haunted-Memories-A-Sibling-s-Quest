package object.Hospital;

import object._SuperObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class HOSPITAL_Table_Bloody_PC_AddOn extends _SuperObject {
    public HOSPITAL_Table_Bloody_PC_AddOn() {
        name = "Table_Bloody_PC_AddOn";
        ObjectWidth = 64*2+32;
        ObjectHeight = 30*2+15;

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