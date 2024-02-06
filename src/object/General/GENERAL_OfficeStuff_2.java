package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_OfficeStuff_2 extends Entity {
    public GENERAL_OfficeStuff_2(GamePanel gamePanel) {
        super(gamePanel);
        name = "OfficeStuff_2";
        ObjectWidth = 32*2+16;
        ObjectHeight = 26*2+13;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        TOP = true;
        collision = true;
    }
}