package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_LaborStuff_1 extends Entity {
    public HOSPITAL_LaborStuff_1(GamePanel gamePanel) {
        super(gamePanel);

        name = "LaborStuff_1";
        ObjectWidth = 36*2+16;
        ObjectHeight = 29*2+15;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}