package object.Hospital;

import object._SuperObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class HOSPITAL_EmergencyTable_Blood_Belts extends _SuperObject {
    public HOSPITAL_EmergencyTable_Blood_Belts(){
        name = "EmergencyTable_Blood_Belts";
        ObjectWidth = 31*2+15;
        ObjectHeight = 56*2+27;

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
