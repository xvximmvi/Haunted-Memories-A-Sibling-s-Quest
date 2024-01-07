package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_WashingMachines extends Entity {
    public GENERAL_WashingMachines(GamePanel gamePanel) {
        super(gamePanel);
        name = "WashingMachines";
        ObjectWidth = 64*2+32;
        ObjectHeight = 48*2+24;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}