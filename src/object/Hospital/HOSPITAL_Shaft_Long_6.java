package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_Shaft_Long_6 extends Entity {
    public HOSPITAL_Shaft_Long_6(GamePanel gamePanel) {
        super(gamePanel);
        name = "Shaft_Long_6";
        ObjectWidth = 32*2+16;
        ObjectHeight = 45*2+22;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}