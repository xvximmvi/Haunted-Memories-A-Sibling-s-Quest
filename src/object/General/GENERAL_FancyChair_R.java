package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_FancyChair_R extends Entity {
    public GENERAL_FancyChair_R(GamePanel gamePanel) {
        super(gamePanel);
        name = "FancyChair_R";
        ObjectWidth = 31*2+15;
        ObjectHeight = 57*2+28;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}