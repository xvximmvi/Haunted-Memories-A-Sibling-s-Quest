package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_X_Ray_Wall_Deco extends Entity {
    public HOSPITAL_X_Ray_Wall_Deco(GamePanel gamePanel) {
        super(gamePanel);
        name = "X-Ray_Wall_Deco";
        ObjectWidth = 55*2+27;
        ObjectHeight = 28*2+14;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}