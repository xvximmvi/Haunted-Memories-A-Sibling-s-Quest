package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_MedicationShelf_White extends Entity {
    public HOSPITAL_MedicationShelf_White(GamePanel gamePanel) {
        super(gamePanel);

        name = "MedicationShelf_White";
        ObjectWidth = 64*2+32;
        ObjectHeight = 96*2+38;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}