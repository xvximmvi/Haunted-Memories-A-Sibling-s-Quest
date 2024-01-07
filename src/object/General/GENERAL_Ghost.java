package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_Ghost extends Entity {
    public GENERAL_Ghost(GamePanel gamePanel) {
        super(gamePanel);
        name = "Ghost";
        ObjectWidth = 16*2+8;
        ObjectHeight = 46*2+23;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}