package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_Box_2 extends Entity {
    public GENERAL_Box_2(GamePanel gamePanel) {
        super(gamePanel);
        name = "Box_2";
        ObjectWidth = 48*2+24;
        ObjectHeight = 72*2+36;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}