package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_Arrow_Blood_Right extends Entity {
    public GENERAL_Arrow_Blood_Right(GamePanel gamePanel) {
        super(gamePanel);
        name = "Arrow_Blood_Right";
        ObjectWidth = 35*2+17;
        ObjectHeight = 24*2+12;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}