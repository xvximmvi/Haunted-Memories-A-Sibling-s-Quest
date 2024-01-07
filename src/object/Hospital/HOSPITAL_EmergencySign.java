package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_EmergencySign extends Entity {
    public HOSPITAL_EmergencySign(GamePanel gamePanel){
        super(gamePanel);

        name = "EmergencySign";
        ObjectWidth = 31*2+15;
        ObjectHeight = 16*2+8;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}
