package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_MedKit_White extends Entity {
    public HOSPITAL_MedKit_White(GamePanel gamePanel) {
        super(gamePanel);

        name = "MedKit_White";
        ObjectWidth = 22*2+11;
        ObjectHeight = 20*2+10;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}