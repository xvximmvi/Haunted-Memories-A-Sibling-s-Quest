package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_BabyBed extends Entity {
    public HOSPITAL_BabyBed(GamePanel gamePanel) {
        super(gamePanel);

        name = "BabyBed";
        ObjectWidth = 24*2+12;
        ObjectHeight = 24*2+12;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}