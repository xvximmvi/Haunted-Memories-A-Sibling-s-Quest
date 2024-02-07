package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_MedStuff_1 extends Entity {
    public HOSPITAL_MedStuff_1(GamePanel gamePanel) {
        super(gamePanel);

        name = "MedStuff_1";
        ObjectWidth = 32*2+16;
        ObjectHeight = 32*2+16;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        TOP = true;
        collision = false;
    }
}