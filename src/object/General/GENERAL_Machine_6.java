package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_Machine_6 extends Entity {
    public GENERAL_Machine_6(GamePanel gamePanel) {
        super(gamePanel);
        name = "Machine_6";
        ObjectWidth = 64*2+32;
        ObjectHeight = 85*2+42;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}