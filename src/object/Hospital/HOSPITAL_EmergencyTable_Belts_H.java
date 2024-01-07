package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_EmergencyTable_Belts_H extends Entity {
    public HOSPITAL_EmergencyTable_Belts_H(GamePanel gamePanel){
        super(gamePanel);

        name = "EmergencyTable_Belts_H";
        ObjectWidth = 58*2+29;
        ObjectHeight = 49*2+25;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}
