package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_StorageShelf_Long extends Entity {
    public GENERAL_StorageShelf_Long(GamePanel gamePanel) {
        super(gamePanel);
        name = "StorageShelf_Long";
        ObjectWidth = 48*2+24;
        ObjectHeight = 96*2+48;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}