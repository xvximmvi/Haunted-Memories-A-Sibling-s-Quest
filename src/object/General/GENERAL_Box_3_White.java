package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_Box_3_White extends Entity {
    public GENERAL_Box_3_White(GamePanel gamePanel) {
        super(gamePanel);
        name = "Box_3_White";
        ObjectWidth = 28*2+14;
        ObjectHeight = 64*2+32;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}