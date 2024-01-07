package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_2F extends Entity {
    public HOSPITAL_2F(GamePanel gamePanel) {
        super(gamePanel);

        name = "2F";
        ObjectWidth = 19*2+9;
        ObjectHeight = 20*2+10;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}