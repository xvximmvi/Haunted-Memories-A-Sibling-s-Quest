package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_Bed_NoSheets_R extends Entity {
    public HOSPITAL_Bed_NoSheets_R(GamePanel gamePanel){
        super(gamePanel);

        name = "Bed_NoSheets_R";
        ObjectWidth = 64*2+32;
        ObjectHeight = 46*2+23;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}
