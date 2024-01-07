package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_Fax extends Entity {
    public GENERAL_Fax(GamePanel gamePanel) {
        super(gamePanel);
        name = "Fax";
        ObjectWidth = 34*2+17;
        ObjectHeight = 29*2+14;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}