package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_OP_Bed_H extends Entity {
    public HOSPITAL_OP_Bed_H(GamePanel gamePanel) {
        super(gamePanel);
        name = "OP_Bed_H";
        ObjectWidth = 84*2+42;
        ObjectHeight = 52*2+26;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}