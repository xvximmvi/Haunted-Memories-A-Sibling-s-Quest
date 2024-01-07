package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_Bed_NoSheets_B extends Entity {
    public HOSPITAL_Bed_NoSheets_B(GamePanel gamePanel){
        super(gamePanel);

        name = "Bed_NoSheets_B";
        ObjectWidth = 32*2+16;
        ObjectHeight = 62*2+31;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}
