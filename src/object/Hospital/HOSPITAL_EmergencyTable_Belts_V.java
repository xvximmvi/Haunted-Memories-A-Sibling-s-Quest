package object.Hospital;

import object._SuperObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class HOSPITAL_EmergencyTable_Belts_V extends _SuperObject {
    public HOSPITAL_EmergencyTable_Belts_V(){
        name = "EmergencyTable_Belts_V";
        ObjectWidth = 31*2+15;
        ObjectHeight = 54*27;

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
