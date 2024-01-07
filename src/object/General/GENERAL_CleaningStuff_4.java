package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_CleaningStuff_4 extends Entity {
    public GENERAL_CleaningStuff_4(GamePanel gamePanel) {
        super(gamePanel);
        name = "CleaningStuff_4";
        ObjectWidth = 58*2+29;
        ObjectHeight = 32*2+16;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}