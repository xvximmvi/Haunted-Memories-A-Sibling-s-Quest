package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_CleaningBottle_2 extends Entity {
    public GENERAL_CleaningBottle_2(GamePanel gamePanel) {
        super(gamePanel);
        name = "CleaningBottle_2";
        ObjectWidth = 10*2+5;
        ObjectHeight = 18*2+9;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}