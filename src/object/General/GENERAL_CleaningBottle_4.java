package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_CleaningBottle_4 extends Entity {
    public GENERAL_CleaningBottle_4(GamePanel gamePanel) {
        super(gamePanel);
        name = "CleaningBottle_4";
        ObjectWidth = 12*2+6;
        ObjectHeight = 22*2+11;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}