package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_Machine_2 extends Entity {
    public GENERAL_Machine_2(GamePanel gamePanel) {
        super(gamePanel);
        name = "Machine_2";
        ObjectWidth = 96*2+48;
        ObjectHeight = 65*2+32;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}