package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_Couch_F extends Entity {
    public HOSPITAL_Couch_F(GamePanel gamePanel) {
        super(gamePanel);

        name = "Couch_F";
        ObjectWidth = 94*2+47;
        ObjectHeight = 48*2+24;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}