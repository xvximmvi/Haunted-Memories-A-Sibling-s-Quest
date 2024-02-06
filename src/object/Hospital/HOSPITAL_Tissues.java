package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_Tissues extends Entity {
    public HOSPITAL_Tissues(GamePanel gamePanel) {
        super(gamePanel);
        name = "Tissues";
        ObjectWidth = 26*2+13;
        ObjectHeight = 20*2+10;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = false;

    }
}