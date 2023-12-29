package object.Hospital;

import object._SuperObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class HOSPITAL_EmergencyTable_Belts_H extends _SuperObject {
    public HOSPITAL_EmergencyTable_Belts_H(){
        name = "EmergencyTable_Belts_H";
        ObjectWidth = 58*2+29;
        ObjectHeight = 49*2+25;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);

        try{
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Objects/Hospital/" + name + ".png")));
            utility.scaleImage(image, ObjectWidth, ObjectHeight);
        } catch(IOException e){
            e.printStackTrace();
        }
        collision = true;
    }
}
