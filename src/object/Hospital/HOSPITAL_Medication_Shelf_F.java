package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_Medication_Shelf_F extends Entity {
    public HOSPITAL_Medication_Shelf_F(GamePanel gamePanel) {
        super(gamePanel);

        name = "Medication_Shelf_F";
        ObjectWidth = 56*2+28;
        ObjectHeight = 78*2+39;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}