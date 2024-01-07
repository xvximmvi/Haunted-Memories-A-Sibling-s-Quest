package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_Card_2 extends Entity {
    public GENERAL_Card_2(GamePanel gamePanel) {
        super(gamePanel);
        name = "Card_2";
        ObjectWidth = 29*2+14;
        ObjectHeight = 22*2+11;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}