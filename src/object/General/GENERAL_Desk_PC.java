package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_Desk_PC extends Entity {
    public GENERAL_Desk_PC(GamePanel gamePanel) {
        super(gamePanel);
        name = "Desk_PC";
        ObjectWidth = 60*2+30;
        ObjectHeight = 54*2+27;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}