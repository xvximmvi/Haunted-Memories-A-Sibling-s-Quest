package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_Paper_1 extends Entity {
    public GENERAL_Paper_1(GamePanel gamePanel) {
        super(gamePanel);
        name = "Paper_1";
        ObjectWidth = 30*2+15;
        ObjectHeight = 26*2+13;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}