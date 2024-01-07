package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_LungImage_T extends Entity {
    public HOSPITAL_LungImage_T(GamePanel gamePanel) {
        super(gamePanel);

        name = "LungImage_T";
        ObjectWidth = 28*2+14;
        ObjectHeight = 24*2+12;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}