package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_Wall_Square_Shelf_Open extends Entity {
    public HOSPITAL_Wall_Square_Shelf_Open(GamePanel gamePanel) {
        super(gamePanel);
        name = "Wall_Square_Shelf_Open";
        ObjectWidth = 59*2+30;
        ObjectHeight = 31*2+15;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}