package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_Talking extends Entity {
    public HOSPITAL_Talking(GamePanel gamePanel) {
        super(gamePanel);
        name = "Talking";
        ObjectWidth = 28*2+14;
        ObjectHeight = 22*2+11;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}