package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_OR1_Door extends Entity {
    public HOSPITAL_OR1_Door(GamePanel gamePanel) {
        super(gamePanel);
        name = "OR1_Door";
        ObjectWidth = 32*2+16;
        ObjectHeight = 64*2+32;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}