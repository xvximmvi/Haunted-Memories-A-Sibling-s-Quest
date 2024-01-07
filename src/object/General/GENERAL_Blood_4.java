package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_Blood_4 extends Entity {
    public GENERAL_Blood_4(GamePanel gamePanel) {
        super(gamePanel);
        name = "Blood_4";
        ObjectWidth = 29*2+15;
        ObjectHeight = 27*2+13;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}