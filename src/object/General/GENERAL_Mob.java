package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_Mob extends Entity {
    public GENERAL_Mob(GamePanel gamePanel) {
        super(gamePanel);
        name = "Mob";
        ObjectWidth = 18*2+9;
        ObjectHeight = 51*2+25;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}