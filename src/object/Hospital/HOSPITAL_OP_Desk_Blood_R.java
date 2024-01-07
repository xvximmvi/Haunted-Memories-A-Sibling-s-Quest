package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_OP_Desk_Blood_R extends Entity {
    public HOSPITAL_OP_Desk_Blood_R(GamePanel gamePanel) {
        super(gamePanel);
        name = "OP_Desk_Blood_R";
        ObjectWidth = 30*2+15;
        ObjectHeight = 94*2+47;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}