package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_Plant_Long extends Entity {
    public GENERAL_Plant_Long(GamePanel gamePanel) {
        super(gamePanel);
        name = "Plant_Long";
        ObjectWidth = 32*2+16;
        ObjectHeight = 86*2+43;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}