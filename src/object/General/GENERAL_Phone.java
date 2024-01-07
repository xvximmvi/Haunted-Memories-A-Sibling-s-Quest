package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_Phone extends Entity {
    public GENERAL_Phone(GamePanel gamePanel) {
        super(gamePanel);
        name = "Phone";
        ObjectWidth = 24*2+12;
        ObjectHeight = 25*2+12;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}