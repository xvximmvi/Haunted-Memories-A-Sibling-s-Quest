package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_Machine extends Entity {
    public GENERAL_Machine(GamePanel gamePanel) {
        super(gamePanel);
        name = "Machine";
        ObjectWidth = 44*2+22;
        ObjectHeight = 64*2+32;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}