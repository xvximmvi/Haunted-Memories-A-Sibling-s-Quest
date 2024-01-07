package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_Shelf_R extends Entity {
    public HOSPITAL_Shelf_R(GamePanel gamePanel) {
        super(gamePanel);
        name = "Shelf_R";
        ObjectWidth = 28*2+14;
        ObjectHeight = 94*2+47;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}