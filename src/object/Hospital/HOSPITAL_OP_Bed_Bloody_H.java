package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_OP_Bed_Bloody_H extends Entity {
    public HOSPITAL_OP_Bed_Bloody_H(GamePanel gamePanel) {
        super(gamePanel);
        name = "OP_Bed_Bloody_H";
        ObjectWidth = 88*2+44;
        ObjectHeight = 54*2+27;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}