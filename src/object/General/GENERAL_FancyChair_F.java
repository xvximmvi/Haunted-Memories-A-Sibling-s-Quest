package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_FancyChair_F extends Entity {
    public GENERAL_FancyChair_F(GamePanel gamePanel) {
        super(gamePanel);
        name = "FancyChair_F";
        ObjectWidth = 30*2+15;
        ObjectHeight = 56*2+28;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}