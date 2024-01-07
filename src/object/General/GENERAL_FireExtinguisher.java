package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_FireExtinguisher extends Entity {
    public GENERAL_FireExtinguisher(GamePanel gamePanel) {
        super(gamePanel);
        name = "FireExtinguisher";
        ObjectWidth = 17*2+8;
        ObjectHeight = 32*2+16;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}