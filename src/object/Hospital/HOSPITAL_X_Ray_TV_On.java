package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_X_Ray_TV_On extends Entity {
    public HOSPITAL_X_Ray_TV_On(GamePanel gamePanel) {
        super(gamePanel);
        name = "X-Ray_TV_On";
        ObjectWidth = 62*2+31;
        ObjectHeight = 44*2+22;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}