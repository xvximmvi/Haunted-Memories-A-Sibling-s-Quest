package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_OP_Bath_Blood_Left extends Entity {
    public HOSPITAL_OP_Bath_Blood_Left(GamePanel gamePanel) {
        super(gamePanel);
        name = "OP_Bath_Blood_Left";
        ObjectWidth = 114*2+57;
        ObjectHeight = 50*2+25;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}