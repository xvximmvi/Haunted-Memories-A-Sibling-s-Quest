package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_X_Ray_Shelf extends Entity {
    public HOSPITAL_X_Ray_Shelf(GamePanel gamePanel) {
        super(gamePanel);
        name = "X-Ray_Shelf";
        ObjectWidth = 64*2+32;
        ObjectHeight = 60*2+30;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}