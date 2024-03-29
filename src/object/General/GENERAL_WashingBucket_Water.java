package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_WashingBucket_Water extends Entity {
    public GENERAL_WashingBucket_Water(GamePanel gamePanel) {
        super(gamePanel);
        name = "WashingBucket_Water";
        ObjectWidth = 27*3;
        ObjectHeight = 31*3;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}