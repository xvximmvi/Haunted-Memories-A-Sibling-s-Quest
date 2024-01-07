package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_Wheelchair_F extends Entity {
    public HOSPITAL_Wheelchair_F(GamePanel gamePanel) {
        super(gamePanel);
        name = "Wheelchair_F";
        ObjectWidth = 27*3+13;
        ObjectHeight = 36*3+18;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}