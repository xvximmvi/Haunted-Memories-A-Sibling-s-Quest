package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_X_Ray_TV_Off extends Entity {
    public HOSPITAL_X_Ray_TV_Off(GamePanel gamePanel) {
        super(gamePanel);
        name = "X-Ray_TV_Off";
        ObjectWidth = 62*2+31;
        ObjectHeight = 44*2+22;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}