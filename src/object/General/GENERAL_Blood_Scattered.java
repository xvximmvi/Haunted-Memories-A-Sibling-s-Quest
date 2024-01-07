package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_Blood_Scattered extends Entity {
    public GENERAL_Blood_Scattered(GamePanel gamePanel) {
        super(gamePanel);
        name = "Blood_Scattered";
        ObjectWidth = 86*2+43;
        ObjectHeight = 39*2+19;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}