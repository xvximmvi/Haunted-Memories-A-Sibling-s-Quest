package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_Nightstand_F extends Entity {
    public HOSPITAL_Nightstand_F(GamePanel gamePanel) {
        super(gamePanel);
        name = "Nightstand_F";
        ObjectWidth = 32*2+16;
        ObjectHeight = 38*2+19;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}