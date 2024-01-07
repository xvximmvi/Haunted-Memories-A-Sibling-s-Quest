package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;


public class HOSPITAL_3F extends Entity {
    public HOSPITAL_3F(GamePanel gamePanel) {
        super(gamePanel);

        name = "3F";
        ObjectWidth = 18*2+9;
        ObjectHeight = 20*2+10;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}