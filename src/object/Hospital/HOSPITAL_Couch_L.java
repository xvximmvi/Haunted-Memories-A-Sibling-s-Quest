package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_Couch_L extends Entity {
    public HOSPITAL_Couch_L(GamePanel gamePanel) {
        super(gamePanel);

        name = "Couch_L";
        ObjectWidth = 32*2+16;
        ObjectHeight = 94*2+47;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}