package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_FireExtinguisher_Glass extends Entity {
    public GENERAL_FireExtinguisher_Glass(GamePanel gamePanel) {
        super(gamePanel);
        name = "Fire_Extinguisher_Glass";
        ObjectWidth = 28*2+14;
        ObjectHeight = 38*2+19;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}