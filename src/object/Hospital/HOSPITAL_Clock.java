package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_Clock extends Entity {
    public HOSPITAL_Clock(GamePanel gamePanel){
        super(gamePanel);

        name = "Clock";
        ObjectWidth = 26*2+13;
        ObjectHeight = 28*2+14;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}
