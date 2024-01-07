package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_ServerShelf_H extends Entity {
    public GENERAL_ServerShelf_H(GamePanel gamePanel) {
        super(gamePanel);
        name = "ServerShelf_H";
        ObjectWidth = 64*2+32;
        ObjectHeight = 82*2+41;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}