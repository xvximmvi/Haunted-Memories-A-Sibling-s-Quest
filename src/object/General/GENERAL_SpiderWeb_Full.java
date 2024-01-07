package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_SpiderWeb_Full extends Entity {
    public GENERAL_SpiderWeb_Full(GamePanel gamePanel) {
        super(gamePanel);
        name = "SpiderWeb_Full";
        ObjectWidth = 32*2+16;
        ObjectHeight = 39*2+19;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}