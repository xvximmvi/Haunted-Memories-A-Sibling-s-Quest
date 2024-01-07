package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_TestTube extends Entity {
    public HOSPITAL_TestTube(GamePanel gamePanel) {
        super(gamePanel);
        name = "TestTube";
        ObjectWidth = 30*2+15;
        ObjectHeight = 25*2+12;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}