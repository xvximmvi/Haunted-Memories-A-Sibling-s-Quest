package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_MedShelf_Small_1 extends Entity {
    public HOSPITAL_MedShelf_Small_1(GamePanel gamePanel) {
        super(gamePanel);

        name = "MedShelf_Small_1";
        ObjectWidth = 26*2+13;
        ObjectHeight = 30*2+15;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}