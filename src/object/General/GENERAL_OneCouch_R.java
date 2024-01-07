package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_OneCouch_R extends Entity {
    public GENERAL_OneCouch_R(GamePanel gamePanel) {
        super(gamePanel);
        name = "OneCouch_R";
        ObjectWidth = 26*2+13;
        ObjectHeight = 33*2+16;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}