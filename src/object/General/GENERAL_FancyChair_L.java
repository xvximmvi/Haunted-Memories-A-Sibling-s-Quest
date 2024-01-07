package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_FancyChair_L extends Entity {
    public GENERAL_FancyChair_L(GamePanel gamePanel) {
        super(gamePanel);
        name = "FancyChair_L";
        ObjectWidth = 33*2+16;
        ObjectHeight = 57*2+28;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}