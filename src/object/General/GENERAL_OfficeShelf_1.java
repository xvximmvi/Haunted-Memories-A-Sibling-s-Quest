package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_OfficeShelf_1 extends Entity {
    public GENERAL_OfficeShelf_1(GamePanel gamePanel) {
        super(gamePanel);
        name = "OfficeShelf_1";
        ObjectWidth = 128*2+64;
        ObjectHeight = 96*2+48;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}