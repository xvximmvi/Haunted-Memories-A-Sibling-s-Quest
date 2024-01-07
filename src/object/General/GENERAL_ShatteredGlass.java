package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_ShatteredGlass extends Entity {
    public GENERAL_ShatteredGlass(GamePanel gamePanel) {
        super(gamePanel);
        name = "ShatteredGlass";
        ObjectWidth = 42*2+21;
        ObjectHeight = 43*2+21;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}