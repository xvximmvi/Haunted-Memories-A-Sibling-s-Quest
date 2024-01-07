package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_LaborStuff_2 extends Entity {
    public HOSPITAL_LaborStuff_2(GamePanel gamePanel) {
        super(gamePanel);

        name = "LaborStuff_2";
        ObjectWidth = 61*2+30;
        ObjectHeight = 29*2+15;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}