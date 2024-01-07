package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_X_Ray_1 extends Entity {
    public HOSPITAL_X_Ray_1(GamePanel gamePanel) {
        super(gamePanel);
        name = "X-Ray_1";
        ObjectWidth = 66*2+33;
        ObjectHeight = 64*2+32;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}