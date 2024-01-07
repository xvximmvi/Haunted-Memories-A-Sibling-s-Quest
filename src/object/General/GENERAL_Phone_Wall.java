package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_Phone_Wall extends Entity {
    public GENERAL_Phone_Wall(GamePanel gamePanel) {
        super(gamePanel);
        name = "Phone_Wall";
        ObjectWidth = 26*2+13;
        ObjectHeight = 32*2+16;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}