package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_ICU extends Entity {
    public HOSPITAL_ICU(GamePanel gamePanel) {
        super(gamePanel);

        name = "ICU";
        ObjectWidth = 26*2+13;
        ObjectHeight = 14*2+7;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}