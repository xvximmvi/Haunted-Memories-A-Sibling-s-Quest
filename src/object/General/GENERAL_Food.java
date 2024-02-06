package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_Food extends Entity {
    public GENERAL_Food(GamePanel gamePanel) {
        super(gamePanel);
        name = "Food";
        ObjectWidth = 27*3+13;
        ObjectHeight = 21*3+10;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        TOP = true;
        collision = true;
    }
}