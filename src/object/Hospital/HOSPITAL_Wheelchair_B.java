package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_Wheelchair_B extends Entity {
    public HOSPITAL_Wheelchair_B(GamePanel gamePanel) {
        super(gamePanel);
        name = "Wheelchair_B";
        ObjectWidth = 27*3+13;
        ObjectHeight = 24*3+12;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}