package object.Hospital;

import object._SuperObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class HOSPITAL_Divider_Long_F extends _SuperObject {
    public HOSPITAL_Divider_Long_F(){
        name = "Divider_Long_F";
        ObjectWidth = 60*2+30;
        ObjectHeight = 64*2+32;

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
