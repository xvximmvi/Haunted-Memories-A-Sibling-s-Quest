package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_X_Ray_Machine extends Entity {
    public HOSPITAL_X_Ray_Machine(GamePanel gamePanel) {
        super(gamePanel);
        name = "X-Ray_Machine";
        ObjectWidth = 60*2+30;
        ObjectHeight = 80*2+40;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}