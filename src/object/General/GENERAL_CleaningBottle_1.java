package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_CleaningBottle_1 extends Entity {
    public GENERAL_CleaningBottle_1(GamePanel gamePanel) {
        super(gamePanel);
        name = "CleaningBottle_1";
        ObjectWidth = 14*2+7;
        ObjectHeight = 20*2+10;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}