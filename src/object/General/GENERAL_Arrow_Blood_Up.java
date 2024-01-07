package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_Arrow_Blood_Up extends Entity {
    public GENERAL_Arrow_Blood_Up(GamePanel gamePanel) {
        super(gamePanel);
        name = "Arrow_Blood_Up";
        ObjectWidth = 14*2+7;
        ObjectHeight = 44*2+22;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}