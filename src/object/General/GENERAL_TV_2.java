package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_TV_2 extends Entity {
    public GENERAL_TV_2(GamePanel gamePanel) {
        super(gamePanel);
        name = "TV_2";
        ObjectWidth = 22*2+11;
        ObjectHeight = 28*2+14;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}