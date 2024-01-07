package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_Wall_Office_Deco_1 extends Entity {
    public GENERAL_Wall_Office_Deco_1(GamePanel gamePanel) {
        super(gamePanel);
        name = "Wall_Office_Deco_1";
        ObjectWidth = 64*2+32;
        ObjectHeight = 32*2+16;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}