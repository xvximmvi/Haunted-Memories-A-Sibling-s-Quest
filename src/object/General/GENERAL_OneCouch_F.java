package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_OneCouch_F extends Entity {
    public GENERAL_OneCouch_F(GamePanel gamePanel) {
        super(gamePanel);
        name = "OneCouch_F";
        ObjectWidth = 32*2+16;
        ObjectHeight = 34*2+17;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}