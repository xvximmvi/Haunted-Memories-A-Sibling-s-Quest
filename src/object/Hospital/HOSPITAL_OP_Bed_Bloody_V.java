package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_OP_Bed_Bloody_V extends Entity {
    public HOSPITAL_OP_Bed_Bloody_V(GamePanel gamePanel) {
        super(gamePanel);
        name = "OP_Bed_Bloody_V";
        ObjectWidth = 54*2+27;
        ObjectHeight = 90*2+45;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}