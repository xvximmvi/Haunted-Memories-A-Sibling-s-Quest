package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_Bones_Blood extends Entity {
    public GENERAL_Bones_Blood(GamePanel gamePanel) {
        super(gamePanel);
        name = "Bones_Blood";
        ObjectWidth = 27*2+13;
        ObjectHeight = 25*2+12;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}