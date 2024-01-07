package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_BloodyOrgans extends Entity {
    public GENERAL_BloodyOrgans(GamePanel gamePanel) {
        super(gamePanel);
        name = "BloodyOrgans";
        ObjectWidth = 30*2+15;
        ObjectHeight = 28*2+14;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}