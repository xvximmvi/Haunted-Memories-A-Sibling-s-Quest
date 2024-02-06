package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_Plant_Short_2 extends Entity {
    public GENERAL_Plant_Short_2(GamePanel gamePanel) {
        super(gamePanel);
        name = "Plant_Short_2";
        ObjectWidth = 20*2+10;
        ObjectHeight = 32*2+16;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        TOP = true;
        collision = true;
    }
}