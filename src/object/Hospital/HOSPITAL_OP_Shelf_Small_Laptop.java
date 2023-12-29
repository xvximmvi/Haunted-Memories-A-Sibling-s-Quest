package object.Hospital;

import object._SuperObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class HOSPITAL_OP_Shelf_Small_Laptop extends _SuperObject {
    public HOSPITAL_OP_Shelf_Small_Laptop() {
        name = "OP_Shelf_Small_Laptop";
        ObjectWidth = 45*2+22;
        ObjectHeight = 57*2+28;

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