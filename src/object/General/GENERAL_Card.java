package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_Card extends Entity {
    public GENERAL_Card(GamePanel gamePanel) {
        super(gamePanel);
        name = "Card";
        ObjectWidth = 32*2+16;
        ObjectHeight = 18*2+9;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}