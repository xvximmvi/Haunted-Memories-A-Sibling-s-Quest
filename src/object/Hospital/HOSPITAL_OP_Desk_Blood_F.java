package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_OP_Desk_Blood_F extends Entity {
    public HOSPITAL_OP_Desk_Blood_F(GamePanel gamePanel) {
        super(gamePanel);
        name = "OP_Desk_Blood_F";
        ObjectWidth = 96*2+48;
        ObjectHeight = 46*2+23;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}