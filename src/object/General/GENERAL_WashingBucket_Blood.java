package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_WashingBucket_Blood extends Entity {
    public GENERAL_WashingBucket_Blood(GamePanel gamePanel) {
        super(gamePanel);
        name = "WashingBucket_Blood";
        ObjectWidth = 29*2+14;
        ObjectHeight = 32*2+16;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}