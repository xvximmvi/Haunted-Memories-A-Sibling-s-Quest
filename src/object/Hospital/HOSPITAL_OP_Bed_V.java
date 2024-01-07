package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_OP_Bed_V extends Entity {
    public HOSPITAL_OP_Bed_V(GamePanel gamePanel) {
        super(gamePanel);
        name = "OP_Bed_V";
        ObjectWidth = 50*2+25;
        ObjectHeight = 88*2+44;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}