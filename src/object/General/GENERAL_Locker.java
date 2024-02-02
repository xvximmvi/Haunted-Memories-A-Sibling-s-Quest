package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_Locker extends Entity {
    public GENERAL_Locker(GamePanel gamePanel) {
        super(gamePanel);
        name = "Locker";
        ObjectWidth = 32*3;
        ObjectHeight = 64*3;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}