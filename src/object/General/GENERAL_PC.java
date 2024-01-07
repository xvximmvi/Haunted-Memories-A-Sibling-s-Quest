package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_PC extends Entity {
    public GENERAL_PC(GamePanel gamePanel) {
        super(gamePanel);
        name = "PC";
        ObjectWidth = 45*2+22;
        ObjectHeight = 30*2+15;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}