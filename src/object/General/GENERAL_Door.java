package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_Door extends Entity {
    public GENERAL_Door(GamePanel gamePanel) {
        super(gamePanel);
        name = "Door";
        ObjectWidth = 48*2+24;
        ObjectHeight = 78*2+39;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}