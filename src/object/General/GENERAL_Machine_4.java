package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_Machine_4 extends Entity {
    public GENERAL_Machine_4(GamePanel gamePanel) {
        super(gamePanel);
        name = "Machine_4";
        ObjectWidth = 24*2+12;
        ObjectHeight = 52*2+26;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}