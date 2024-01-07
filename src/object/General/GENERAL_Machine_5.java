package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_Machine_5 extends Entity {
    public GENERAL_Machine_5(GamePanel gamePanel) {
        super(gamePanel);
        name = "Machine_5";
        ObjectWidth = 32*2+16;
        ObjectHeight = 52*2+26;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}