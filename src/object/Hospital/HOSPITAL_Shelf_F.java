package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_Shelf_F extends Entity {
    public HOSPITAL_Shelf_F(GamePanel gamePanel) {
        super(gamePanel);
        name = "Shelf_F";
        ObjectWidth = 58*2+29;
        ObjectHeight = 70*2+35;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}