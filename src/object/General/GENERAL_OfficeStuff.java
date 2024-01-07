package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_OfficeStuff extends Entity {
    public GENERAL_OfficeStuff(GamePanel gamePanel) {
        super(gamePanel);
        name = "OfficeStuff";
        ObjectWidth = 50*2+25;
        ObjectHeight = 24*2+12;
        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}