package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_Elevator extends Entity {
    public HOSPITAL_Elevator(GamePanel gamePanel){
        super(gamePanel);

        name = "Elevator";
        ObjectWidth = 84*2+42;
        ObjectHeight = 64*2+32;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}
