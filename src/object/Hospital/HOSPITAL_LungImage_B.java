package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_LungImage_B extends Entity {
    public HOSPITAL_LungImage_B(GamePanel gamePanel) {
        super(gamePanel);

        name = "LungImage_B";
        ObjectWidth = 28*2+14;
        ObjectHeight = 16*2+8;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}