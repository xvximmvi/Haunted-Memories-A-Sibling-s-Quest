package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_MedStuff_2 extends Entity {
    public HOSPITAL_MedStuff_2(GamePanel gamePanel) {
        super(gamePanel);

        name = "MedStuff_2";
        ObjectWidth = 21*2+10;
        ObjectHeight = 25*2+12;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        TOP = true;
        collision = false;
    }
}