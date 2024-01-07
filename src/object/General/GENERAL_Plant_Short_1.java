package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_Plant_Short_1 extends Entity {
    public GENERAL_Plant_Short_1(GamePanel gamePanel) {
        super(gamePanel);
        name = "Plant_Short_1";
        ObjectWidth = 20*2+10;
        ObjectHeight = 32*2+16;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}