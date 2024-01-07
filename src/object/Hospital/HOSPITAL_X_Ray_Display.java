package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_X_Ray_Display extends Entity {
    public HOSPITAL_X_Ray_Display(GamePanel gamePanel) {
        super(gamePanel);
        name = "X-Ray_Display";
        ObjectWidth = 44*2+22;
        ObjectHeight = 35*2+17;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}