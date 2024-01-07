package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_Food extends Entity {
    public GENERAL_Food(GamePanel gamePanel) {
        super(gamePanel);
        name = "Food";
        ObjectWidth = 27*2+13;
        ObjectHeight = 21*2+10;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}