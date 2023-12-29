package object.Hospital;

import object._SuperObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class HOSPITAL_OP_Table_Organ_Utilitys extends _SuperObject {
    public HOSPITAL_OP_Table_Organ_Utilitys() {
        name = "OP_Table_Organ_Utilitys";
        ObjectWidth = 26*2+13;
        ObjectHeight = 27*2+13;

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