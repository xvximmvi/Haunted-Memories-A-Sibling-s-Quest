package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_Blood_Baby extends Entity {
    public GENERAL_Blood_Baby(GamePanel gamePanel) {
        super(gamePanel);
        name = "Blood_Baby";
        ObjectWidth = 46*2+23;
        ObjectHeight = 25*2+12;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}