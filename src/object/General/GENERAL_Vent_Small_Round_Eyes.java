package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_Vent_Small_Round_Eyes extends Entity {
    public GENERAL_Vent_Small_Round_Eyes(GamePanel gamePanel) {
        super(gamePanel);
        name = "Vent_Small_Round_Eyes";
        ObjectWidth = 25*2+12;
        ObjectHeight = 25*2+12;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}