package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_Medication extends Entity {
    public HOSPITAL_Medication(GamePanel gamePanel) {
        super(gamePanel);

        name = "Medication";
        ObjectWidth = 23*2+12;
        ObjectHeight = 18*2+9;

        description = "[" + name + "]\nA medicine or a chemical\ncompound used to treat\nor cure illness.";

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}