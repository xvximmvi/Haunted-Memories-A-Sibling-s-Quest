package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_Blood_3 extends Entity {
    public GENERAL_Blood_3(GamePanel gamePanel) {
        super(gamePanel);
        name = "Blood_3";
        ObjectWidth = 21*2+10;
        ObjectHeight = 21*2+10;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}