package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_CleaningBottle_3 extends Entity {
    public GENERAL_CleaningBottle_3(GamePanel gamePanel) {
        super(gamePanel);
        name = "CleaningBottle_3";
        ObjectWidth = 18*2+9;
        ObjectHeight = 20*2+10;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}