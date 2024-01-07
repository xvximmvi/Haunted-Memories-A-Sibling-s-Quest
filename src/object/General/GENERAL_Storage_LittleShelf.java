package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_Storage_LittleShelf extends Entity {
    public GENERAL_Storage_LittleShelf(GamePanel gamePanel) {
        super(gamePanel);
        name = "Storage_LittleShelf";
        ObjectWidth = 32*2+16;
        ObjectHeight = 31*2+15;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}