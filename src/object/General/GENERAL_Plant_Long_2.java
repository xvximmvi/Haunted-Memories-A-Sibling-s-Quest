package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_Plant_Long_2 extends Entity {
    public GENERAL_Plant_Long_2(GamePanel gamePanel) {
        super(gamePanel);
        name = "Plant_Long_2";
        ObjectWidth = 32*2+16;
        ObjectHeight = 96*2+48;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}