package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_Machine_3 extends Entity {
    public GENERAL_Machine_3(GamePanel gamePanel) {
        super(gamePanel);
        name = "Machine_3";
        ObjectWidth = 48*3;
        ObjectHeight = 96*3;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}