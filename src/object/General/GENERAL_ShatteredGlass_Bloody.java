package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_ShatteredGlass_Bloody extends Entity {
    public GENERAL_ShatteredGlass_Bloody(GamePanel gamePanel) {
        super(gamePanel);
        name = "ShatteredGlass_Bloody";
        ObjectWidth = 31*2+15;
        ObjectHeight = 31*2+15;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}