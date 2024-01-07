package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_OP_Shelf_Small_Laptop extends Entity {
    public HOSPITAL_OP_Shelf_Small_Laptop(GamePanel gamePanel) {
        super(gamePanel);
        name = "OP_Shelf_Small_Laptop";
        ObjectWidth = 45*2+22;
        ObjectHeight = 57*2+28;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}