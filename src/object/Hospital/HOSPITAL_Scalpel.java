package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_Scalpel extends Entity {
    public HOSPITAL_Scalpel(GamePanel gamePanel) {
        super(gamePanel);
        name = "Scalpel";
        ObjectWidth = 22*2+11;
        ObjectHeight = 5*2+2;

        description = "[" + name + "]\nA small and extremely sharp\nbladed instrument used to\nmake cuts into the body.";

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}