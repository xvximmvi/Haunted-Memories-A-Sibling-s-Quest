package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_OP_Wall_Deco_Broken extends Entity {
    public HOSPITAL_OP_Wall_Deco_Broken(GamePanel gamePanel) {
        super(gamePanel);
        name = "OP_Wall_Deco_Broken";
        ObjectWidth = 59*2+29;
        ObjectHeight = 28*2+14;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}