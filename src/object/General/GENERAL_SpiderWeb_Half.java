package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_SpiderWeb_Half extends Entity {
    public GENERAL_SpiderWeb_Half(GamePanel gamePanel) {
        super(gamePanel);
        name = "SpiderWeb_Half";
        ObjectWidth = 30*2+15;
        ObjectHeight = 21*2+10;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}