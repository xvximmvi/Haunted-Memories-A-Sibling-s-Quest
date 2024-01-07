package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_X_Ray extends Entity {
    public HOSPITAL_X_Ray(GamePanel gamePanel) {
        super(gamePanel);
        name = "X-Ray";
        ObjectWidth = 56*2+28;
        ObjectHeight = 14*2+7;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}