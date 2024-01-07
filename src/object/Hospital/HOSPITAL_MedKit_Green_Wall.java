package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_MedKit_Green_Wall extends Entity {
    public HOSPITAL_MedKit_Green_Wall(GamePanel gamePanel) {
        super(gamePanel);

        name = "MedKit_Green_Wall";
        ObjectWidth = 26*2+13;
        ObjectHeight = 32*2+16;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}