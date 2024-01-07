package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_Toilet_Cabin_Bottom extends Entity {
    public GENERAL_Toilet_Cabin_Bottom(GamePanel gamePanel) {
        super(gamePanel);
        name = "Toilet_Cabin_Bottom";
        ObjectWidth = 69*2+34;
        ObjectHeight = 32*2+16;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}