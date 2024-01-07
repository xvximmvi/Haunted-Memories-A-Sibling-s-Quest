package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_Divider_Long_S extends Entity {
    public HOSPITAL_Divider_Long_S(GamePanel gamePanel){
        super(gamePanel);

        name = "Divider_Long_S";
        ObjectWidth = 28*2+14;
        ObjectHeight = 114*2+57;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}
