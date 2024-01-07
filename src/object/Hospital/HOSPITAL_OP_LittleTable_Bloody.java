package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_OP_LittleTable_Bloody extends Entity {
    public HOSPITAL_OP_LittleTable_Bloody(GamePanel gamePanel) {
        super(gamePanel);
        name = "OP_LittleTable_Bloody";
        ObjectWidth = 32*2+16;
        ObjectHeight = 40*2+20;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}