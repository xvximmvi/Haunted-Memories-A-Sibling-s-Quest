package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_EmergencyTable_Belts_V extends Entity {
    public HOSPITAL_EmergencyTable_Belts_V(GamePanel gamePanel){
        super(gamePanel);

        name = "EmergencyTable_Belts_V";
        ObjectWidth = 31*2+15;
        ObjectHeight = 54*27;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}
