package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_Wheelchair_L extends Entity {
    public HOSPITAL_Wheelchair_L(GamePanel gamePanel) {
        super(gamePanel);
        name = "Wheelchair_L";
        ObjectWidth = 28*3+14;
        ObjectHeight = 37*3+18;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}