package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_Bed_NoSheets_F extends Entity {
    public HOSPITAL_Bed_NoSheets_F(GamePanel gamePanel){
        super(gamePanel);

        name = "Bed_NoSheets_F";
        ObjectWidth = 32*2+16;
        ObjectHeight = 72*2+36;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}
