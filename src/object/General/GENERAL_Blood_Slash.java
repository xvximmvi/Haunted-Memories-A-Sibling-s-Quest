package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_Blood_Slash extends Entity {
    public GENERAL_Blood_Slash(GamePanel gamePanel) {
        super(gamePanel);
        name = "Blood_Slash";
        ObjectWidth = 142*2+71;
        ObjectHeight = 48*2+24;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}