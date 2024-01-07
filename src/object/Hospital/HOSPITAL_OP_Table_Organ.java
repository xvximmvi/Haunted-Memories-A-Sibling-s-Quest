package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_OP_Table_Organ extends Entity {
    public HOSPITAL_OP_Table_Organ(GamePanel gamePanel) {
        super(gamePanel);
        name = "OP_Table_Organ";
        ObjectWidth = 26*2+13;
        ObjectHeight = 29*2+14;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}