package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_OfficeShelf_Small_1 extends Entity {
    public GENERAL_OfficeShelf_Small_1(GamePanel gamePanel) {
        super(gamePanel);
        name = "OfficeShelf_Small_1";
        ObjectWidth = 48*2+24;
        ObjectHeight = 62*2+31;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}