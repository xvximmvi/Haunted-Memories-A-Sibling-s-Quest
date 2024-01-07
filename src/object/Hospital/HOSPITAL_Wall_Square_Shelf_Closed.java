package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_Wall_Square_Shelf_Closed extends Entity {
    public HOSPITAL_Wall_Square_Shelf_Closed(GamePanel gamePanel) {
        super(gamePanel);
        name = "Wall_Square_Shelf_Closed";
        ObjectWidth = 61*2+30;
        ObjectHeight = 28*2+14;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}