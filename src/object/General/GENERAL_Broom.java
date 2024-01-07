package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_Broom extends Entity {
    public GENERAL_Broom(GamePanel gamePanel) {
        super(gamePanel);
        name = "Broom";
        ObjectWidth = 15*2+7;
        ObjectHeight = 43*2+21;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}