package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_Storage_Wall_Shelf extends Entity {
    public GENERAL_Storage_Wall_Shelf(GamePanel gamePanel) {
        super(gamePanel);
        name = "Storage_Wall_Shelf";
        ObjectWidth = 30*2+15;
        ObjectHeight = 44*2+22;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}