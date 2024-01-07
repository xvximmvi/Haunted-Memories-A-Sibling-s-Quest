package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_Couch_R extends Entity {
    public HOSPITAL_Couch_R(GamePanel gamePanel) {
        super(gamePanel);

        name = "Couch_R";
        ObjectWidth = 30*2+15;
        ObjectHeight = 94*2+47;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}