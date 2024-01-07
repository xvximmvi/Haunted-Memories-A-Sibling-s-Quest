package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_Blood_1 extends Entity {
    public GENERAL_Blood_1(GamePanel gamePanel) {
        super(gamePanel);
        name = "Blood_1";
        ObjectWidth = 31*2+15;
        ObjectHeight = 23*2+11;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}