package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_Sign extends Entity {
    public HOSPITAL_Sign(GamePanel gamePanel) {
        super(gamePanel);
        name = "Sign";
        ObjectWidth = 31*2+15;
        ObjectHeight = 15*2+7;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}