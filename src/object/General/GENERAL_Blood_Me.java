package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_Blood_Me extends Entity {
    public GENERAL_Blood_Me(GamePanel gamePanel) {
        super(gamePanel);
        name = "Blood_Me";
        ObjectWidth = 22*2+11;
        ObjectHeight = 24*2+12;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}