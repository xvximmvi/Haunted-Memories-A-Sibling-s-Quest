package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_Microscope extends Entity {
    public HOSPITAL_Microscope(GamePanel gamePanel) {
        super(gamePanel);

        name = "Microscope";
        ObjectWidth = 13*2+6;
        ObjectHeight = 25*2+12;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}