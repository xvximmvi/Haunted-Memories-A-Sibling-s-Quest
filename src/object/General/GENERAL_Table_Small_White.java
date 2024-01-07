package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_Table_Small_White extends Entity {
    public GENERAL_Table_Small_White(GamePanel gamePanel) {
        super(gamePanel);
        name = "Table_Small_White";
        ObjectWidth = 96*2+48;
        ObjectHeight = 58*2+29;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}