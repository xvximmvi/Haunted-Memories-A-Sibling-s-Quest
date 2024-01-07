package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_Blood_IHateYou extends Entity {
    public GENERAL_Blood_IHateYou(GamePanel gamePanel) {
        super(gamePanel);
        name = "Blood_IHateYou";
        ObjectWidth = 134*2+67;
        ObjectHeight = 47*2+23;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}