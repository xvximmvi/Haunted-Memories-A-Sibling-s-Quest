package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_Desk_1 extends Entity {
    public GENERAL_Desk_1(GamePanel gamePanel) {
        super(gamePanel);
        name = "Desk_1";
        ObjectWidth = 112*2+56;
        ObjectHeight = 59*2+29;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}