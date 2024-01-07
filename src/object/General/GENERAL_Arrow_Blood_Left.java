package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_Arrow_Blood_Left extends Entity {
    public GENERAL_Arrow_Blood_Left(GamePanel gamePanel) {
        super(gamePanel);
        name = "Arrow_Blood_Left";
        ObjectWidth = 41*2+20;
        ObjectHeight = 31*2+15;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}