package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_Shaft_Long_2 extends Entity {
    public HOSPITAL_Shaft_Long_2(GamePanel gamePanel) {
        super(gamePanel);
        name = "Shaft_Long_2";
        ObjectWidth = 32*2+16;
        ObjectHeight = 19*2+10;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}