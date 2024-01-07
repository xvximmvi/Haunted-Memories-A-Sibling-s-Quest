package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_Blood_2 extends Entity {
    public GENERAL_Blood_2(GamePanel gamePanel) {
        super(gamePanel);
        name = "Blood_2";
        ObjectWidth = 38*2+19;
        ObjectHeight = 38*2+19;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}